package com.softtech.go2climbwebapi.experience_design.domain.model.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


import java.util.List;


@Getter
@Data
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("agency")
public class Agency {

    @Id
    @Column("id")
    private Integer id;


    @Column("name")
    private String name;
    @Column("brand_url")
    private String brandUrl;
    @Column("email")
    private String email;
    @Column("description")
    private String description;
    @Column("ruc")
    private String ruc;
    @Column("phone")
    private String phone;
    @Column("location")
    private String location;

    @Column("user_id")
    private Integer user_id;


}
