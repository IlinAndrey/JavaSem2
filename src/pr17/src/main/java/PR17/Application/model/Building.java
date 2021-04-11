package PR17.Application.model;

import com.sun.istack.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "building")
public class Building {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "type")
    @NotNull
    private String type;

    @CreationTimestamp
    @Column(name = "creation_date")
    private LocalDateTime creationDate;


    public Building() {

    }

    public Building(String type, LocalDateTime creationDate) {
        this.type = type;
        this.creationDate = creationDate;
    }

    public UUID getId() {
        return id;
    }




    public String getType() {
        return type;
    }

    @ManyToOne
    public Address address;

    public Address getAddress(){return address;}

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

}