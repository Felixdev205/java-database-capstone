/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project_back_end.dao;

/**
 *
 * @author admin
 */
import com.project_back_end.models.Prescription;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PrescriptionDAO {
    private Connection conn;

    public PrescriptionDAO(Connection conn) {
        this.conn = conn;
    }

    public List<Prescription> getAllPrescriptions() throws SQLException {
        List<Prescription> prescriptions = new ArrayList<>();
        String sql = "SELECT * FROM Prescription";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Prescription p = new Prescription(
                    rs.getInt("id"),
                    rs.getInt("appointment_id"),
                    rs.getString("medicine"),
                    rs.getString("dosage")
                );
                prescriptions.add(p);
            }
        }
        return prescriptions;
    }

    public boolean addPrescription(Prescription prescription) throws SQLException {
        String sql = "INSERT INTO Prescription (appointment_id, medicine, dosage) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, prescription.getAppointmentId());
            pstmt.setString(2, prescription.getMedicine());
            pstmt.setString(3, prescription.getDosage());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        }
    }

    public boolean updatePrescription(Prescription prescription) throws SQLException {
        String sql = "UPDATE Prescription SET appointment_id = ?, medicine = ?, dosage = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, prescription.getAppointmentId());
            pstmt.setString(2, prescription.getMedicine());
            pstmt.setString(3, prescription.getDosage());
            pstmt.setInt(4, prescription.getId());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        }
    }

    public boolean deletePrescription(int prescriptionId) throws SQLException {
        String sql = "DELETE FROM Prescription WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, prescriptionId);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        }
    }

    public Prescription findPrescriptionById(int prescriptionId) throws SQLException {
        String sql = "SELECT * FROM Prescription WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, prescriptionId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Prescription(
                        rs.getInt("id"),
                        rs.getInt("appointment_id"),
                        rs.getString("medicine"),
                        rs.getString("dosage")
                    );
                }
            }
        }
        return null;
    }
}
