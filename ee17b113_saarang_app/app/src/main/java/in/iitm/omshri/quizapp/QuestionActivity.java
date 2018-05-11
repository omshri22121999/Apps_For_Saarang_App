package in.iitm.omshri.quizapp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


public class QuestionActivity extends AppCompatActivity {

    static final String ENDPOINT = "https://kylewbanks.com/rest/posts.json";
    TextView txt_ques_no;
    TextView txt_ques;
    RadioButton rad_opt_one;
    RadioButton rad_opt_two;
    RadioButton rad_opt_three;
    RadioButton rad_opt_four;
    Button  btn_submit;
    private RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        btn_submit = (Button) findViewById(R.id.submit_btn);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestQueue= Volley.newRequestQueue(getApplicationContext());
                fetchPosts();
            }
        });
    }

    private void fetchPosts() {
        StringRequest request = new StringRequest(Request.Method.GET, ENDPOINT, onPostsLoaded, onPostsError);

        Log.i("TheReturn", request.toString());
    }

    private final Response.Listener<String> onPostsLoaded = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            Log.i("TheReturn", response);

        }
    };

    private final Response.ErrorListener onPostsError = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e("TheReturn", error.toString());
        }
    };
}