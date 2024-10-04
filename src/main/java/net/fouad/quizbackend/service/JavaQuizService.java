package net.fouad.quizbackend.service;

import lombok.RequiredArgsConstructor;
import net.fouad.quizbackend.dao.model.JavaQuiz;
import net.fouad.quizbackend.dao.repository.JavaQuizRepository;
import net.fouad.quizbackend.dto.AnswerCheckResponse;
import net.fouad.quizbackend.dto.JavaQuizDTO;
import net.fouad.quizbackend.mapper.JavaQuizMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JavaQuizService {

    private final JavaQuizRepository javaQuizRepository;


    public List<JavaQuizDTO> getAllJavaQuizQuestions() {
        return javaQuizRepository.findAll().stream()
                .map(JavaQuizMapper.Instance::javaQuizToJavaQuizDTO)
                .toList();
    }

    public JavaQuizDTO getJavaQuizQuetionById(Long id) {
        return javaQuizRepository.findById(id).map(JavaQuizMapper.Instance::javaQuizToJavaQuizDTO).
                orElseThrow( () ->  new IllegalArgumentException("Java quiz question not found"));
    }

    public JavaQuizDTO addJavaQuizQuestion(JavaQuiz javaQuiz) {
        return JavaQuizMapper.Instance.javaQuizToJavaQuizDTO(javaQuizRepository.save(javaQuiz));
    }

    public JavaQuizDTO deleteJavaQuizQuestion(Long id) {
        JavaQuiz javaQuiz = javaQuizRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Java quiz question not found to delete"));

        javaQuizRepository.delete(javaQuiz);
         return JavaQuizMapper.Instance.javaQuizToJavaQuizDTO(javaQuiz);
    }

    public ResponseEntity<AnswerCheckResponse> isAnswerCorrect(Long id, String answer) {
        JavaQuiz javaQuiz = javaQuizRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Java quiz question not found"));
        boolean isCorrect =  javaQuiz.getAnswer().equals(answer);
        String message = isCorrect ? "Correct answer" : "Incorrect answer";

        return ResponseEntity.ok(
                AnswerCheckResponse.builder()
                        .correctAnswer(javaQuiz.getAnswer())
                        .isCorrect(isCorrect)
                        .message(message)
                        .build());
    }
}
