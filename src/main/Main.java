package main;

import QuestionPackage.*;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Veuillez saisir le numéro du type de question souhaitez : ");
        List<QuestionGenerator> questionGeneratorsAvailable = Arrays.asList(new AdditionQuestionGenerator(2), new AdditionQuestionGenerator(3), new AdditionQuestionGenerator(4), new MultiplicationQuestionGenerator(), new PositifSubtractionQuestionGenerator(1), new PositifSubtractionQuestionGenerator(2));

        for(int i = 0; i < questionGeneratorsAvailable.size(); i++) {
            System.out.println(i+1 + " - " + questionGeneratorsAvailable.get(i).getName());
        }

        QuestionGenerator questionGenerator = questionGeneratorsAvailable.get(Utils.inputInt(1, questionGeneratorsAvailable.size(), "> ") - 1);

        Game game = new Game(questionGenerator);
        game.startGame();
    }
}
