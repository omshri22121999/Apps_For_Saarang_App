package in.iitm.omshri.quizapp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class QuestionActivity extends AppCompatActivity {
    TextView txt_ques_no;
    TextView txt_ques;
    RadioButton rad_opt_one;
    RadioButton rad_opt_two;
    RadioButton rad_opt_three;
    RadioButton rad_opt_four;
    Button  btn_submit;
    SharedPreferences pref;
    SharedPreferences.Editor editor = pref.edit();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

    }
}
