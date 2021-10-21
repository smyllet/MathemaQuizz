package StatistiquePackage;

import QuestionPackage.QuestionType;

public class Partie {
    int score;
    QuestionType questionType;

    public Partie(int score, QuestionType questionType) {
        this.score = score;
        this.questionType = questionType;
    }

    public int getScore() {
        return score;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }
}
