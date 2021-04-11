package PR15.Application.model;

import com.sun.istack.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "text")
    @NotNull
    private String text;

    @Column(name = "owner")
    @NotNull
    private UUID owner;

    public Address() {

    }

    public Address(String text, UUID owner) {
        this.text = text;
        this.owner = owner;
    }

    public UUID getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public UUID getOwner() {
        return owner;
    }
}
