/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project_back_end.service;

/**
 *
 * @author admin
 */
import com.project_back_end.models.Doctor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DoctorService {

    // Phương thức trả về khung giờ có sẵn của bác sĩ theo ngày (giả lập dữ liệu)
    public List<String> getAvailableTimeSlots(int doctorId, String date) {
        // Giả lập danh sách khung giờ trống
        return Arrays.asList("9:00", "10:00", "14:00");
    }

    // Phương thức kiểm tra login bác sĩ
    public boolean validateDoctorLogin(String email, String password) {
        // Giả lập always true
        return true;
    }
}

