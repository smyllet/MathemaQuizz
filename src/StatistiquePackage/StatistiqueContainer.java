package StatistiquePackage;

import java.util.ArrayList;
import java.util.Optional;

import Exception.StudentDoesntExistException;

public class StatistiqueContainer {
    private final ArrayList<Student> students;
    private final ArrayList<Classe> classes;

    public StatistiqueContainer() {
        this.students = new ArrayList<>();
        this.classes = new ArrayList<>();
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

    public ArrayList<Classe> getClasses() {
        return classes;
    }

    public void addClasse(Classe classe) {
        this.classes.add(classe);
    }

    public Classe getClasseByName(String name) throws StudentDoesntExistException {
        Optional<Classe> optionalStudent = classes.stream().filter(student -> student.getName().equalsIgnoreCase(name)).findFirst();
        if(optionalStudent.isPresent()) return optionalStudent.get();
        else throw new StudentDoesntExistException();
    }
}
