package PR17.Application.model;

import com.sun.istack.NotNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "address")
public class Address implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "zip_code")
    @NotNull
    private String zipCode;

    @Column(name = "creation_date")
    @NotNull
    private String creationDate;

    public Address() {

    }

//    public Manufacture(String name, String address, String middleName, String birthDate) {
//        this.name = name;
//        this.address = address;
//        this.middleName = middleName;
//        this.birthDate = birthDate;
//    }
    public Address(String zipCode, String creationDate) {
        this.zipCode = zipCode;
        this.creationDate = creationDate;
    }
    public UUID getId() {
        return id;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCreationDate() {
        return creationDate;
    }


    @Override
    public String toString() {
        return "address #" + id + " " + zipCode + " " + creationDate;
    }
}
