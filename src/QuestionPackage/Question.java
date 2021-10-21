package QuestionPackage;

public class Question {
    private final String question;
    private final int answer;

    public Question(String question, int answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public int getAnswer() {
        return answer;
    }

    public boolean checkAnswer(int userAnswer) {
        return (userAnswer == answer);
    }
}
