package in.iitm.omshri.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import in.iitm.omshri.quizapp.Objects.QuestionList;

public class OpeningActivity extends AppCompatActivity {

    QuestionList questionList;
    static final String URL = "https://opentdb.com/api.php?amount=10&category=18&difficulty=easy&type=multiple";
    private RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening);

        final StringRequest request = new StringRequest(URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Intent intent = new Intent(getApplicationContext(),MenuActivity.class);
                intent.putExtra("questions",response);
                finish();
                startActivity(intent);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Errorenous", error.toString());
            }
        });
        requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(request);
    }
}
