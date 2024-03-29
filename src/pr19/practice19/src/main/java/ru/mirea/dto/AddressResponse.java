package ru.mirea.dto;

import com.sun.istack.NotNull;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Setter
@ToString
public class AddressResponse {
    @NotNull
    private Long Id;
    @NotBlank
    private String addressName;
    private List<BuildingResponse> buildings;
}
