package ma.enset.applicationstage.service;

import ma.enset.applicationstage.dao.FileDBRepository;
import ma.enset.applicationstage.dao.ProcessusRepository;
import ma.enset.applicationstage.dao.UserRepository;
import ma.enset.applicationstage.dto.FileData;
import ma.enset.applicationstage.entities.Files;
import ma.enset.applicationstage.security.enums.TypeDoc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Service
@Transactional
public class FileStorageService {

    @Autowired
    private FileDBRepository fileDBRepository;

    @Autowired
    private ProcessusRepository processusRepository;


    public List<Files> findAllByTypeDoc(FileData fileData){

        System.out.println("test"+fileData.isApproved());

        return fileDBRepository.findAllByTypeDocAndApproved(TypeDoc.valueOf(fileData.getType_doc()),fileData.isApproved());
    }

    public Files store(MultipartFile file, FileData fileData) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        System.out.println(fileData.getDescription() +"  halim");
       // Files files1 = new Files(fileName,file.getContentType(),fileData.getDescription().replaceAll("^\"|\"$", ""),file.getBytes());
        Files files = new Files(fileName,file.getContentType(),fileData.getDescription().replaceAll("^\"|\"$", ""),file.getBytes(),processusRepository.findById(fileData.getProcessusId()).get());

        if(fileData.getType_doc().contains("fiche"))
           files.setTypeDoc(TypeDoc.fiche);


        if(fileData.getType_doc().contains("procedure")){
            files.setTypeDoc(TypeDoc.procedure);        }
        if(fileData.getType_doc().contains("enregistrement")){
            files.setTypeDoc(TypeDoc.enregistrement);        }
        if(fileData.getType_doc().contains("modeOpera")){
            files.setTypeDoc(TypeDoc.modeOpera);
        }




       // Files Files = new Files(fileName, file.getContentType(), file.getBytes());

        return fileDBRepository.save(files);
    }

    public Files getFile(String id) {
        return fileDBRepository.findById(id).get();
    }

    public Stream<Files> getAllFiles() {
        return fileDBRepository.findAll().stream();
    }

    public List<Files> findAllByTypeDocAndProcessus(FileData fileData) {
        return fileDBRepository.findAllByTypeDocAndProcessusIdEqualsAndApproved(TypeDoc.valueOf(fileData.getType_doc()),fileData.getProcessusId(),fileData.isApproved());
    }

    public void onApprove(String id) {
        fileDBRepository.onApprove(id);
    }
}
