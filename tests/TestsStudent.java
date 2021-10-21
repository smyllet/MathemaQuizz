import QuestionPackage.QuestionType;
import StatistiquePackage.Partie;
import StatistiquePackage.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestsStudent {
    private Student harry, mickey, leDocteur;

    @BeforeEach
    final void setUp() {
        harry = new Student("Harry Potter");
        mickey = new Student("Mickey Mouse");

        harry.addParties(new Partie(2, QuestionType.MULTIPLICATION));
        harry.addParties(new Partie(4, QuestionType.SUBTRACT));
        harry.addParties(new Partie(1, QuestionType.SUBTRACT));

        mickey.addEntrainement(new Partie(2, QuestionType.MULTIPLICATION));
        mickey.addEntrainement(new Partie(4, QuestionType.SUBTRACT));
        mickey.addEntrainement(new Partie(1, QuestionType.SUBTRACT));
    }

    @Test
    void getBestScore() {
        assertEquals(4, harry.getBestScore());
        assertEquals(0, mickey.getBestScore());
    }

    @Test
    void getBestScoreForQuestionType() {
        assertEquals(2, harry.getBestScoreForQuestionType(QuestionType.MULTIPLICATION));
        assertEquals(4, harry.getBestScoreForQuestionType(QuestionType.SUBTRACT));
        assertEquals(0, harry.getBestScoreForQuestionType(QuestionType.ADDITION));

        assertEquals(0, mickey.getBestScoreForQuestionType(QuestionType.MULTIPLICATION));
        assertEquals(0, mickey.getBestScoreForQuestionType(QuestionType.SUBTRACT));
        assertEquals(0, mickey.getBestScoreForQuestionType(QuestionType.ADDITION));
    }

    @Test
    void getNbTentative() {
        assertEquals(3, harry.getNbTentative());
        assertEquals(0, mickey.getNbTentative());
    }

    @Test
    void getNbTentativeForQuestionType() {
        assertEquals(1, harry.getNbTentativeForQuestionType(QuestionType.MULTIPLICATION));
        assertEquals(2, harry.getNbTentativeForQuestionType(QuestionType.SUBTRACT));
        assertEquals(0, harry.getNbTentativeForQuestionType(QuestionType.ADDITION));

        assertEquals(0, mickey.getNbTentativeForQuestionType(QuestionType.MULTIPLICATION));
        assertEquals(0, mickey.getNbTentativeForQuestionType(QuestionType.SUBTRACT));
        assertEquals(0, mickey.getNbTentativeForQuestionType(QuestionType.ADDITION));
    }

    @Test
    void getNbEntrainement() {
        assertEquals(0, harry.getNbEntrainements());

        assertEquals(3, mickey.getNbEntrainements());
    }

    @Test
    void getNbEntrainementForQuestionType() {
        assertEquals(0, harry.getNbEntrainementsForQuestionType(QuestionType.MULTIPLICATION));
        assertEquals(0, harry.getNbEntrainementsForQuestionType(QuestionType.SUBTRACT));
        assertEquals(0, harry.getNbEntrainementsForQuestionType(QuestionType.ADDITION));

        assertEquals(1, mickey.getNbEntrainementsForQuestionType(QuestionType.MULTIPLICATION));
        assertEquals(2, mickey.getNbEntrainementsForQuestionType(QuestionType.SUBTRACT));
        assertEquals(0, mickey.getNbEntrainementsForQuestionType(QuestionType.ADDITION));
    }

    @Test
    void getMoyenne() {
        assertEquals(2.33, harry.getMoyenne(), 0.01);

        assertEquals(0, mickey.getMoyenne());
    }

    @Test
    void getMoyenneForQuestionType() {
        assertEquals(2, harry.getMoyenneScoreForQuestionType(QuestionType.MULTIPLICATION));
        assertEquals(2.5, harry.getMoyenneScoreForQuestionType(QuestionType.SUBTRACT), 0.1);
        assertEquals(0, harry.getMoyenneScoreForQuestionType(QuestionType.ADDITION));

        assertEquals(0, mickey.getMoyenneScoreForQuestionType(QuestionType.MULTIPLICATION));
        assertEquals(0, mickey.getMoyenneScoreForQuestionType(QuestionType.SUBTRACT));
        assertEquals(0, mickey.getMoyenneScoreForQuestionType(QuestionType.ADDITION));
    }
}
