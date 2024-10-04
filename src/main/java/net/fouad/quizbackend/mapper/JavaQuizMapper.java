package net.fouad.quizbackend.mapper;

import net.fouad.quizbackend.dao.model.JavaQuiz;
import net.fouad.quizbackend.dto.JavaQuizDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface JavaQuizMapper {

        JavaQuizMapper Instance = Mappers.getMapper(JavaQuizMapper.class);

        JavaQuizDTO javaQuizToJavaQuizDTO(JavaQuiz javaQuiz);

}
