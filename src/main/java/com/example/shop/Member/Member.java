package com.example.shop.Member;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class Member {
    @Id
    @Column(unique = true)
    String username;    //사용자의 아이디

    String password;    //비밀번호
    String displayName; //사용자 이름

}
