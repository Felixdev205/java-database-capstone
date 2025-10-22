/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project_back_end.service;

/**
 *
 * @author admin
 */

import com.project_back_end.models.Appointment;
import com.project_back_end.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    // Đặt lịch mới
    public Appointment bookAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    // Lấy danh sách lịch hẹn của bác sĩ theo ngày
    public List<Appointment> getAppointmentsForDoctorOnDate(int doctorId, LocalDate date) {
        return appointmentRepository.findByDoctorIdAndAppointmentTimeBetween(
            doctorId,
            date.atStartOfDay(),
            date.plusDays(1).atStartOfDay()
        );
    }
}
