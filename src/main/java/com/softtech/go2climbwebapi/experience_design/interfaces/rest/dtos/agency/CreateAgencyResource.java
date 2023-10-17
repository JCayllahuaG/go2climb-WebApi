package com.softtech.go2climbwebapi.experience_design.interfaces.rest.dtos.agency;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.relational.core.mapping.Column;

@Getter
@Setter
@Data
public class CreateAgencyResource {


    @NotBlank(message = "Agency name is required")
    @Size(max = 50)
    private String name;

    @Size(max = 200)
    private String brandUrl;

    @Size(max = 50)
    private String email;

    @Size(max = 100)
    private String description;

    @NotBlank(message = "Agency RUC is required")
    @Size(max = 11)
    private String ruc;

    @Size(max = 20)
    private String phone;

    @NotBlank(message = "Location is mandatory")
    String location;

    @NotNull(message = "Agency user id is required")
    @Column("user_id")
    private Integer user_id;
}
