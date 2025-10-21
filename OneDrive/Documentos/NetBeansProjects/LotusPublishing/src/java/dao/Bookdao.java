/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Book;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDao {

    // --- Add Book ---
    public boolean addBook(Book book) {
        String sql = "INSERT INTO book (title, author_id, publication_date, price, isbn) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, book.getTitle());
            ps.setInt(2, book.getAuthorId());
            ps.setDate(3, book.getPublicationDate());
            ps.setDouble(4, book.getPrice());
            ps.setString(5, book.getIsbn());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // --- Get All Books ---
    public List<Book> getAllBooks() {
        List<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM book ORDER BY title";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(extractBook(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // --- Get Book by ID ---
    public Book getBookById(int id) {
        String sql = "SELECT * FROM book WHERE book_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return extractBook(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // --- Update Book ---
    public boolean updateBook(Book book) {
        String sql = "UPDATE book SET title=?, author_id=?, publication_date=?, price=?, isbn=? WHERE book_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, book.getTitle());
            ps.setInt(2, book.getAuthorId());
            ps.setDate(3, book.getPublicationDate());
            ps.setDouble(4, book.getPrice());
            ps.setString(5, book.getIsbn());
            ps.setInt(6, book.getBookId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // --- Delete Book ---
    public boolean deleteBook(int id) {
        String sql = "DELETE FROM book WHERE book_id = ?";

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
    private Book extractBook(ResultSet rs) throws SQLException {
        return new Book(
                rs.getInt("book_id"),
                rs.getString("title"),
                rs.getInt("author_id"),
                rs.getDate("publication_date"),
                rs.getDouble("price"),
                rs.getString("isbn")
        );
    }
}
