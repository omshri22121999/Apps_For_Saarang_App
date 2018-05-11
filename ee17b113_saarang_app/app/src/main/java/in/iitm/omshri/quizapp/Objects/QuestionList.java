package in.iitm.omshri.quizapp.Objects;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

import in.iitm.omshri.quizapp.Objects.QuestionClass;

public class QuestionList {
    Integer response_code;
    List<QuestionClass> results;
    public String getq(int i){
        return results.get(i).question;
    }
    public String getcorrect(int i){
        return results.get(i).correct_answer;
    }
    public List<String> getincorrect(int i){
        return results.get(i).incorrect_answers;
    }

    public Integer getSize() {
        return results.size();
    }
}
