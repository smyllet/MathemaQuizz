public class AdditionQuestion {
    private String question;
    private int answer;

    public AdditionQuestion(int level) {
        int min = (int) Math.pow(10, (level - 1));
        int max = Integer.parseInt("9" + "9".repeat(Math.max(0, (level - 1))));
        int nb1 = Utils.generateRandomInt(min, max);
        int nb2 = Utils.generateRandomInt(min, max);
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
