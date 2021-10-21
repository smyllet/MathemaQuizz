package StatistiquePackage;

public class StudentStatistique {
    private int bestScore;
    private int tentative;
    private double moyenne;
    private int nbEntrainement;

    public StudentStatistique(int bestScore, int tentative, double moyenne, int nbEntrainement) {
        this.bestScore = bestScore;
        this.tentative = tentative;
        this.moyenne = moyenne;
        this.nbEntrainement = nbEntrainement;
    }

    public int getBestScore() {
        return bestScore;
    }

    public void setBestScore(int bestScore) {
        this.bestScore = bestScore;
    }

    public int getTentative() {
        return tentative;
    }

    public void setTentative(int tentative) {
        this.tentative = tentative;
    }

    public double getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(double moyenne) {
        this.moyenne = moyenne;
    }

    public int getNbEntrainement() {
        return nbEntrainement;
    }

    public void setNbEntrainement(int nbEntrainement) {
        this.nbEntrainement = nbEntrainement;
    }
}
