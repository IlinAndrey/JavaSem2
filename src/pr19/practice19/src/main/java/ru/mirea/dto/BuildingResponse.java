package ru.mirea.dto;

import com.sun.istack.NotNull;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Setter
@ToString
public class BuildingResponse {
    @NotNull
    private Long id;
    @NotBlank
    private String creationDate;
    @NotBlank
    private String type;
}
