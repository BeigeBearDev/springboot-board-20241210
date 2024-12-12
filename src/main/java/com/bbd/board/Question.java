package com.bbd.board;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity // Entity 로 인식시키는 Annotation
public class Question {
    @Id
        // Primary Key 로 지정하는 Annotation
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        // 데이터를 저장할 때 해당 속성에 값을 일일이 입력하지 않아도 자동으로 1씩 증가하여 저장
    private Integer id;

    @Column(length = 200)
        // 엔티티의 속성은 테이블의 열 이름과 일치하는데 열의 세부 설정을 위해서 사용한다.
        // length 는 열의 길이를 설정할 때 사용한다.
    private String subject;

    @Column(columnDefinition = "TEXT")
        // columnDefinition 은 열 데이터의 유형이나 성격을 정의할 때 사용한다.
    private String content;

    private LocalDateTime createDate;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;

}
