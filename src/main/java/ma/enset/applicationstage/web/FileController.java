package ma.enset.applicationstage.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import ma.enset.applicationstage.dto.ApproveDto;
import ma.enset.applicationstage.dto.FileData;
import ma.enset.applicationstage.entities.Files;
import ma.enset.applicationstage.entities.Processus;
import ma.enset.applicationstage.entities.Service;
import ma.enset.applicationstage.message.ResponseFile;
import ma.enset.applicationstage.message.ResponseMessage;
import ma.enset.applicationstage.service.FileStorageService;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@CrossOrigin("*")
@RequestMapping("/resources")
public class FileController {

    @Autowired
    private FileStorageService storageService;



    @CrossOrigin("*")
    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file,@ModelAttribute FileData filedata  ) {
        String message = "";

   //     System.out.println(description+"  eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
        try {

           // ObjectMapper mapper = new ObjectMapper();
            //FileData fileData = mapper.readValue(filedata,FileData.class);

            System.out.println(filedata);
            System.out.println(filedata.getType_doc());



            storageService.store(file,filedata);

            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            System.out.println("erreur");
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }
    @CrossOrigin("*")
    @PostMapping("/approve")
    public ResponseEntity<Files> onApprove(@RequestBody ApproveDto approveDto){
        System.out.println(approveDto+" ebbbbbbbbbbbbbbbbbbbbbbbbbb");
        //JSONObject obj = (JSONObject) JSONValue.parse(id);
        //String idFile=obj.getAsString("id");
        System.out.println(approveDto);
        storageService.onApprove(approveDto.get_id());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin("*")
    @PostMapping("/filestype")
    public ResponseEntity<List<ResponseFile>> getFilesByTypeDoc(@RequestBody FileData fileData)  {
        System.out.println(fileData+ "jeje");



        List<ResponseFile> files= storageService.findAllByTypeDoc(fileData).stream().map(dbFile -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/resources/files/")
                    .path(dbFile.getId())
                    .toUriString();
            return new ResponseFile(
                    dbFile.getName(), fileDownloadUri, dbFile.getType(), dbFile.getData().length);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(files);
    }



    @CrossOrigin("*")
    @PostMapping("/filesprocessus")
    public ResponseEntity<List<ResponseFile>> getFilesByTypeDocAndProcessus( @RequestBody FileData fileData){
        System.out.println(fileData+ "jeje");



        List<ResponseFile> files= storageService.findAllByTypeDocAndProcessus(fileData).stream().map(dbFile -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/resources/files/")
                    .path(dbFile.getId())
                    .toUriString();
            return new ResponseFile(
                    dbFile.getName(),
                    fileDownloadUri,
                    dbFile.getType(),
                    dbFile.getData().length);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(files);
    }





    @CrossOrigin("*")
    @GetMapping("/files")
    public ResponseEntity<List<ResponseFile>> getListFiles() {
        List<ResponseFile> files = storageService.getAllFiles().map(dbFile -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/resources/files/")
                    .path(dbFile.getId())
                    .toUriString();

            return new ResponseFile(
                    dbFile.getName(),
                    fileDownloadUri,
                    dbFile.getType(),
                    dbFile.getData().length);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(files);
    }
    @CrossOrigin("*")

    @GetMapping("/files/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable String id) {
        Files files = storageService.getFile(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + files.getName() + "\"")
                .body(files.getData());
    }
}
