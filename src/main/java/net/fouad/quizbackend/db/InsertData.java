package net.fouad.quizbackend.db;

import net.fouad.quizbackend.dao.model.JavaQuiz;
import net.fouad.quizbackend.dao.repository.JavaQuizRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InsertData {

    @Bean
    public CommandLineRunner commandLineRunner(JavaQuizRepository javaLangRepository) {
        return args -> {
            JavaQuiz javaLang0 = JavaQuiz.builder()
                    .question("What is the size of int variable?")
                    .answer("4 bytes")
                    .options(List.of("2 bytes", "4 bytes", "8 bytes", "Depends on the system architecture"))
                    .build();

            JavaQuiz javaLang1 = JavaQuiz.builder()
                    .question("What is the default value of char variable?")
                    .answer("0000j")
                    .options(List.of("000", "'0'", "null", "not defined"))
                    .build();

            JavaQuiz javaLang2 = JavaQuiz.builder()
                    .question("What is the default value of char variable?")
                    .answer("0000j")
                    .options(List.of("000", "0", "null", "not defined"))
                    .build();

            JavaQuiz javaLang3 = JavaQuiz.builder()
                    .question("What is the default value of char variable?")
                    .answer("0000j")
                    .options(List.of("000", "0", "null", "not defined"))
                    .build();

            javaLangRepository.save(javaLang0);
            javaLangRepository.save(javaLang1);
            javaLangRepository.save(javaLang2);
            javaLangRepository.save(javaLang3);
        };
    }
}
