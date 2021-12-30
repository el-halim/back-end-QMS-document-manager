package ma.enset.applicationstage.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileData {

    private String description;
    private String type_doc;
    private Long processusId;
    private boolean approved;

}
