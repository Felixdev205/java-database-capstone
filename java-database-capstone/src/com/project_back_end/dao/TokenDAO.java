/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project_back_end.dao;

/**
 *
 * @author admin
 */
import com.project_back_end.models.Token;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TokenDAO {
    private Connection conn;

    public TokenDAO(Connection conn) {
        this.conn = conn;
    }

    public List<Token> getAllTokens() throws SQLException {
        List<Token> tokens = new ArrayList<>();
        String sql = "SELECT * FROM Token";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Token t = new Token(
                    rs.getInt("id"),
                    rs.getInt("patient_id"),
                    rs.getString("token"),
                    rs.getTimestamp("expiration")
                );
                tokens.add(t);
            }
        }
        return tokens;
    }

    public boolean addToken(Token token) throws SQLException {
        String sql = "INSERT INTO Token (patient_id, token, expiration) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, token.getPatientId());
            pstmt.setString(2, token.getToken());
            pstmt.setTimestamp(3, token.getExpiration());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        }
    }

    public boolean updateToken(Token token) throws SQLException {
        String sql = "UPDATE Token SET patient_id = ?, token = ?, expiration = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, token.getPatientId());
            pstmt.setString(2, token.getToken());
            pstmt.setTimestamp(3, token.getExpiration());
            pstmt.setInt(4, token.getId());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        }
    }

    public boolean deleteToken(int tokenId) throws SQLException {
        String sql = "DELETE FROM Token WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, tokenId);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        }
    }

    public Token findTokenById(int tokenId) throws SQLException {
        String sql = "SELECT * FROM Token WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, tokenId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Token(
                        rs.getInt("id"),
                        rs.getInt("patient_id"),
                        rs.getString("token"),
                        rs.getTimestamp("expiration")
                    );
                }
            }
        }
        return null;
    }
}

