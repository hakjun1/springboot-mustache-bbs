package com.mustache.bbs.domain.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity//jpa에서 객체로 다루겠다는 선언
@NoArgsConstructor
@Getter
public class Article {

    @Id//JPA에서는 Entity와 Id가 가장 중요
    @GeneratedValue//앞에했던 hospital에서는 쓰면안된다 아이디가 부여된 데이터를 쓰기 때문
    private Long id; // primary key를 의미

    private String title;
    private String contents;

    public Article(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

}
