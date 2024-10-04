package net.fouad.quizbackend.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnswerCheckResponse {
    private boolean isCorrect;
    private String correctAnswer;
    private String message;
}
