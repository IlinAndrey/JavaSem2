package PR16.Application.model;

import com.sun.istack.NotNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "building")
public class Building implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "creation_date")
    @NotNull
    private String creationDate;

    @Column(name = "type")
    @NotNull
    private String type;


    @OneToMany(mappedBy = "building", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses = new ArrayList<>();

    public Building() {

    }

    public Building(String creationDate, String type) {
        this.creationDate = creationDate;
        this.type = type;
    }

    public void addPost(Address address) {
        addresses.add(address);
        address.setBuilding(this);
    }

    public void removePost(Address address) {
        addresses.remove(address);
        address.setBuilding(null);
    }

    public UUID getId() {
        return id;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "building #" + id + " " + creationDate + " " + type + " " ;
    }
}
