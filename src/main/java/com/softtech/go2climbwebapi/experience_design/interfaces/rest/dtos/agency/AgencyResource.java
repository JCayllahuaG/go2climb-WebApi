package com.softtech.go2climbwebapi.experience_design.interfaces.rest.dtos.agency;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.relational.core.mapping.Column;


@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgencyResource {

    @NotNull
    Integer id;

    @NotBlank(message = "Name is mandatory")
    String name;

    String brandUrl;
    String email;
    String description;

    @NotBlank(message = "RUC is mandatory")
    String ruc;

    String phone;

    @NotBlank(message = "Location is mandatory")
    String location;

    @NotNull
    @Column("user_id")
    Integer user_id;
}

