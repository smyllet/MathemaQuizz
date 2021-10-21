package main;

import QuestionPackage.*;
import StatistiquePackage.Classe;
import StatistiquePackage.Partie;
import StatistiquePackage.StatistiqueContainer;
import StatistiquePackage.Student;

import Exception.*;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<QuestionGenerator> questionGeneratorsAvailable = Arrays.asList(new AdditionQuestionGenerator(2), new AdditionQuestionGenerator(3), new AdditionQuestionGenerator(4), new MultiplicationQuestionGenerator(), new PositifSubtractionQuestionGenerator(1), new PositifSubtractionQuestionGenerator(2));
        StatistiqueContainer statistiqueContainer = new StatistiqueContainer();
        StatistiqueIHM statistiqueIHM = new StatistiqueIHM(statistiqueContainer);
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
                        student = statistiqueContainer.getStudentByName(name);
                    } catch (StudentDoesntExistException e) {
                        System.out.println("Il semblerais que vous soyez nouveau, dans quel classe vous trouvez vous ?");
                        String classeName = Utils.inputString("> ");
                        Classe classe;
                        try {
                            classe = statistiqueContainer.getClasseByName(classeName);
                        } catch (StudentDoesntExistException studentDoesntExistException) {
                            classe = new Classe(classeName);
                        }
                        student = new Student(name, classe);
                        statistiqueContainer.addStudent(student);
                        classe.addStudent(student);
                        statistiqueContainer.addClasse(classe);
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
