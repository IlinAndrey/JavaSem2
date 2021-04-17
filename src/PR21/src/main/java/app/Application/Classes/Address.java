package app.Application.Classes;

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

    @Column(name = "address_text")
    @NotNull
    private String addressText;

    public Address() {

    }
    public Address(String zipCode, String addressText) {
        this.zipCode = zipCode;
        this.addressText = addressText;
    }

    @ManyToOne
    private Building building;

    public Building getBuilding()
    {
        return building;
    }

    public UUID getId() {
        return id;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getAddressText() {
        return addressText;
    }

}
