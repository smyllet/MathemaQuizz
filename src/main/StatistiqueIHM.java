package main;

import QuestionPackage.QuestionType;
import StatistiquePackage.*;

import Exception.*;

import java.util.HashMap;

public class StatistiqueIHM {
    StatistiqueContainer statistiqueContainer;

    public StatistiqueIHM(StatistiqueContainer statistiqueContainer) {
        this.statistiqueContainer = statistiqueContainer;
    }

    private QuestionType selectQuestionType() {
        System.out.println("1 - Global");

        for(int i = 0; i < QuestionType.values().length; i++) {
            System.out.println(i+2 + " - " + QuestionType.values()[i]);
        }

        int choix = Utils.inputInt(1, QuestionType.values().length+1, "> ");

        if(choix == 1) return null;
        else return QuestionType.values()[choix-2];
    }

    private void printStatistique(StudentStatistique statistique) {
        System.out.println(" - Meilleur score : " + statistique.getBestScore());
        System.out.println(" - Nombre de tentative : " + statistique.getTentative());
        System.out.println(" - Moyenne : " + statistique.getMoyenne());
        System.out.println(" - Nombre d'entrainement : " + statistique.getTentative());
    }

    private void printStatistique(ClasseStatistique statistique) {
        System.out.println(" - Moyenne meilleur score : " + statistique.getMoyenneBestScore());
        System.out.println(" - Nombre moyen de tentative : " + statistique.getNbMoyenTentative());
        System.out.println(" - Nombre moyen d'entrainement : " + statistique.getNbMoyenEntrainement());
    }

    public void run() {
        System.out.println("Menu de gestion des statistique");

        boolean exit = false;

        while (!exit) {
            System.out.println("Choisissez parmi : ");
            System.out.println("1 - Statistique par élève");
            System.out.println("2 - Statistique par classe");
            System.out.println("3 - Liste des élèves");
            System.out.println("4 - Liste des classes");
            System.out.println("5 - Retour au menu principal");

            int choix = Utils.inputInt(1, 5, "> ");
            switch (choix) {
                case 1 -> {
                    System.out.println("Saisissez le nom de l'élève que vous souhaitez consulter ou saisissez 'retour' pour revenir à la gestion des statistiques");
                    String name = Utils.inputString("> ");
                    if(!name.equalsIgnoreCase("retour")) {
                        try {
                            Student student = statistiqueContainer.getStudentByName(name);
                            System.out.println("Pour quel type de question souhaitez vous voir les statistiques");
                            QuestionType questionType = selectQuestionType();
                            StudentStatistique statistique;
                            if(questionType == null) {
                                System.out.println("Statistique global de l'élève : " + student.getName());
                                statistique = student.getGlobalStatistique();
                            } else {
                                System.out.println("Statistique pour les questions de type '" + questionType + "' de l'élève : " + student.getName());
                                statistique = student.getStatistiqueForQuestionType(questionType);
                            }

                            printStatistique(statistique);
                        } catch (StudentDoesntExistException e) {
                            System.out.println("Elève introuvable");
                        }
                    }
                }
                case 2 -> {
                    System.out.println("Saisissez le nom de la classe que vous souhaitez consulter ou saisissez 'retour' pour revenir à la gestion des statistiques");
                    String name = Utils.inputString("> ");
                    if(!name.equalsIgnoreCase("retour")) {
                        try {
                            Classe classe = statistiqueContainer.getClasseByName(name);

                            System.out.println("Quel type de statistique ? ");
                            System.out.println("1 - Résultat des élèves");
                            System.out.println("2 - Résultat de la classe");
                            int typeResult = Utils.inputInt(1, 2, "> ");
                            System.out.println("Pour quel type de question souhaitez vous voir les statistiques");
                            QuestionType questionType = selectQuestionType();
                            if(typeResult == 1) {
                                HashMap<Student, StudentStatistique> statistique;
                                if(questionType == null) {
                                    System.out.println("Statistique global des élèves de la classe : " + classe.getName());
                                    statistique = classe.getGlobalStatistiqueByStudent();
                                } else {
                                    System.out.println("Statistique pour les questions de type '" + questionType + "' des élèves de la classe : " + classe.getName());
                                    statistique = classe.getStatistiqueByStudentForQuestionType(questionType);
                                }

                                statistique.forEach((key, value) -> {
                                    System.out.println(key.getName() + " : ");
                                    printStatistique(value);
                                });
                            } else {
                                ClasseStatistique statistique;
                                if(questionType == null) {
                                    System.out.println("Statistique global de la classe : " + classe.getName());
                                    statistique = classe.getGlobalStatistique();
                                } else {
                                    System.out.println("Statistique pour les questions de type '" + questionType + "' de la classe : " + classe.getName());
                                    statistique = classe.getStatistiqueForQuestionType(questionType);
                                }

                                printStatistique(statistique);
                            }
                        } catch (StudentDoesntExistException e) {
                            System.out.println("Classe introuvable");
                        }
                    }
                }
                case 3 -> {
                    System.out.println("Voici la liste des élèves : ");
                    for(Student student : statistiqueContainer.getStudents()) {
                        System.out.println(" - " + student.getName());
                    }
                }
                case 4 -> {
                    System.out.println("Voici la liste des classes : ");
                    for(Classe classe : statistiqueContainer.getClasses()) {
                        System.out.println(" - " + classe.getName());
                    }
                }
                case 5 -> exit = true;
            }
        }
    }
}
