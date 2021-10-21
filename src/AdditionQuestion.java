public class AdditionQuestion {
    private String question;
    private int answer;

    public AdditionQuestion() {
        int nb1 = 10 + (int)(Math.random() * ((99 - 10) + 1));
        int nb2 = 10 + (int)(Math.random() * ((99 - 10) + 1));
        this.question = nb1 + " + " + nb2;
        this.answer = nb1+nb2;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }
}
