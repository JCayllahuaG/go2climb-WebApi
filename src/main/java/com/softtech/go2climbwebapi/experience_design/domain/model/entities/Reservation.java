package com.softtech.go2climbwebapi.experience_design.domain.model.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("reservations")
public class Reservation {

    @Id
    private Integer id;


    @Column("activity_id")
    private Integer activityId;
    @Column("user_id")
    private Integer userId;

    @Column("reservation_date")
    private String reservationDate;



}
