package in.iitm.omshri.quizapp;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import in.iitm.omshri.quizapp.Objects.QuestionList;


public class QuestionActivity extends FragmentActivity {

    TextView txt_ques_no;
    TextView txt_ques;
    String questionJSON;
    RadioGroup rad_gr;
    Button btn_submit;
    Gson gson;
    Integer ques_no = 0;
    Integer score = 0;
    String marks= "";
    QuestionList questionList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();
        setContentView(R.layout.activity_question);
        btn_submit = (Button) findViewById(R.id.submit_btn);
        txt_ques_no = (TextView) findViewById(R.id.ques_no_text);
        txt_ques = (TextView) findViewById(R.id.ques_text);
        rad_gr = (RadioGroup) findViewById(R.id.answer_radiogr);
        questionJSON = getIntent().getStringExtra("questions");
        questionList = gson.fromJson(questionJSON,QuestionList.class);
        setNextQuestion();
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ques_no < (questionList.getSize())) {
                    if (findViewById(rad_gr.getCheckedRadioButtonId()) != null) {
                        String sel = (String) ((RadioButton) findViewById(rad_gr.getCheckedRadioButtonId())).getText();

                        if (sel == questionList.getcorrect(ques_no)) {
                            score += 3;
                        } else {
                            score -= 1;
                        }

                        marks = marks + "," + score.toString();
                        ques_no++;
                        if(ques_no<questionList.getSize())setNextQuestion();
                        if (ques_no == questionList.getSize()) {
                            Intent intent = new Intent(getApplicationContext(), ScoreActivity.class);
                            intent.putExtra("score", score.toString());
                            finish();
                            startActivity(intent);

                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Select Option!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    void setNextQuestion(){
        txt_ques_no.setText("Question No. "+Integer.toString(ques_no+1));
        txt_ques.setText(questionList.getq(ques_no));
        List<String> options=questionList.getincorrect(ques_no);
        options.add(questionList.getcorrect(ques_no));
        rad_gr.clearCheck();
        Collections.shuffle(options);
        for(int j=0;j<4;j++) {
            ((RadioButton) rad_gr.getChildAt(j)).setText(options.get(j));
        }
    }
}