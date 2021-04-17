package ru.mirea.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@ToString
@AllArgsConstructor
public class BuildingToAddressRequest {
    @NotBlank
    private final String buildingCreationDate;
    @NotBlank
    private final String buildingType;
    @NotBlank
    private final String groupName;
}
