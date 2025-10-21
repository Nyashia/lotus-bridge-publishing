/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author Nyash
 */

import model.Author;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorDao {

    // --- Add Author ---
    public boolean addAuthor(Author author) {
        String sql = "INSERT INTO author (first_name, last_name, contact_info, royaltyRate) VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, author.getFirstName());
            ps.setString(2, author.getLastName());
            ps.setString(3, author.getContactInfo());
            ps.setDouble(4, author.getRoyaltyRate());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // --- Get All Authors ---
    public List<Author> getAllAuthors() {
        List<Author> list = new ArrayList<>();
        String sql = "SELECT * FROM author ORDER BY last_name";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(extractAuthor(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // --- Get Author by ID ---
    public Author getAuthorById(int id) {
        String sql = "SELECT * FROM author WHERE author_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return extractAuthor(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // --- Update Author ---
    public boolean updateAuthor(Author author) {
        String sql = "UPDATE author SET first_name=?, last_name=?, contact_info=?, royaltyRate=? WHERE author_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, author.getFirstName());
            ps.setString(2, author.getLastName());
            ps.setString(3, author.getContactInfo());
            ps.setDouble(4, author.getRoyaltyRate());
            ps.setInt(5, author.getAuthorId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // --- Delete Author ---
    public boolean deleteAuthor(int id) {
        String sql = "DELETE FROM author WHERE author_id = ?";

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
    private Author extractAuthor(ResultSet rs) throws SQLException {
        return new Author(
                rs.getInt("author_id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("contact_info"),
                rs.getDouble("royaltyRate")
        );
    }
}
