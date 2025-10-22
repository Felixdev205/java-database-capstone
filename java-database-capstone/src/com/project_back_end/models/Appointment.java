/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project_back_end.models;

/**
 *
 * @author admin
 */
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Doctor doctor;

    @ManyToOne
    private Patient patient;

    @Column(nullable = false)
    private LocalDateTime appointmentTime;

    private String status;

    // Constructors, getters, setters
}

