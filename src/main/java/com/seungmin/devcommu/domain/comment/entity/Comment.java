package com.seungmin.devcommu.domain.comment.entity;

import com.seungmin.devcommu.common.entity.BaseEntity;
import com.seungmin.devcommu.domain.post.entity.Post;
import com.seungmin.devcommu.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CommentId;

    @Column(nullable = false, length = 100)
    private String content;

    // 작성자
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // 게시글
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    // 대댓글(부모 댓글)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentComment_id")
    private Comment parentComment;

    // 대댓글 (자식 댓글)
    @OneToMany(mappedBy = "parentComment")
    private List<Comment> children = new ArrayList<>();

    public Comment(String content, User user, Post post, Comment parentComment) {
        this.content = content;
        this.user = user;
        this.post = post;
        this.parentComment = parentComment;
    }

    public void updateComment(String content) {
        this.content = content;
    }
}
