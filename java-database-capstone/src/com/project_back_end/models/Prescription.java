/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project_back_end.models;

/**
 *
 * @author admin
 */
public class Prescription {
    private int id;
    private int appointmentId;
    private String medicine;
    private String dosage;

    public Prescription() {}

    public Prescription(int id, int appointmentId, String medicine, String dosage) {
        this.id = id;
        this.appointmentId = appointmentId;
        this.medicine = medicine;
        this.dosage = dosage;
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getAppointmentId() { return appointmentId; }
    public void setAppointmentId(int appointmentId) { this.appointmentId = appointmentId; }
    public String getMedicine() { return medicine; }
    public void setMedicine(String medicine) { this.medicine = medicine; }
    public String getDosage() { return dosage; }
    public void setDosage(String dosage) { this.dosage = dosage; }
}

