package com.softtech.go2climbwebapi.experience_design.interfaces.rest.dtos.location;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.relational.core.mapping.Column;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateLocationResource {


    @Column("name")
    @NotBlank(message = "Location name is required")
    private String name;


}
