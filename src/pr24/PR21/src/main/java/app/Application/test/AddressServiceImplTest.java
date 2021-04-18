package app.Application.test;

import app.Application.Classes.Address;
import app.Application.Interfaces.AddressRepository;
import app.Application.Services.AddressService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class AddressServiceImplTest {
    @Mock
    private AddressRepository addressRepository;

    @Test
    public void getAddress() {
        addressRepository =mock(AddressRepository.class);
        Address address = new Address();
        address.setAddressText("Sp");
        Address address1 = new Address();
        address1.setAddressText("Moscow");
        Mockito.when(addressRepository.findAll()).thenReturn(List.of(address,address1));
        AddressService userService = new AddressService(addressRepository);
        Assertions.assertEquals(2, userService.getAddresses().size());
        Assertions.assertEquals("Vasya",
                userService.getAddress().get(0).getAddressText());
    }
}
