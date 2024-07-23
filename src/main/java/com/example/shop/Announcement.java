package com.example.shop;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Announcement {
    @Id
    Long id;
    String 글제목;
    String 날짜;

}

