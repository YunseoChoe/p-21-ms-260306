package com.mysite.sbb;


import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionRepository;
import com.mysite.sbb.question.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;

import java.time.LocalDateTime;

@Profile("test") // dev가 아닌 test 환경에서만 실행하도록.
@Configuration
@RequiredArgsConstructor
public class TestInitData {

    @Autowired
    @Lazy
    private TestInitData self;
    private final QuestionRepository questionRepository;
    private final QuestionService questionService;

    @Bean
    ApplicationRunner initDataRunner() {
        return args -> {

            if(this.questionRepository.count() > 0) {
                return;
            }

            for (int i = 1; i <= 300; i++) {
                String subject = String.format("테스트 데이터입니다:[%03d]", i);
                String content = "내용무";
                this.questionService.create(subject, content, null);
            }
        };
    }
}