package com.example.hectorvera.twofragmentpractice;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Transition;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ActivityCommunication{
    BlankFragment bF1;
    BlankFragment2 bF2;
    LinearLayout myContainer1, myContainer2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myContainer1 = ((LinearLayout) findViewById(R.id.myContainer1));
        myContainer2 = ((LinearLayout) findViewById(R.id.myContainer2));

        FragmentManager fM = getSupportFragmentManager();
        FragmentTransaction transaction = fM.beginTransaction();

        if((myContainer1!= null)&& (myContainer2!= null)){
            bF1 = new BlankFragment();
            bF2 = new BlankFragment2();
            if(isTablet(this)) {
                transaction.add(R.id.myContainer1, bF1);
                transaction.add(R.id.myContainer2, bF2).commit();
            }else{
                transaction.add(R.id.myContainer1, bF1);
                transaction.add(R.id.myContainer2, bF2);
                transaction.hide(bF2).commit();
            }
        }
    }

    private boolean isTablet(Context context){
        boolean xlarge = ((context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK)
                == Configuration.SCREENLAYOUT_SIZE_XLARGE);
        boolean large = ((context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK)
                == Configuration.SCREENLAYOUT_SIZE_LARGE);
        return (xlarge || large);
    }

    @Override
    public void sendNumber(String number) {

        if(!isTablet(this)) {
            FragmentManager fM = getSupportFragmentManager();
            FragmentTransaction transaction = fM.beginTransaction();
            transaction.hide(bF1);
            transaction.show(bF2).commit();
        }
        bF2.eFragment2.setText(number);
    }

    @Override
    public void returnNumber(String number) {
        if(!isTablet(this)) {
            FragmentManager fM = getSupportFragmentManager();
            FragmentTransaction transaction = fM.beginTransaction();
            transaction.hide(bF2);
            transaction.show(bF1).commit();
        }
        //transaction.show(bF2);
        bF1.eNumero.setText(number);
    }
}
