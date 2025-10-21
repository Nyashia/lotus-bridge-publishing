/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author Nyash
 */


import model.Company;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompanyDao {

    // --- Add Company ---
    public boolean addCompany(Company company) {
        String sql = "INSERT INTO company (company_name, contact_info, type) VALUES (?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, company.getCompanyName());
            ps.setString(2, company.getContactInfo());
            ps.setString(3, company.getType());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // --- Get All Companies ---
    public List<Company> getAllCompanies() {
        List<Company> list = new ArrayList<>();
        String sql = "SELECT * FROM company ORDER BY company_name";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(extractCompany(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // --- Get Company by ID ---
    public Company getCompanyById(int id) {
        String sql = "SELECT * FROM company WHERE company_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return extractCompany(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // --- Update Company ---
    public boolean updateCompany(Company company) {
        String sql = "UPDATE company SET company_name=?, contact_info=?, type=? WHERE company_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, company.getCompanyName());
            ps.setString(2, company.getContactInfo());
            ps.setString(3, company.getType());
            ps.setInt(4, company.getCompanyId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // --- Delete Company ---
    public boolean deleteCompany(int id) {
        String sql = "DELETE FROM company WHERE company_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // --- Helper Method ---
    private Company extractCompany(ResultSet rs) throws SQLException {
        return new Company(
                rs.getInt("company_id"),
                rs.getString("company_name"),
                rs.getString("contact_info"),
                rs.getString("type")
        );
    }
}
