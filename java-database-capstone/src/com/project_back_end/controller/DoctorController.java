/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project_back_end.controller;

/**
 *
 * @author admin
 */


import com.project_back_end.models.Doctor;
import java.util.Arrays;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    // Lấy danh sách giờ trống của bác sĩ dựa trên dynamic parameter id
    @GetMapping("/{id}/availableTimes")
    public ResponseEntity<List<String>> getAvailableTimes(@PathVariable int id) {
        // Mô phỏng dữ liệu; thay bằng gọi service thật khi triển khai
        List<String> availableTimes = Arrays.asList("9:00 AM", "10:00 AM", "2:00 PM");
        return ResponseEntity.ok(availableTimes);
    }

    // Ví dụ validate token - đơn giản trả về success
    @GetMapping("/{id}/validateToken")
    public ResponseEntity<String> validateToken(@PathVariable int id, @RequestParam String token) {
        // Ở đây chỉ trả về success mẫu
        if ("valid-token123".equals(token)) {
            return ResponseEntity.ok("Token is valid");
        }
        return ResponseEntity.status(401).body("Invalid token");
    }
}
