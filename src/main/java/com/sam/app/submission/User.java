package com.sam.app.submission;

import java.util.UUID;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
//    =UUID.randomUUID().toString();

    @Column
    private String consultantName;

    @Column
    private String submissionDate;

    @Column
    private String leadName;

    @Column
    private String rate;

    @Column
    private String salesPersonName;

    @Column
    private String technology;
    @Column
    private String implementation;
    @Column
    private String vendorName;




}