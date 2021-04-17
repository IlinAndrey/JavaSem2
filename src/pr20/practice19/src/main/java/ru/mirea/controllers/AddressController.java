package ru.mirea.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;
import ru.mirea.dto.DtoConverter;
import ru.mirea.services.AddressService;

import java.util.Map;

@Controller
@RequestMapping("addresses")
public class AddressController {
    @Autowired
    private DtoConverter dtoConverter;
    @Autowired
    private AddressService addressService;

    @GetMapping
    public String getAddresses(Map<String, Object> model) {
        model.put(
                "addresses",
                addressService.takeAllAddresses(dtoConverter::toAddressResponseList)
        );
        return "home";
    }

    @PostMapping("{addressId}")
    public String getAddress(
            @PathVariable long addressId,
            Map<String, Object> model
    ) {
        model.put(
                "address",
                addressService.takeAddressById(addressId, dtoConverter::toAddressResponse)
        );
        return "address";
    }

    @PostMapping("{addressId}/delete")
    public RedirectView delete(@PathVariable long addressId) {
        addressService.delete(addressId);
        return new RedirectView("/addresses");
    }
}
