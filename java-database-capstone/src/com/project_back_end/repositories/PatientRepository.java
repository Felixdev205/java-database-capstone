/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project_back_end.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    Patient findByEmail(String email);
    List<Patient> findByEmailOrPhone(String email, String phone);
}

/**
 *
 * @author admin
 */


import com.project_back_end.models.Patient;
import java.util.List;

public interface PatientRepository {

    // Tìm patient theo email
    Patient findByEmail(String email);

    // Tìm patient theo email hoặc phone (có thể custom query nếu dùng JpaRepository)
    List<Patient> findByEmailOrPhone(String email, String phone);
}

