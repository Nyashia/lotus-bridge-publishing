/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author Nyash
 */
import model.Transaction;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionDao {

    // --- Add a new transaction ---
    public boolean addTransaction(Transaction transaction) {
        String sql = "INSERT INTO transactions (type, amount, category, description, date, reference_id, reference_type) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, transaction.getType());
            ps.setDouble(2, transaction.getAmount());
            ps.setString(3, transaction.getCategory());
            ps.setString(4, transaction.getDescription());
            ps.setDate(5, transaction.getDate());
            if (transaction.getReferenceId() != null) {
                ps.setInt(6, transaction.getReferenceId());
            } else {
                ps.setNull(6, Types.INTEGER);
            }
            ps.setString(7, transaction.getReferenceType());

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
        }
        return false;
    }

    // --- Get all transactions ---
    public List<Transaction> getAllTransactions() {
        List<Transaction> list = new ArrayList<>();
        String sql = "SELECT * FROM transactions ORDER BY date DESC";

        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(extractTransaction(rs));
            }

        } catch (SQLException e) {
        }
        return list;
    }

    // --- Get transactions by type (income or expense) ---
    public List<Transaction> getTransactionsByType(String type) {
        List<Transaction> list = new ArrayList<>();
        String sql = "SELECT * FROM transactions WHERE type = ? ORDER BY date DESC";

        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, type);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(extractTransaction(rs));
            }

        } catch (SQLException e) {
        }
        return list;
    }

    // --- Get total amount by type ---
    public double getTotalByType(String type) {
        double total = 0;
        String sql = "SELECT SUM(amount) FROM transactions WHERE type = ?";

        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, type);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                total = rs.getDouble(1);
            }

        } catch (SQLException e) {
        }
        return total;
    }

    // --- Get recent transactions (limit 5) ---
    public List<Transaction> getRecentTransactions() {
        List<Transaction> list = new ArrayList<>();
        String sql = "SELECT * FROM transactions ORDER BY date DESC LIMIT 5";

        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(extractTransaction(rs));
            }

        } catch (SQLException e) {
        }
        return list;
    }

    // --- Delete transaction by ID ---
    public boolean deleteTransaction(int id) {
        String sql = "DELETE FROM transactions WHERE id = ?";

        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
        }
        return false;
    }

    // --- Helper method to build Transaction objects ---
    private Transaction extractTransaction(ResultSet rs) throws SQLException {
        return new Transaction(
                rs.getInt("id"),
                rs.getString("type"),
                rs.getDouble("amount"),
                rs.getString("category"),
                rs.getString("description"),
                rs.getDate("date"),
                rs.getObject("reference_id") != null ? rs.getInt("reference_id") : null,
                rs.getString("reference_type")
        );
    }
}
