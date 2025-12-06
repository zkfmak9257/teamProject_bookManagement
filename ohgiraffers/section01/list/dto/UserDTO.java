package com.ohgiraffers.section01.list.dto;


import java.util.ArrayList;
import java.util.List;

public class UserDTO {
    private String userId;
    private String password;
    private String name;
    private List<String> rentedBooks;

    public UserDTO() {
        this.rentedBooks = new ArrayList<>();
    }

    public UserDTO(String userId, String password, String name) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.rentedBooks = new ArrayList<>();
    }

    public String getUserId() { return userId; }
    public String getPassword() { return password; }
    public String getName() { return name; }
    public List<String> getRentedBooks() { return rentedBooks; }

    public void rentBook(String title) { rentedBooks.add(title); }
    public boolean returnBook(String title) { return rentedBooks.remove(title); }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", rentedBooks=" + rentedBooks +
                '}';
    }
}
