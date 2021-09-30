package com.domain.reverse.springboot.domain.user;

import com.domain.reverse.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {
    @Id //PK 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK생성 규칙. 스트링부트2.0에서 GenerationType.IDENTITY를 추가해야 auto_increment가 됨
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;

    @Enumerated(EnumType.STRING) //JPA로 저장할 때 Enum값을 어떤 형태로 저장할지 결정, default : int로된 숫자,
    @Column(nullable = false)    //DB확인시 숫자 값이면 무슨 코드인지 확인이 어려우므로 String으로 저장
    private Role role;

    @Builder
    public User(String name, String email, String picture, Role role) {
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
    }

    public User update(String name, String picture) {
        this.name = name;
        this.picture = picture;

        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}
