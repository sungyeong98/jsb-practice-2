package com.mysite.sbb_practice2.answer;

import com.mysite.sbb_practice2.question.Question;
import com.mysite.sbb_practice2.question.QuestionService;
import com.mysite.sbb_practice2.user.SiteUser;
import com.mysite.sbb_practice2.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.validation.Valid;
import java.security.Principal;

@RequiredArgsConstructor
@Controller
public class AnswerController {

    private final QuestionService questionService;
    private final AnswerService answerService;
    private final UserService userService;

    @PostMapping("/create/{id}")
    public String answer(@PathVariable("id") Integer id, BindingResult bindingResult, Model model, @Valid AnswerForm answerForm, Principal principal) {
        Question question = this.questionService.getQuestion(id);
        SiteUser siteUser = this.userService.getUser(principal.getName());
        if (bindingResult.hasErrors()) {
            model.addAttribute("question", question);
            return String.format("redirect:/question/detail/%s", id);
        }
        this.answerService.create(question, answerForm.getContent(), siteUser);
        return String.format("redirect:/question/detail/%s", id);
    }

}
