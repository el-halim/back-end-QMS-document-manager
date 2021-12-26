package ma.enset.applicationstage.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;
import ma.enset.applicationstage.security.enums.RoleName;
import ma.enset.applicationstage.security.enums.TypeDoc;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;

@Entity
@Data
public class Files {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(length = 250)
    private String id;


    private String name;

    private String type;

    private String description;

    @Value("${some.key:false}")
    private boolean approved;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TypeDoc typeDoc;


    @Lob
    private byte[] data;


    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Processus processus;

    public Files(String name, String type, String description, byte[] data, Processus processus) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.data = data;
        this.processus = processus;
    }

    public Files(String name, String type, String description, byte[] data) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.data = data;
    }

    public Files(String name, String type, byte[] data) {
        this.name = name;
        this.type = type;
        this.data = data;
    }

    public Files() {

    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

}
