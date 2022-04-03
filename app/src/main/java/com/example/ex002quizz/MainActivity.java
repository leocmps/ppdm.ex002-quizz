package com.example.ex002quizz;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnStart;
    Button btnValidate;
    TextView txtCorrect;
    TextView txtError;

    TextView txtQuestion01;
    RadioGroup rdQuestion01;
    String[] options01 = {"1950", "1960", "1970", "1980", "1990"};
    int answer01 = 0;

    TextView txtQuestion02;
    RadioGroup rdQuestion02;
    String[] options02 = {"IT", "TDI", "TIC", "TI", "ADS"};
    int answer02 = 3;

    TextView txtQuestion03;
    RadioGroup rdQuestion03;
    String[] options03 = {"IF", "WHILE", "CLASS", "ELSE", "SOUT"};
    int answer03 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.initializeComponents();
        this.addButtonStartListener();
        this.addButtonValidateListener();
    }

    private void initializeComponents () {
        this.btnStart = findViewById(R.id.btnStart);
        this.btnValidate = findViewById(R.id.btnValidate);
        this.txtCorrect = findViewById(R.id.txtCorrect);
        this.txtError = findViewById(R.id.txtError);
        this.txtQuestion01 = findViewById(R.id.txtQuestion01);
        this.rdQuestion01 = findViewById(R.id.rdQuestion01);
        this.txtQuestion02 = findViewById(R.id.txtQuestion02);
        this.rdQuestion02 = findViewById(R.id.rdQuestion02);
        this.txtQuestion03 = findViewById(R.id.txtQuestion03);
        this.rdQuestion03 = findViewById(R.id.rdQuestion03);
    }

    private void addButtonStartListener () {
        this.btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initializeFirstQuizz();
                initializeSecondQuizz();
                initializeThirdQuizz();
            }
        });
    }

    private void initializeFirstQuizz () {
        this.txtQuestion01.setText("Qual foi o ano que a tecnologia foi aplicada nas grandes empresas?");
        for(int i = 0; i < this.options01.length; i++) {
            RadioButton button = new RadioButton(this);
            button.setText(i + " - ) " + this.options01[i]);
            this.rdQuestion01.addView(button);
        }
    }

    private void initializeSecondQuizz () {
        this.txtQuestion02.setText("Qual é a sigla da tecnologia da informação?");
        for(int i = 0; i < this.options02.length; i++) {
            RadioButton button = new RadioButton(this);
            button.setText(i + " - ) " + this.options02[i]);
            this.rdQuestion02.addView(button);
        }
    }

    private void initializeThirdQuizz () {
        this.txtQuestion03.setText("Em nossa língua \"Se\" corresponde a que função em Java?");
        for(int i = 0; i < this.options03.length; i++) {
            RadioButton button = new RadioButton(this);
            button.setText(i + " - ) " + this.options03[i]);
            this.rdQuestion03.addView(button);
        }
    }

    private void addButtonValidateListener () {
        this.btnValidate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int correct = 0;
                int error = 0;

                if (isValid01()) correct++;
                else error++;

                if (isValid02()) correct++;
                else error++;

                if (isValid03()) correct++;
                else error++;

                txtCorrect.setText("Você acertou: " + correct + "!");
                txtError.setText("Você errou: " + error + "!");
            }
        });
    }

    public boolean isValid01 () {
        int radioButtonID = rdQuestion01.getCheckedRadioButtonId();
        View radioButton = rdQuestion01.findViewById(radioButtonID);
        int idx = rdQuestion01.indexOfChild(radioButton);
        return idx == this.answer01;
    }

    public boolean isValid02 () {
       int radioButtonID = rdQuestion02.getCheckedRadioButtonId();
       View radioButton = rdQuestion02.findViewById(radioButtonID);
       int idx = rdQuestion02.indexOfChild(radioButton);
       return idx == this.answer02;
    }

    public boolean isValid03 () {
       int radioButtonID = rdQuestion03.getCheckedRadioButtonId();
       View radioButton = rdQuestion03.findViewById(radioButtonID);
       int idx = rdQuestion03.indexOfChild(radioButton);
       return idx == this.answer03;
    }                                                                            

}