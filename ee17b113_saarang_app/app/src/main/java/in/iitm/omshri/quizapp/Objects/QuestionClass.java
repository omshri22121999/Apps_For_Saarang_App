package in.iitm.omshri.quizapp.Objects;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
public class QuestionClass{
    String  question;
    String  category;
    String  type;


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getCorrect_answer() {
        return correct_answer;
    }

    public void setCorrect_answer(String correct_answer) {
        this.correct_answer = correct_answer;
    }

    public List<String> getIncorrect_answers() {
        return incorrect_answers;
    }

    public void setIncorrect_answers(List<String> incorrect_answers) {
        this.incorrect_answers = incorrect_answers;
    }

    String difficulty;

    public QuestionClass(String question, String category, String type, String difficulty, String correct_answer, List<String> incorrect_answers) {
        this.question = question;
        this.category = category;
        this.type = type;
        this.difficulty = difficulty;
        this.correct_answer = correct_answer;
        this.incorrect_answers = incorrect_answers;
    }

    String  correct_answer;
    List<String> incorrect_answers;

}
