package com.softtech.go2climbwebapi.experience_design.interfaces.rest.dtos.location;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LocationResource {

    @Column("id")
    @NotNull(message = "Location id is required")
    private Integer id;

    @Column("name")
    @NotBlank(message = "Location name is required")
    private String name;

}
