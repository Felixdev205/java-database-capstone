/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project_back_end.dao;

/**
 *
 * @author admin
 */
import com.project_back_end.models.Patient;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {
    private Connection conn;

    public PatientDAO(Connection conn) {
        this.conn = conn;
    }

    public List<Patient> getAllPatients() throws SQLException {
        List<Patient> patients = new ArrayList<>();
        String sql = "SELECT * FROM Patient";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Patient p = new Patient(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getDate("dob"),
                    rs.getString("email"),
                    rs.getString("phone")
                );
                patients.add(p);
            }
        }
        return patients;
    }

    public boolean addPatient(Patient patient) throws SQLException {
        String sql = "INSERT INTO Patient (name, dob, email, phone) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, patient.getName());
            pstmt.setDate(2, new java.sql.Date(patient.getDob().getTime()));
            pstmt.setString(3, patient.getEmail());
            pstmt.setString(4, patient.getPhone());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        }
    }

    public boolean updatePatient(Patient patient) throws SQLException {
        String sql = "UPDATE Patient SET name = ?, dob = ?, email = ?, phone = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, patient.getName());
            pstmt.setDate(2, new java.sql.Date(patient.getDob().getTime()));
            pstmt.setString(3, patient.getEmail());
            pstmt.setString(4, patient.getPhone());
            pstmt.setInt(5, patient.getId());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        }
    }

    public boolean deletePatient(int patientId) throws SQLException {
        String sql = "DELETE FROM Patient WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, patientId);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        }
    }

    public Patient findPatientById(int patientId) throws SQLException {
        String sql = "SELECT * FROM Patient WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, patientId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Patient(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDate("dob"),
                        rs.getString("email"),
                        rs.getString("phone")
                    );
                }
            }
        }
        return null;
    }
}
