package com.servlet;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @ClassName: User
 * @Description:
 * @Author: 余霜
 * @Date: 2020/04/10 09:28
 * @Version: V1.0
 **/
public class User implements Serializable {
    private int id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private int type;
    private Timestamp created;
    private Timestamp updated;

    public User() {
    }

    public User(String username, String password, String email, String phone) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    public User(int id, String username, String password, String email, String phone, int type, Timestamp created, Timestamp updated) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.type = type;
        this.created = created;
        this.updated = updated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                type == user.type &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(email, user.email) &&
                Objects.equals(phone, user.phone) &&
                Objects.equals(created, user.created) &&
                Objects.equals(updated, user.updated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, email, phone, type, created, updated);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", type=" + type +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }
}
