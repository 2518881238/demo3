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
    private String date;

}
