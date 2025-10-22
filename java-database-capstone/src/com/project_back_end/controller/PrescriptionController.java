/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project_back_end.controller;

/**
 *
 * @author admin
 */


import com.project_back_end.models.Prescription;
import com.project_back_end.services.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {
    
    @Autowired
    private PrescriptionService prescriptionService;

    @PostMapping
    public ResponseEntity<?> createPrescription(
            @RequestHeader("Authorization") String token,
            @Validated @RequestBody Prescription prescription) {
        if (!"valid-token123".equals(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
        }
        Prescription saved = prescriptionService.save(prescription);
        return ResponseEntity.ok(saved);
    }
}

