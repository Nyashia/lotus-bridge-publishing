/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Employee;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

    // --- Add Employee ---
    public boolean addEmployee(Employee employee) {
        String sql = "INSERT INTO employee (first_name, last_name, position, email, salary, hire_date) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            ps.setString(3, employee.getPosition());
            ps.setString(4, employee.getEmail());
            ps.setDouble(5, employee.getSalary());
            ps.setDate(6, employee.getHireDate());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // --- Get All Employees ---
    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM employee ORDER BY hire_date DESC";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(extractEmployee(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // --- Get Employee by ID ---
    public Employee getEmployeeById(int id) {
        String sql = "SELECT * FROM employee WHERE employee_id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return extractEmployee(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // --- Update Employee ---
    public boolean updateEmployee(Employee employee) {
        String sql = "UPDATE employee SET first_name=?, last_name=?, position=?, email=?, salary=?, hire_date=? " +
                     "WHERE employee_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            ps.setString(3, employee.getPosition());
            ps.setString(4, employee.getEmail());
            ps.setDouble(5, employee.getSalary());
            ps.setDate(6, employee.getHireDate());
            ps.setInt(7, employee.getEmployeeId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // --- Delete Employee ---
    public boolean deleteEmployee(int id) {
        String sql = "DELETE FROM employee WHERE employee_id = ?";

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
    private Employee extractEmployee(ResultSet rs) throws SQLException {
        return new Employee(
                rs.getInt("employee_id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("position"),
                rs.getString("email"),
                rs.getDouble("salary"),
                rs.getDate("hire_date")
        );
    }
}
