package com.example.hectorvera.twofragmentpractice;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {

    EditText eNumero;
    Button myB;
    boolean flag;
    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        eNumero = ((EditText) view.findViewById(R.id.eNumero));
        myB = ((Button) view.findViewById(R.id.myB));
        myB.setOnClickListener(
                new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        ActivityCommunication ac = (ActivityCommunication) getActivity();
                        ac.sendNumber(eNumero.getText().toString());
                    }
                }
        );
        return view;
    }

}
