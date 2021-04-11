package PR16.Application.model;

import com.sun.istack.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "zip_code")
    @NotNull
    private String zipCode;

    @CreationTimestamp
    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private Building building;

    public Address() {

    }

    public Address(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public UUID getId() {
        return id;
    }

    public String getZipCode() {
        return zipCode;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }
}
