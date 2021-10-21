package main;

import QuestionPackage.*;
import StatistiquePackage.Partie;
import StatistiquePackage.Statistique;
import StatistiquePackage.Student;

import Exception.*;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<QuestionGenerator> questionGeneratorsAvailable = Arrays.asList(new AdditionQuestionGenerator(2), new AdditionQuestionGenerator(3), new AdditionQuestionGenerator(4), new MultiplicationQuestionGenerator(), new PositifSubtractionQuestionGenerator(1), new PositifSubtractionQuestionGenerator(2));
        Statistique statistique = new Statistique();
        StatistiqueIHM statistiqueIHM = new StatistiqueIHM(statistique);
        boolean exit = false;

        while (!exit) {
            System.out.println("Veuillez saisir le numéro de l'action souhaitez : ");
            System.out.println("1 - Commencer un exercice");
            System.out.println("2 - Consulter les statistiques");
            System.out.println("3 - Quitter");

            int choix = Utils.inputInt(1, 3, "> ");

            switch (choix) {
                case 1 -> {
                    System.out.println("Veuillez saisir votre nom");
                    String name = Utils.inputString("> ");
                    Student student;
                    try {
                        student = statistique.getStudentByName(name);
                    } catch (StudentDoesntExistException e) {
                        student = new Student(name);
                        statistique.addStudent(student);
                    }
                    System.out.println("Veuillez saisir le numéro du type de question souhaitez : ");
                    for (int i = 0; i < questionGeneratorsAvailable.size(); i++) {
                        System.out.println(i + 1 + " - " + questionGeneratorsAvailable.get(i).getName());
                    }
                    QuestionGenerator questionGenerator = questionGeneratorsAvailable.get(Utils.inputInt(1, questionGeneratorsAvailable.size(), "> ") - 1);
                    Game game = new Game(questionGenerator);

                    System.out.println("Il s'agit : ");
                    System.out.println("1 - D'un entrainement");
                    System.out.println("2 - D'une evaluation");

                    boolean evaluation = Utils.inputInt(1, 2, "> ") == 2;

                    Partie partie = game.playGame();
                    if(evaluation) student.addParties(partie);
                    else student.addEntrainement(partie);
                }
                case 2 -> statistiqueIHM.run();
                case 3 -> {
                    exit = true;
                    System.out.println("Fin de la session");
                }
                default -> System.out.println("Saisie invalide");
            }

            if(!exit) System.out.println("Retour au menu principal . . .");
        }
    }
}
