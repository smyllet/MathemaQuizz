package QuestionPackage;

public interface QuestionGenerator {
    QuestionType getQuestionType();
    String getName();
    Question generateQuestion();
}
