/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Nyash
 */

import java.util.Date;

public class Employee {

    String firstName;
    String lastName;
    String position;
    String email;
    double salary;
    Date date;

    public Employee(String firstName, String lastName, String position, String emial, double salary, Date date) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.email = email;
        this.salary = salary;
        this.date = date;
    }

    ////////////////Setters and Getters///////////////////
     //firstName
     public String getfirstName() {
        return firstName;
    }

    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }

    //lastName
    public String getlastName() {
        return lastName;
    }

    public void setlastName(String lastName) {
        this.lastName = lastName;
    }
    //position

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    //Email

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    //Salary

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    //Date

    public Date date() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
