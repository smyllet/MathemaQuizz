package StatistiquePackage;

import QuestionPackage.QuestionType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

import Exception.StudentDoesntExistException;

public class Statistique {
    private final ArrayList<Student> students;

    public Statistique() {
        this.students = new ArrayList<>();
    }

    public HashMap<String, HashMap<String, Double>> getStatistiqueMapByStudent() {
        HashMap<String, HashMap<String, Double>> statistique = new HashMap<>();
        for(Student student : students) {
            statistique.put(student.getName(), student.getStatistiqueMap());
        }
        return statistique;
    }

    public HashMap<String, HashMap<String, Double>> getStatistiqueMapByStudentForQuestionType(QuestionType questionType) {
        HashMap<String, HashMap<String, Double>> statistique = new HashMap<>();
        for(Student student : students) {
            statistique.put(student.getName(), student.getStatistiqueMapForQuestionType(questionType));
        }
        return statistique;
    }

    public Student getStudentByName(String name) throws StudentDoesntExistException {
        Optional<Student> optionalStudent = students.stream().filter(student -> student.getName().equalsIgnoreCase(name)).findFirst();
        if(optionalStudent.isPresent()) return optionalStudent.get();
        else throw new StudentDoesntExistException();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}
