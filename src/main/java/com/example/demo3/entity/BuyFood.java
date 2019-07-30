package com.example.demo3.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class BuyFood {

    @Id
    private int id;
    private String user_name;
    private Float price;
    private String re_mark;
    private Date date;

    public void setId(int id) {
        this.id = id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void setRe_mark(String re_mark) {
        this.re_mark = re_mark;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getUser_name() {
        return user_name;
    }

    public Float getPrice() {
        return price;
    }

    public String getRe_mark() {
        return re_mark;
    }

    public Date getDate() {
        return date;
    }
}
