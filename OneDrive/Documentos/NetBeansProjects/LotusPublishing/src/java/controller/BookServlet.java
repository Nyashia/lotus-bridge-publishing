/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.Bookdao;
import model.Book;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet("/BookServletController")
public class BookServlet extends HttpServlet {

    private Bookdao bookDAO;

    @Override
    public void init() {
        // Initialize your DAO with JDBC info
        bookDAO = new Bookdao(
                "jdbc:mysql://localhost:3306/publishingfinances",
                "root",
                "" // empty password
        );
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) action = "list";

        try {
            switch (action) {
                case "add" -> showAddForm(request, response);
                case "insert" -> insertBook(request, response);
                case "edit" -> showEditForm(request, response);
                case "update" -> updateBook(request, response);
                case "delete" -> deleteBook(request, response);
                default -> listBooks(request, response);
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    private void listBooks(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        List<Book> listBooks = bookDAO.listAllBooks();
        request.setAttribute("listBooks", listBooks);
        RequestDispatcher dispatcher = request.getRequestDispatcher("BookList.jsp");
        dispatcher.forward(request, response);
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("BookForm.jsp");
        dispatcher.forward(request, response);
    }

    private void insertBook(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String title = request.getParameter("title");
        int authorId = Integer.parseInt(request.getParameter("authorId"));
        Date publicationDate = Date.valueOf(request.getParameter("publicationDate")); // expects yyyy-mm-dd
        double price = Double.parseDouble(request.getParameter("price"));
        String isbn = request.getParameter("isbn");

        Book newBook = new Book(0, title, authorId, publicationDate, price, isbn);
        bookDAO.insertBook(newBook);
        response.sendRedirect("BookServlet?action=list");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        Book existingBook = bookDAO.getBook(id);
        request.setAttribute("book", existingBook);
        RequestDispatcher dispatcher = request.getRequestDispatcher("BookForm.jsp");
        dispatcher.forward(request, response);
    }

    private void updateBook(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        int authorId = Integer.parseInt(request.getParameter("authorId"));
        Date publicationDate = Date.valueOf(request.getParameter("publicationDate"));
        double price = Double.parseDouble(request.getParameter("price"));
        String isbn = request.getParameter("isbn");

        Book book = new Book(id, title, authorId, publicationDate, price, isbn);
        bookDAO.updateBook(book);
        response.sendRedirect("BookServlet?action=list");
    }

    private void deleteBook(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        bookDAO.deleteBook(id);
        response.sendRedirect("BookServlet?action=list");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
