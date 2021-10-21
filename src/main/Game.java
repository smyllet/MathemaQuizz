package main;

import QuestionPackage.Question;
import QuestionPackage.QuestionGenerator;
import StatistiquePackage.Partie;

public class Game {
    private final QuestionGenerator questionGenerator;

    public Game(QuestionGenerator questionGenerator) {
        this.questionGenerator = questionGenerator;
    }

    public Partie playGame() {
        int score = 0;
        System.out.println("Veuillez réaliser les 10 opérations suivantes : ");

        for(int i = 1; i<=10; i++) {
            Question question = questionGenerator.generateQuestion();
            System.out.println("Opération n°" + i + " : " + question.getQuestion());
            int userAnswer = Utils.inputInt("> ");
            if(userAnswer == question.getAnswer()) {
                System.out.println("Félicitation !");
                score++;
            }
            else System.out.println("Mauvaise réponse, la réponse était : " + question.getAnswer());
        }
        System.out.println("Fin de la partie, votre score est de " + score + "/10");
        return new Partie(score, questionGenerator.getQuestionType());
    }
}
