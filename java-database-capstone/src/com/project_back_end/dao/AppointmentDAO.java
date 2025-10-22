/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project_back_end.dao;

/**
 *
 * @author admin
 */
import com.project_back_end.models.Appointment;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO {
    private Connection conn;

    public AppointmentDAO(Connection conn) {
        this.conn = conn;
    }

    public List<Appointment> getAllAppointments() throws SQLException {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM Appointment";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Appointment a = new Appointment(
                    rs.getInt("id"),
                    rs.getInt("doctor_id"),
                    rs.getInt("patient_id"),
                    rs.getDate("appointment_date"),
                    rs.getTime("appointment_time"),
                    rs.getString("status")
                );
                appointments.add(a);
            }
        }
        return appointments;
    }

    public boolean addAppointment(Appointment appointment) throws SQLException {
        String sql = "INSERT INTO Appointment (doctor_id, patient_id, appointment_date, appointment_time, status) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, appointment.getDoctorId());
            pstmt.setInt(2, appointment.getPatientId());
            pstmt.setDate(3, appointment.getAppointmentDate());
            pstmt.setTime(4, appointment.getAppointmentTime());
            pstmt.setString(5, appointment.getStatus());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        }
    }

    public boolean updateAppointment(Appointment appointment) throws SQLException {
        String sql = "UPDATE Appointment SET doctor_id = ?, patient_id = ?, appointment_date = ?, appointment_time = ?, status = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, appointment.getDoctorId());
            pstmt.setInt(2, appointment.getPatientId());
            pstmt.setDate(3, appointment.getAppointmentDate());
            pstmt.setTime(4, appointment.getAppointmentTime());
            pstmt.setString(5, appointment.getStatus());
            pstmt.setInt(6, appointment.getId());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        }
    }

    public boolean deleteAppointment(int appointmentId) throws SQLException {
        String sql = "DELETE FROM Appointment WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, appointmentId);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        }
    }

    public Appointment findAppointmentById(int appointmentId) throws SQLException {
        String sql = "SELECT * FROM Appointment WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, appointmentId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Appointment(
                        rs.getInt("id"),
                        rs.getInt("doctor_id"),
                        rs.getInt("patient_id"),
                        rs.getDate("appointment_date"),
                        rs.getTime("appointment_time"),
                        rs.getString("status")
                    );
                }
            }
        }
        return null;
    }
}

