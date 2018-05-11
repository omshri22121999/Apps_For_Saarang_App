package in.iitm.omshri.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {
    String score;
    TextView score_txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        score= getIntent().getStringExtra("score");
        score_txt = findViewById(R.id.score);
        score_txt.setText("Score : "+score);
        score_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),OpeningActivity.class);
                startActivity(intent);
            }
        });
    }
}
