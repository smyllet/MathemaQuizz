import jdk.jshell.execution.Util;

public class Game {
    public void startGame() {
        int score = 0;
        System.out.println("Veuillez réaliser les 10 opérations suivantes : ");
        System.out.println("Souhaitez vous des additions portant sur des nombre à 2, 3 ou 4 chiffres");
        int level = Utils.inputInt(2, 4, "> ");
        for(int i = 1; i<=10; i++) {
            AdditionQuestion question = new AdditionQuestion(level);
            System.out.println("Opération n°" + i + " : " + question.getQuestion());
            int userAnswer = Utils.inputInt(0, 198, "> ");
            if(userAnswer == question.getAnswer()) {
                System.out.println("Félicitation !");
                score++;
            }
            else System.out.println("Mauvaise réponse, la réponse était : " + question.getAnswer());
        }
        System.out.println("Fin de la partie, votre score est de " + score + "/10");
    }
}
