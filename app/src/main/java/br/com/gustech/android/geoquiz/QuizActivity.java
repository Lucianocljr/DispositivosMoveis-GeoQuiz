package br.com.gustech.android.geoquiz;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private Button mBotaoTrue;
    private Button mBotaoFalse;
    private ImageButton mBotaoNext;
    private ImageButton mBotaoPrevious;
    private int mContQuestoes = 0;
    private int mPontuacao = 0;

    private int mQuestaoCorrente = 0;

    private TextView mQuestoes;

    private static final String TAG = "QuizActivity";

    private Question[] mBancoDeQuestoes = new Question[]{
            new Question(R.string.questao1, true, false),
            new Question(R.string.questao2, true, false),
            new Question(R.string.questao3, false, false),
            new Question(R.string.questao4, true, false),
            new Question(R.string.questao5, false, false)
    };

    public void setmPontuacao(int pontos) {
        this.mPontuacao = pontos;
    }

    public int getmPontuacao() {
        return mPontuacao;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        System.out.println("contador das questoes " + mContQuestoes);
        System.out.println("tamanho do banco de questoes " + mBancoDeQuestoes.length);
        System.out.println("indice da questao vigente " + mQuestaoCorrente);

        mQuestoes = (TextView) findViewById(R.id.questoes);
        mQuestoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mQuestaoCorrente < mBancoDeQuestoes.length - 1) {
                    mQuestaoCorrente++;
                    //mQuestaoCorrente = (mQuestaoCorrente + 1) % mBancoDeQuestoes.length;
                    int idQuestion = mBancoDeQuestoes[mQuestaoCorrente].getmQuestaoID();
                    mQuestoes.setText(idQuestion);
                }
            }
        });


        mBotaoTrue = (Button) findViewById(R.id.true_button);

        if (mBancoDeQuestoes[mQuestaoCorrente].getmRespondida() == false) {

            mBotaoTrue.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    verificarAcerto(true);
                    mBancoDeQuestoes[mQuestaoCorrente].setmRespondida(true);

                }
            });

        }


        mBotaoFalse = (Button) findViewById(R.id.false_button);

        if (! mBancoDeQuestoes[mQuestaoCorrente].getmRespondida()) {

            mBotaoFalse.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    verificarAcerto(false);
                    mBancoDeQuestoes[mQuestaoCorrente].setmRespondida(true);
                }

            });

        }


        mBotaoNext = (ImageButton) findViewById(R.id.next_button);




            mBotaoNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    if (mQuestaoCorrente < mBancoDeQuestoes.length - 1) {
                        int idQuestion = mBancoDeQuestoes[mQuestaoCorrente].getmQuestaoID();
                        mQuestoes.setText(idQuestion);
                        mContQuestoes++;
                        mQuestaoCorrente++;
                        System.out.println("contador das questoes no next " + mContQuestoes);
                        System.out.println("indice da questao vigente " + mQuestaoCorrente);
                    }
                }
            });




        mBotaoPrevious = (ImageButton) findViewById(R.id.previous_button);



            mBotaoPrevious.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (mContQuestoes >= 0) {
                        mQuestaoCorrente = (mQuestaoCorrente - 1) % mBancoDeQuestoes.length;
                        int idQuestion = mBancoDeQuestoes[mQuestaoCorrente].getmQuestaoID();
                        mQuestoes.setText(idQuestion);
                        mContQuestoes--;
                        System.out.println("contador das questoes no previous " + mContQuestoes);
                        System.out.println("indice da questao vigente " + mQuestaoCorrente);
                    }
                }
            });




        int question = mBancoDeQuestoes[mQuestaoCorrente].getmQuestaoID();
        mQuestoes.setText(question);
    }

    private void verificarAcerto(boolean respostaDoUsuario) {
        //Verificacao se e verdadeiro
        if (mBancoDeQuestoes[mQuestaoCorrente].mRespostaCorreta() == respostaDoUsuario) {
            //mQuestaoCorrente = (mQuestaoCorrente +1) % mBancoDeQuestoes.length;
            if (mQuestaoCorrente < mBancoDeQuestoes.length) {
                mQuestaoCorrente++;
                mPontuacao = mPontuacao + 100;
            }
            int idQuestion = mBancoDeQuestoes[mQuestaoCorrente].getmQuestaoID();
            mQuestoes.setText(idQuestion);
            Toast.makeText(QuizActivity.this,
                    R.string.resposta_correta,
                    Toast.LENGTH_SHORT).show();
            mContQuestoes++;
        } else {

            Toast.makeText(QuizActivity.this,
                    R.string.resposta_incorreta,
                    Toast.LENGTH_SHORT).show();
            mQuestaoCorrente++;
        }

    }

    public void mostrarPontuacao() {
        Toast.makeText(QuizActivity.this,
                R.string.resultado + mPontuacao,
                Toast.LENGTH_SHORT).show();
    }

    @Override
   protected void onStart(){
        super.onStart();
        Log.d(TAG, "Entrou no onStart()");
   }

   @Override
   protected void onResume(){
        super.onResume();
        Log.d(TAG, "Entrou no onResume");
   }

   @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG, "Entrou no onPause");
   }

   @Override
    protected void onStop(){
        super.onStop();
        Log.d(TAG, "Entrou no onStop");
   }

   @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "Entrou no onDestroy");
   }



}