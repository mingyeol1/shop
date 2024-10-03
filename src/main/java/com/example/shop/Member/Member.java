package com.example.shop.Member;


import com.example.shop.sales.Sales;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(unique = true)
    String username;    //사용자의 아이디

    String password;    //비밀번호
    String displayName; //사용자 이름

    @ToString.Exclude //ToString 해제하는 문법.
    @OneToMany(mappedBy = "member")
    List<Sales> sales = new ArrayList<>();
}