package com.example.ismailamassi.finalprojectandroid.Fragments.DoctorFragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ismailamassi.finalprojectandroid.Helper.Constants;
import com.example.ismailamassi.finalprojectandroid.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MidicineItemFragment extends Fragment {

    Bundle argument;
    String typeBundle;
    public MidicineItemFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_midicine_item, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        argument=getArguments();
        if(argument!=null){
            typeBundle=argument.getString("type");
            if(typeBundle.equals(Constants.GROUP_BANDLE)){
                Toast.makeText(getContext(),"group Midicine",Toast.LENGTH_SHORT).show();
            }else if (typeBundle.equals(Constants.DEPARTMENT_BANDLE)){
                Toast.makeText(getContext(),"department Midicine",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
