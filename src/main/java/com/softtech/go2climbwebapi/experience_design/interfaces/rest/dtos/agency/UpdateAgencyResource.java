package com.softtech.go2climbwebapi.experience_design.interfaces.rest.dtos.agency;

import jakarta.validation.constraints.NotBlank;


import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.relational.core.mapping.Column;


@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAgencyResource {

    @NotBlank(message = "Agency name is required")
    @Size(max = 50)
    private String name;

    @Size(max = 200)
    String brandUrl;

    @Size(max = 50)
    String email;

    @Size(max = 100)
    String description;

    @NotBlank(message = "Agency RUC is required")
    @Size(max = 11)
    String ruc;

    @Size(max = 20)
    String phone;

    @NotBlank(message = "Agency location is required")
    String location;

    @Column("user_id")
    private Integer user_id;

}
