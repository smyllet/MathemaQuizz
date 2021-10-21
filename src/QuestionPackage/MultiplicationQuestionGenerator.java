package QuestionPackage;

import main.Utils;

public class MultiplicationQuestionGenerator implements QuestionGenerator {
    @Override
    public QuestionType getQuestionType() {
        return QuestionType.MULTIPLICATION;
    }

    @Override
    public String getName() {
        return "Multiplication";
    }

    @Override
    public Question generateQuestion() {
        int min = 0;
        int max = 10;
        int nb1 = Utils.generateRandomInt(min, max);
        int nb2 = Utils.generateRandomInt(min, max);

        return new Question(nb1 + " * " + nb2, nb1*nb2);
    }
}
