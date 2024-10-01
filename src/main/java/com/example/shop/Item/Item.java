package com.example.shop.Item;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity //테이블 생성.
@Setter
@Getter
@ToString
@Table(indexes = @Index(columnList = "title", name = "작명"))
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title;
    Integer price;
    String username;
    @Column(length = 1000)
    String filename;
}
