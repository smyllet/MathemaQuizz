package StatistiquePackage;

import QuestionPackage.QuestionType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class Classe {
    private final String name;
    private ArrayList<Student> students;

    public Classe(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public String getName() {
        return name;
    }

    // - - - Statistique - - - //

    public double getMoyenneBestScore() {
        OptionalDouble optionalDouble = this.students.stream().mapToInt(Student::getBestScore).average();
        if(optionalDouble.isPresent()) return optionalDouble.getAsDouble();
        else return 0;
    }

    public double getMoyenneBestScoreForQuestionType(QuestionType questionType) {
        OptionalDouble optionalDouble = this.students.stream().mapToInt(student -> student.getBestScoreForQuestionType(questionType)).average();
        if(optionalDouble.isPresent()) return optionalDouble.getAsDouble();
        else return 0;
    }

    public double getMoyenneNbTentative() {
        OptionalDouble optionalDouble = this.students.stream().mapToInt(Student::getNbParties).average();
        if(optionalDouble.isPresent()) return optionalDouble.getAsDouble();
        else return 0;
    }

    public double getMoyenneNbTentativeForQuestionType(QuestionType questionType) {
        OptionalDouble optionalDouble = this.students.stream().mapToInt(student -> student.getNbPartiesForQuestionType(questionType)).average();
        if(optionalDouble.isPresent()) return optionalDouble.getAsDouble();
        else return 0;
    }

    public double getMoyenneNbEntrainement() {
        OptionalDouble optionalDouble = this.students.stream().mapToInt(Student::getNbEntrainements).average();
        if(optionalDouble.isPresent()) return optionalDouble.getAsDouble();
        else return 0;
    }

    public double getMoyenneNbEntrainementForQuestionType(QuestionType questionType) {
        OptionalDouble optionalDouble = this.students.stream().mapToInt(student -> student.getNbEntrainementsForQuestionType(questionType)).average();
        if(optionalDouble.isPresent()) return optionalDouble.getAsDouble();
        else return 0;
    }

    public ClasseStatistique getGlobalStatistique() {
        return new ClasseStatistique(this.getMoyenneBestScore(), this.getMoyenneNbTentative(), this.getMoyenneNbEntrainement());
    }

    public ClasseStatistique getStatistiqueForQuestionType(QuestionType questionType) {
        return new ClasseStatistique(this.getMoyenneBestScoreForQuestionType(questionType), this.getMoyenneNbTentativeForQuestionType(questionType), this.getMoyenneNbEntrainementForQuestionType(questionType));
    }

    public HashMap<Student, StudentStatistique> getGlobalStatistiqueByStudent() {
        HashMap<Student, StudentStatistique> stats = new HashMap<>();

        for(Student student : students) {
            stats.put(student, student.getGlobalStatistique());
        }

        return stats;
    }

    public HashMap<Student, StudentStatistique> getStatistiqueByStudentForQuestionType(QuestionType questionType) {
        HashMap<Student, StudentStatistique> stats = new HashMap<>();

        for(Student student : students) {
            stats.put(student, student.getStatistiqueForQuestionType(questionType));
        }

        return stats;
    }
}
