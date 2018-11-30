package com.example.ismailamassi.finalprojectandroid.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.ismailamassi.finalprojectandroid.Helper.Constants;
import com.example.ismailamassi.finalprojectandroid.R;

public class Signup2Fragment extends Fragment {
    Button btn_next,btn_Back ;
    public Signup2Fragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup2, container, false);
            btn_next=view.findViewById(R.id.btn_nextsignup2);
            btn_Back=view.findViewById(R.id.btn_backsignup2);

        return view;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onClickItems();

    }
    private void onClickItems() {
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getArguments().getInt("typeAcc")==Constants.STUDENT_ACCOUNT){
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.viewPager,new Signup3StudentFragment()).commit();
                }else if(getArguments().getInt("typeAcc")==Constants.FOUNDTION_ACCOUNT){
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.viewPager,new Signup3FoundtionFragment()).commit();

                }else {
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.viewPager,new Signup3PatientFragment()).commit();

                }
            }
        });
        btn_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}

