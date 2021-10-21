public class Game {
    public void startGame() {
        AdditionQuestion question = new AdditionQuestion();
        System.out.println("Réalisez l'opération suivante : " + question.getQuestion());
        int userAnswer = Utils.inputInt(0, 198, "> ");
        if(userAnswer == question.getAnswer()) System.out.println("Félicitation !");
        else System.out.println("Mauvaise réponse, la réponse était : " + question.getAnswer());
    }
}
