package StatistiquePackage;

public class ClasseStatistique {
    private double moyenneBestScore;
    private double nbMoyenTentative;
    private double nbMoyenEntrainement;

    public ClasseStatistique(double moyenneBestScore, double nbMoyenTentative, double nbMoyenEntrainement) {
        this.moyenneBestScore = moyenneBestScore;
        this.nbMoyenTentative = nbMoyenTentative;
        this.nbMoyenEntrainement = nbMoyenEntrainement;
    }

    public double getMoyenneBestScore() {
        return moyenneBestScore;
    }

    public void setMoyenneBestScore(double moyenneBestScore) {
        this.moyenneBestScore = moyenneBestScore;
    }

    public double getNbMoyenTentative() {
        return nbMoyenTentative;
    }

    public void setNbMoyenTentative(double nbMoyenTentative) {
        this.nbMoyenTentative = nbMoyenTentative;
    }

    public double getNbMoyenEntrainement() {
        return nbMoyenEntrainement;
    }

    public void setNbMoyenEntrainement(double nbMoyenEntrainement) {
        this.nbMoyenEntrainement = nbMoyenEntrainement;
    }
}
