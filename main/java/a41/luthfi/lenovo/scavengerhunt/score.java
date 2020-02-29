package a41.luthfi.lenovo.scavengerhunt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class score extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Bundle b = getIntent().getExtras();
        int scoreDisplay = b.getInt("scoreEx");

        TextView jumlahPoin = (TextView) findViewById(R.id.yourpoint);
        jumlahPoin.setText("Your point is " + scoreDisplay + "/70");


        Button viewAnswer = (Button) findViewById(R.id.checkanswer);
        viewAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView viewAllAnswer = (TextView) findViewById(R.id.answerAll);
                viewAllAnswer.setVisibility(View.VISIBLE);
            }
        });
    }
}
