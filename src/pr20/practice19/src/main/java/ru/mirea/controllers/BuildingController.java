package ru.mirea.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;
import ru.mirea.dto.BuildingToAddressRequest;
import ru.mirea.services.BuildingService;

import javax.validation.Valid;

@Controller
@RequestMapping("buildings")
public class BuildingController {
    @Autowired
    private BuildingService buildingService;

    @PostMapping("add")
    public RedirectView add(
            @Valid @ModelAttribute("addBuilding") BuildingToAddressRequest buildingToAddressRequest,
            BindingResult result
    ) {
        if (!result.hasErrors()) {
            buildingService.publish(buildingToAddressRequest);
            buildingService.publish(buildingToAddressRequest);
        }
        return new RedirectView("/addresses");
    }

    @PostMapping("{buildingId}/delete")
    public RedirectView delete(@PathVariable long buildingId) {
        buildingService.delete(buildingId);
        return new RedirectView("/addresses");
    }
}
