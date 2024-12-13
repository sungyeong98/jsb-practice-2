package com.mysite.sbb_practice2.answer;

import com.mysite.sbb_practice2.question.Question;
import com.mysite.sbb_practice2.user.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class AnswerService {

    private final AnswerRepository answerRepository;

    public Answer create(Question question, String content, SiteUser author) {
        Answer answer = new Answer();
        answer.setQuestion(question);
        answer.setCreateDate(LocalDateTime.now());
        answer.setContent(content);
        answer.setAuthor(author);
        this.answerRepository.save(answer);
        return answer;
    }

}
