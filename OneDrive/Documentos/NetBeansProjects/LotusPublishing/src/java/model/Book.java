/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Nyash
 */
import java.sql.Date;

public class Book {

    private int bookId;
    private String title;
    private int authorId;
    private Date publicationDate;
    private double price;
    private String isbn;

    // --- Constructors ---
    public Book() {
    }

    public Book(int bookId, String title, int authorId, Date publicationDate, double price, String isbn) {
        this.bookId = bookId;
        this.title = title;
        this.authorId = authorId;
        this.publicationDate = publicationDate;
        this.price = price;
        this.isbn = isbn;
    }

    // Overloaded constructor (without ID for inserts)
    public Book(String title, int authorId, Date publicationDate, double price, String isbn) {
        this.title = title;
        this.authorId = authorId;
        this.publicationDate = publicationDate;
        this.price = price;
        this.isbn = isbn;
    }

    // --- Getters and Setters ---
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book{"
                + "bookId=" + bookId
                + ", title='" + title + '\''
                + ", authorId=" + authorId
                + ", publicationDate=" + publicationDate
                + ", price=" + price
                + ", isbn='" + isbn + '\''
                + '}';
    }
}
