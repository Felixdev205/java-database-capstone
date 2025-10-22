/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project_back_end.models;

/**
 *
 * @author admin
 */
import java.sql.Timestamp;

public class Token {
    private int id;
    private int patientId;
    private String token;
    private Timestamp expiration;

    public Token() {}

    public Token(int id, int patientId, String token, Timestamp expiration) {
        this.id = id;
        this.patientId = patientId;
        this.token = token;
        this.expiration = expiration;
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getPatientId() { return patientId; }
    public void setPatientId(int patientId) { this.patientId = patientId; }
    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }
    public Timestamp getExpiration() { return expiration; }
    public void setExpiration(Timestamp expiration) { this.expiration = expiration; }
}

