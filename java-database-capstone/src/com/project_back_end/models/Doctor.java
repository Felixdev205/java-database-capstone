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
import java.util.List;

@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String specialty;
    private String email;
    private String phone;

    @ElementCollection
    private List<String> availableTimes; // Đúng yêu cầu đề bài

    // constructors, getters, setters
}


