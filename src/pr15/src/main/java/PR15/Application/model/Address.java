package PR15.Application.model;

import com.sun.istack.NotNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "address_text")
    @NotNull
    private String addressText;

    @Column(name = "zip_code")
    @NotNull
    private UUID zipCode;

    public Address() {

    }

    public Address(String addressText, UUID zipCode) {
        this.addressText = addressText;
        this.zipCode = zipCode;
    }

    public UUID getId() {
        return id;
    }

    public String getAddressText() {
        return addressText;
    }

    public UUID getZipCode() {
        return zipCode;
    }
}
