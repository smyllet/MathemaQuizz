package QuestionPackage;

import main.Utils;

public class AdditionQuestionGenerator implements QuestionGenerator {
    private final int level;
    public AdditionQuestionGenerator(int level) {
        this.level = level;
    }

    @Override
    public QuestionType getQuestionType() {
        return QuestionType.ADDITION;
    }

    @Override
    public String getName() {
        return "Addition à " + level + " chiffre" + ((level > 1) ? "s": "");
    }

    @Override
    public Question generateQuestion() {
        int min = (int) Math.pow(10, (level - 1));
        int max = Integer.parseInt("9" + "9".repeat(Math.max(0, (level - 1))));
        int nb1 = Utils.generateRandomInt(min, max);
        int nb2 = Utils.generateRandomInt(min, max);

        return new Question(nb1 + " + " + nb2, nb1+nb2);
    }
}
