package br.com.gustech.android.geoquiz;

public class Question {

    private int mQuestaoID;
    private boolean mRespostaCorreta;



    public int getmQuestaoID(){
        return mQuestaoID;
    }

    public void setmQuestaoID(int mQuestaoID){
        this.mQuestaoID=mQuestaoID;
    }

    public boolean mRespostaCorreta() {
        return mRespostaCorreta;
    }

    public void setmRespostaCorreta(boolean mRespostaCorreta) {
        this.mRespostaCorreta = mRespostaCorreta;
    }

    public Question (int mQuestaoID, boolean mRespostaCorreta){
        this.mQuestaoID=mQuestaoID;
        this.mRespostaCorreta=mRespostaCorreta;
    }


    public boolean CheckAnswer(int i){


        return true;
    }


}
