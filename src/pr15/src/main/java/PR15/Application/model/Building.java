package PR15.Application.model;

import com.sun.istack.NotNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "building")
public class    Building implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "type")
    @NotNull
    private String type;

    @Column(name = "creation_date")
    @NotNull
    private String creationDate;

    public Building() {

    }

    public Building(String type, String creationDate, String middleName, String birthDate) {
        this.type = type;
        this.creationDate = creationDate;
    }

    public UUID getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getCreationDate() {
        return creationDate;
    }


    @Override
    public String toString() {
        return "building #" + id + " " + type + " " + creationDate + " " ;
    }
}
