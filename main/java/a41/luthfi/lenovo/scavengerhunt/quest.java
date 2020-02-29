package a41.luthfi.lenovo.scavengerhunt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class quest extends AppCompatActivity {
    int qid = 0;
    int score = 0;
    String[] theQuestion = {"Batuan di Indonesia yang berasal dari luar angkasa (2 kata)", "Mineral yang berasal dari gunung api (lihat gambar)", "Mineral keras bewarna ungu (2 kata)", "Fosil tertua berumur Arkean",
            "Kadal ikan dari Pulau Seram", "Nama manusia purba", "Fosil terbesar dari Matamenge, Cekungan Soa"};
    String[] theType = {"et", "rb1", "et", "rb2",
            "et", "cb", "et"};
    String[] theAnswer = {"meteorit jatipengilon", "2", "kristal ametis", "1",
            "ichtyosaurus ceramensis", "23", "stegodon florensis"};
    String[] rbAnswer1 = {"Piroksen", "Belerang", "Obsidian"};
    String[] rbAnswer2 = {"Stromatolit", "Geocellon", "Buballus"};
    String[] cbAnswer = {"Cyprinis carpio", "Homo sapiens", "Meganthropus paleojavanicus"};
    String[] answerSubmitted = new String[7];
    EditText editText;
    RadioGroup radioGroup;
    RadioButton radioButton1;
    RadioButton radioButton2;
    RadioButton radioButton3;
    RadioGroup checkBoxes;
    CheckBox checkBox1;
    CheckBox checkBox2;
    CheckBox checkBox3;
    TextView qnumber;
    TextView askq;
    ImageView imageAttach;
    Button lanjut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest);

        qnumber = (TextView) findViewById(R.id.questnumber);
        askq = (TextView) findViewById(R.id.askquest);
        editText = (EditText) findViewById(R.id.et);
        radioGroup = (RadioGroup) findViewById(R.id.rb);
        radioButton1 = (RadioButton) findViewById(R.id.rb1);
        radioButton2 = (RadioButton) findViewById(R.id.rb2);
        radioButton3 = (RadioButton) findViewById(R.id.rb3);
        checkBoxes = (RadioGroup) findViewById(R.id.cb);
        checkBox1 = (CheckBox) findViewById(R.id.cb1);
        checkBox2 = (CheckBox) findViewById(R.id.cb2);
        checkBox3 = (CheckBox) findViewById(R.id.cb3);
        imageAttach = (ImageView) findViewById(R.id.image1);
        displayQuestion(qid);
        lanjut = (Button) findViewById(R.id.next);
        lanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (qid == 6) {
                    Intent l = new Intent(quest.this, score.class);
                    Bundle b = new Bundle();
                    b.putInt("scoreEx", score);
                    l.putExtras(b);
                    startActivity(l);
                } else {
                    checkAnswer(qid);
                    qid++;
                    displayQuestion(qid);
                }
            }
        });
    }

    public void checkAnswer(int questid) {
        if (theType[questid] == "et") {
            answerSubmitted[questid] = editText.getText().toString();
        } else if (theType[questid] == "rb1" || theType[questid] == "rb2") {
            if (radioButton1.isChecked()) {
                answerSubmitted[questid] = "1";
            }
            if (radioButton2.isChecked()) {
                answerSubmitted[questid] = "2";
            }
            if (radioButton3.isChecked()) {
                answerSubmitted[questid] = "3";
            }
        } else if (theType[questid] == "cb") {
            int cekcb = 0;
            if (checkBox2.isChecked()) {
                cekcb++;
            }
            if (checkBox3.isChecked()) {
                cekcb++;
            }
            if (cekcb == 2) {
                answerSubmitted[questid] = "23";
            }
        }
        if (theAnswer[questid].equals(answerSubmitted[questid])) {
            score = score + 10;
            Toast.makeText(quest.this, "You're correct", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(quest.this, "You're incorrect", Toast.LENGTH_SHORT).show();
        }
    }

    public void displayQuestion(int questid) {
        editText.setVisibility(View.GONE);
        radioGroup.setVisibility(View.GONE);
        checkBoxes.setVisibility(View.GONE);
        imageAttach.setVisibility(View.GONE);
        editText.setText("");
        if (theType[questid] == "et") {
            editText.setVisibility(View.VISIBLE);
        } else if (theType[questid] == "rb1") {
            radioGroup.setVisibility(View.VISIBLE);
            radioButton1.setText(rbAnswer1[0]);
            radioButton2.setText(rbAnswer1[1]);
            radioButton3.setText(rbAnswer1[2]);
        } else if (theType[questid] == "rb2") {
            radioGroup.setVisibility(View.VISIBLE);
            radioButton1.setText(rbAnswer2[0]);
            radioButton2.setText(rbAnswer2[1]);
            radioButton3.setText(rbAnswer2[2]);
        } else if (theType[questid] == "cb") {
            checkBoxes.setVisibility(View.VISIBLE);
            checkBox1.setText(cbAnswer[0]);
            checkBox2.setText(cbAnswer[1]);
            checkBox3.setText(cbAnswer[2]);
        }
        if (questid == 1) {
            imageAttach.setVisibility(View.VISIBLE);
        }
        qnumber.setText("Quest " + (questid + 1));
        askq.setText(theQuestion[questid]);
    }

}
