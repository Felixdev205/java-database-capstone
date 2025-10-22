/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project_back_end.dao;

/**
 *
 * @author admin
 */
import com.project_back_end.models.Doctor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {
    private Connection conn;

    // Constructor takes a database connection to use
    public DoctorDAO(Connection conn) {
        this.conn = conn;
    }

    // Retrieve all doctors from the Doctor table
    public List<Doctor> getAllDoctors() throws SQLException {
        List<Doctor> doctors = new ArrayList<>();
        String sql = "SELECT * FROM Doctor";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Doctor d = new Doctor(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("specialty"),
                    rs.getString("email"),
                    rs.getString("phone")
                );
                doctors.add(d);
            }
        }
        return doctors;
    }

    // Add a new doctor record
    public boolean addDoctor(Doctor doctor) throws SQLException {
        String sql = "INSERT INTO Doctor (name, specialty, email, phone) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, doctor.getName());
            pstmt.setString(2, doctor.getSpecialty());
            pstmt.setString(3, doctor.getEmail());
            pstmt.setString(4, doctor.getPhone());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        }
    }

    // Update existing doctor record by ID
    public boolean updateDoctor(Doctor doctor) throws SQLException {
        String sql = "UPDATE Doctor SET name = ?, specialty = ?, email = ?, phone = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, doctor.getName());
            pstmt.setString(2, doctor.getSpecialty());
            pstmt.setString(3, doctor.getEmail());
            pstmt.setString(4, doctor.getPhone());
            pstmt.setInt(5, doctor.getId());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        }
    }

    // Delete doctor record by ID
    public boolean deleteDoctor(int doctorId) throws SQLException {
        String sql = "DELETE FROM Doctor WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, doctorId);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        }
    }

    // Find doctor by ID
    public Doctor findDoctorById(int doctorId) throws SQLException {
        String sql = "SELECT * FROM Doctor WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, doctorId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Doctor(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("specialty"),
                        rs.getString("email"),
                        rs.getString("phone")
                    );
                }
            }
        }
        return null; // Not found
    }
}


