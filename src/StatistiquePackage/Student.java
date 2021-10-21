package StatistiquePackage;

import QuestionPackage.QuestionType;

import java.util.*;

public class Student {
    private final String name;
    ArrayList<Partie> parties;

    public Student(String name) {
        this.name = name;
        this.parties = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Partie> getParties() {
        return parties;
    }

    public void setParties(ArrayList<Partie> parties) {
        this.parties = parties;
    }

    public void addParties(Partie partie) {
        this.parties.add(partie);
    }

    public int getBestScore() {
        OptionalInt optionalBestScore = this.parties.stream().mapToInt(Partie::getScore).max();
        if(optionalBestScore.isPresent()) return optionalBestScore.getAsInt();
        else return 0;
    }

    public int getBestScoreForQuestionType(QuestionType questionType) {
        OptionalInt optionalBestScore = this.parties.stream().filter(partie -> partie.getQuestionType().equals(questionType)).mapToInt(Partie::getScore).max();
        if(optionalBestScore.isPresent()) return optionalBestScore.getAsInt();
        else return 0;
    }

    public int getNbParties() {
        return parties.size();
    }

    public int getNbPartiesForQuestionType(QuestionType questionType) {
        return parties.stream().filter(partie -> partie.getQuestionType().equals(questionType)).toList().size();
    }

    public double getAverageScore() {
        OptionalDouble optionalAVGScore = parties.stream().mapToInt(Partie::getScore).average();
        if(optionalAVGScore.isPresent()) return optionalAVGScore.getAsDouble();
        else return 0;
    }

    public double getAverageScoreForQuestionType(QuestionType questionType) {
        OptionalDouble optionalAVGScore = parties.stream().filter(partie -> partie.getQuestionType().equals(questionType)).mapToInt(Partie::getScore).average();
        if(optionalAVGScore.isPresent()) return optionalAVGScore.getAsDouble();
        else return 0;
    }

    public HashMap<String, Double> getStatistiqueMap() {
        HashMap<String, Double> statistique = new HashMap<>();
        statistique.put("Meilleur Score", (double) this.getBestScore());
        statistique.put("Nombre de tentative", (double) this.getNbParties());
        statistique.put("Moyenne des scores", this.getAverageScore());
        return statistique;
    }

    public HashMap<String, Double> getStatistiqueMapForQuestionType(QuestionType questionType) {
        HashMap<String, Double> statistique = new HashMap<>();
        statistique.put("Meilleur Score", (double) this.getBestScoreForQuestionType(questionType));
        statistique.put("Nombre de tentative", (double) this.getNbPartiesForQuestionType(questionType));
        statistique.put("Moyenne des scores", this.getAverageScoreForQuestionType(questionType));
        return statistique;
    }
}
