package com.bbd.board;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class SbbApplicationTests {

    @Autowired
    private QuestionRepository questionRepository;

    @Test
    @DisplayName("질문 데이터로 ID 데이터를 조회할 수 있어야 한다.")
    void testJpa4() {
        Question q = this.questionRepository.findBySubject("sbb가 무엇인가요?");
        assertEquals(13, q.getId());
    }

    @Test
    @DisplayName("기본키인 id로 데이터를 조회할 수 있어야 한다.")
    void testJpa3() {
        Optional<Question> optionalQuestion = this.questionRepository.findById(13);
        if(optionalQuestion.isPresent()) {
            Question q = optionalQuestion.get();
            assertEquals("sbb가 무엇인가요?", q.getSubject());
        }
    }

    @Test
    @DisplayName("모든 질문 데이터를 조회할 수 있어야 한다.")
    void testJpa2() {
        List<Question> all = this.questionRepository.findAll();
        assertEquals(2, all.size());

        Question q = all.get(0);
        assertEquals("sbb가 무엇인가요?", q.getSubject()); // (기댓값, 실제값)
    }

//    @Test // 테스트 메소드를 의미.
//    void testJpa1() {
//        Question q1 = new Question();
//        q1.setSubject("sbb가 무엇인가요?");
//        q1.setContent("sbb에 대해서 알고 싶습니다.");
//        q1.setCreateDate(LocalDateTime.now());
//        this.questionRepository.save(q1); // 첫번째 질문 저장
//        Question q2 = new Question();
//        q2.setSubject("스프링부트 모델 질문입니다.");
//        q2.setContent("id는 자동으로 생성되나요?");
//        q2.setCreateDate(LocalDateTime.now());
//        this.questionRepository.save(q2); // 두번째 질문 저장
//    }
}
