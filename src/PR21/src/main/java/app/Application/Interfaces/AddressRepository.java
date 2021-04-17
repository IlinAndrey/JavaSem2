package app.Application.Interfaces;

import app.Application.Classes.Address;
import com.sun.istack.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository("AddressRepository")
public interface AddressRepository extends JpaRepository<Address,Long> {
    List<Address> findAllByAddressText(String addressText);
    List<Address> findAllByAddressTextAndZipCode(String addressText, String zipCode);
    List<Address> findAllByZipCode(String zipCode);
    Address findById(UUID id);
    @NotNull List<Address> findAll();
    void deleteById(UUID id);
}