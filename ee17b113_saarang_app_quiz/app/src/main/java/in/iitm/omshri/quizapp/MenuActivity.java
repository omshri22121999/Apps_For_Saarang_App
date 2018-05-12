package in.iitm.omshri.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.ExecutionException;

import in.iitm.omshri.quizapp.Objects.QuestionList;

public class MenuActivity extends AppCompatActivity {
    TextView txt_play;
    QuestionList questionList;
    String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_menu);
       str = getIntent().getStringExtra("questions");
       txt_play = (TextView) findViewById(R.id.play_text);
       txt_play.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(getApplicationContext(),QuestionActivity.class);
               intent.putExtra("questions",str);
               startActivity(intent);
           }
       });
   }
}
