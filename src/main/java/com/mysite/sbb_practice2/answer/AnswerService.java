package com.mysite.sbb_practice2.answer;

import com.mysite.sbb_practice2.question.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class AnswerService {

    private final AnswerRepository answerRepository;

    public void create(Question question, String content) {
        Answer answer = new Answer();
        answer.setQuestion(question);
        answer.setCreateDate(LocalDateTime.now());
        answer.setContent(content);
        this.answerRepository.save(answer);
    }

}
