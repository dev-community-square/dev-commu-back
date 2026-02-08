package com.seungmin.devcommu.domain.user.entity;

import com.seungmin.devcommu.common.entity.BaseEntity;
import com.seungmin.devcommu.domain.user.enums.Role;
import com.seungmin.devcommu.domain.user.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Email
    @Column(unique = true, nullable = false, length = 255)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false, length = 100)
    private String nickname;

    @Enumerated(EnumType.STRING)
    private Role role;
    @Enumerated(EnumType.STRING)
    private Status status;

    public User(String email, String password, String nickname, Role role, Status status) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.role = role;
        this.status = status;
    }

    public void updatePassword(String password) {
        this.password = password;
    }
    public void updateNickname(String nickname) {
        this.nickname = nickname;
    }
    public void changeStatus(Status status) {
        this.status = status;
    }
}
