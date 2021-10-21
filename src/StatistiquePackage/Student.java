package StatistiquePackage;

import QuestionPackage.QuestionType;

import java.util.*;

public class Student {
    private final String name;
    private Classe classe;
    ArrayList<Partie> parties;
    ArrayList<Partie> entrainements;

    public Student(String name) {
        this(name, null);
    }

    public Student(String name, Classe classe) {
        this.name = name;
        this.classe = classe;
        this.parties = new ArrayList<>();
        this.entrainements = new ArrayList<>();
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

    public ArrayList<Partie> getEntrainements() {
        return entrainements;
    }

    public void setEntrainements(ArrayList<Partie> entrainements) {
        this.entrainements = parties;
    }

    public void addEntrainement(Partie partie) {
        this.entrainements.add(partie);
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    // - - - Statistique - - - //

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

    public int getNbTentative() {
        return parties.size();
    }

    public int getNbTentativeForQuestionType(QuestionType questionType) {
        return parties.stream().filter(partie -> partie.getQuestionType().equals(questionType)).toList().size();
    }

    public double getMoyenne() {
        OptionalDouble optionalAVGScore = parties.stream().mapToInt(Partie::getScore).average();
        if(optionalAVGScore.isPresent()) return optionalAVGScore.getAsDouble();
        else return 0;
    }

    public double getMoyenneScoreForQuestionType(QuestionType questionType) {
        OptionalDouble optionalAVGScore = parties.stream().filter(partie -> partie.getQuestionType().equals(questionType)).mapToInt(Partie::getScore).average();
        if(optionalAVGScore.isPresent()) return optionalAVGScore.getAsDouble();
        else return 0;
    }

    public int getNbEntrainements() {
        return this.entrainements.size();
    }

    public int getNbEntrainementsForQuestionType(QuestionType questionType) {
        return this.entrainements.stream().filter(partie -> partie.getQuestionType().equals(questionType)).toList().size();
    }

    public StudentStatistique getGlobalStatistique() {
        return new StudentStatistique(this.getBestScore(), this.getNbTentative(), this.getMoyenne(), this.getNbEntrainements());
    }

    public StudentStatistique getStatistiqueForQuestionType(QuestionType questionType) {
        return new StudentStatistique(this.getBestScoreForQuestionType(questionType), this.getNbTentativeForQuestionType(questionType), this.getMoyenneScoreForQuestionType(questionType), this.getNbEntrainementsForQuestionType(questionType));
    }
}
