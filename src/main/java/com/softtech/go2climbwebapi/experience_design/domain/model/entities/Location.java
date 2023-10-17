package com.softtech.go2climbwebapi.experience_design.domain.model.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("location")
@Getter
@Data
@Setter
public class Location {

    @Id
    private Integer id;
    private String name;

}
