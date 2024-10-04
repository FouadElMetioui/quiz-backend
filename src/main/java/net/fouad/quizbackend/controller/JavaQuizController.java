package net.fouad.quizbackend.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import net.fouad.quizbackend.dao.model.JavaQuiz;
import net.fouad.quizbackend.dto.AnswerCheckResponse;
import net.fouad.quizbackend.dto.JavaQuizDTO;
import net.fouad.quizbackend.service.JavaQuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@ApiResponse(description = "Java quiz questions and answers")
@RequestMapping("/api/v1/java")
public class JavaQuizController {

    private final JavaQuizService javaLangService;

    @Operation(summary = "Get all Java quiz questions",
            description = "Get all Java quiz questions , answers and their options")
    @GetMapping
    public List<JavaQuizDTO> getJavaLangQuestions() {
        return javaLangService.getAllJavaQuizQuestions();
    }

    @Operation(summary = "Add a Java quiz question",
            description = "Add a Java quiz question with its answer and options")
    @PostMapping
    public JavaQuizDTO addJavaLangQuestion(@RequestParam JavaQuiz javaLangQuestion) {
       return javaLangService.addJavaQuizQuestion(javaLangQuestion);
    }

    @Operation(summary = "delete a Java quiz question",
            description = "delete a Java quiz question with its answer and options")
    @DeleteMapping
    public JavaQuizDTO deleteJavaLangQuestion(@RequestParam Long id) {
        return javaLangService.deleteJavaQuizQuestion(id);
    }

    @Operation(summary = "Check if the answer is correct",
            description = "Check if the answer is correct for a Java quiz question")
    @GetMapping("/check")
    public ResponseEntity<AnswerCheckResponse> isAnswerCorrect(@RequestParam Long id, @RequestParam String answer) {
      return javaLangService.isAnswerCorrect(id, answer);

    }

    @Operation(summary = "Get a Java quiz question by id",
            description = "Get a Java quiz question by id")
    @GetMapping("/{id}")
    public JavaQuizDTO getJavaLangQuestionById(@PathVariable Long id) {
        return javaLangService.getJavaQuizQuetionById(id);
    }
}
