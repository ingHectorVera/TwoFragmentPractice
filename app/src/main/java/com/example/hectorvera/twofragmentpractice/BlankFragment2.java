package com.example.hectorvera.twofragmentpractice;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment2 extends Fragment {

    EditText eFragment2;
    Button retransmit;
    public BlankFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank_fragment2, container, false);
        eFragment2 = ((EditText) view.findViewById(R.id.eFragment2));
        retransmit = ((Button) view.findViewById(R.id.Retransmit));

        retransmit.setOnClickListener(
                new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        ActivityCommunication ac = (ActivityCommunication)getActivity();
                        ac.returnNumber(eFragment2.getText().toString());
                    }
                }
        );
        return view;
    }

}
