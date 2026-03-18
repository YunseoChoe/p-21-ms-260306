package com.mysite.sbb.answer;

import com.mysite.sbb.question.Question;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import com.mysite.sbb.user.SiteUser;

@Entity
@Getter
@Setter // 기본적으로 Entity에 Setter을 붙이지 않음.
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    @ManyToOne // Question 테이블의 기본키를 참조함.
    private Question question;

    @ManyToOne
    private SiteUser author;
}