package br.com.gustech.android.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private Button botaoTrue;
    private Button botaoFalse;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        botaoTrue = (Button) findViewById(R.id.true_button);
        botaoFalse = (Button) findViewById(R.id.false_button);

        botaoTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(QuizActivity.this,
                        R.string.resposta_correta,
                        Toast.LENGTH_SHORT).show();
            }
        });

        botaoFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(QuizActivity.this,
                        R.string.resposta_incorreta,
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
}
