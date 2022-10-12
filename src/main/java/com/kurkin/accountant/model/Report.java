package com.kurkin.accountant.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import java.time.LocalDate;
@Data
@Embeddable
public class Report {

    @Column(nullable = false, updatable = false)
    private String userName;

    @Column(nullable = false, updatable = false)
    private String task;

    @Column(name = "created")
    private LocalDate timeOfTrack;


}
