package main;

import QuestionPackage.QuestionType;
import StatistiquePackage.Statistique;
import StatistiquePackage.Student;

import Exception.*;

import java.util.HashMap;

public class StatistiqueIHM {
    Statistique statistique;

    public StatistiqueIHM(Statistique statistique) {
        this.statistique = statistique;
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

    public void run() {
        System.out.println("Menu de gestion des statistique");

        boolean exit = false;

        while (!exit) {
            System.out.println("Choisissez parmi : ");
            System.out.println("1 - Statistique par élève");
            System.out.println("2 - Liste des élèves");
            System.out.println("3 - Retour au menu principal");

            int choix = Utils.inputInt(1, 3, "> ");
            switch (choix) {
                case 1 -> {
                    System.out.println("Saisissez le nom de l'élève que vous souhaitez consulter ou saisissez 'retour' pour revenir à la gestion des statistiques");
                    String name = Utils.inputString("> ");
                    if(!name.equalsIgnoreCase("retour")) {
                        try {
                            Student student = statistique.getStudentByName(name);
                            System.out.println("Pour quel type de question souhaitez vous voir les statistiques");
                            QuestionType questionType = selectQuestionType();
                            HashMap<String, Double> statsMap;
                            if(questionType == null) {
                                System.out.println("Statistique global de l'élève : " + student.getName());
                                statsMap = student.getStatistiqueMap();
                            } else {
                                System.out.println("Statistique pour les questions de type '" + questionType + "' de l'élève : " + student.getName());
                                statsMap = student.getStatistiqueMapForQuestionType(questionType);
                            }

                            statsMap.forEach((key, value) -> System.out.println(" - " + key + " : " + value));
                        } catch (StudentDoesntExistException e) {
                            System.out.println("Elève introuvable");
                        }
                    }
                }
                case 2 -> {
                    System.out.println("Voici la liste des élèves : ");
                    for(Student student : statistique.getStudents()) {
                        System.out.println(" - " + student.getName());
                    }
                }
                case 3 -> exit = true;
            }
        }
    }
}
