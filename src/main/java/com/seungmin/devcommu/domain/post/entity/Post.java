package com.seungmin.devcommu.domain.post.entity;

import com.seungmin.devcommu.common.entity.BaseEntity;
import com.seungmin.devcommu.domain.post.enums.Category;
import com.seungmin.devcommu.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    private String title;
    private String content;
    private String code_block;

    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne
    private User user;
}
