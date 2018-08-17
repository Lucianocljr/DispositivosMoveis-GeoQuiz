package br.com.gustech.android.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private Button mBotaoTrue;
    private Button mBotaoFalse;
    private Button mBotaoNext;

    private int mQuestaoCorrente =0;

    private TextView mQuestoes;

    private Question[] mBancoDeQuestoes = new Question[]{
            new Question(R.string.questao1,true),
            new Question(R.string.questao2,true),
            new Question(R.string.questao3,false),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mBotaoTrue = (Button) findViewById(R.id.true_button);
        mBotaoFalse = (Button) findViewById(R.id.false_button);
        mQuestoes = (TextView) findViewById(R.id.questoes);
        mBotaoNext = (Button) findViewById(R.id.next_button);

        mBotaoTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(QuizActivity.this,
                        R.string.resposta_correta,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mBotaoFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(QuizActivity.this,
                        R.string.resposta_incorreta,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mBotaoNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mQuestaoCorrente = (mQuestaoCorrente +1) % mBancoDeQuestoes.length;
                int idQuestion = mBancoDeQuestoes[mQuestaoCorrente].getmQuestaoID();
                mQuestoes.setText(idQuestion);
            }
        });


        int question = mBancoDeQuestoes[mQuestaoCorrente].getmQuestaoID();
        mQuestoes.setText(question);



    }
}
