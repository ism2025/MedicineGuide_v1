package com.example.ismailamassi.finalprojectandroid.Fragments.StudentFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ismailamassi.finalprojectandroid.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class StudentSavedFragment extends Fragment {


    public StudentSavedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_studentsaved, container, false);
    }

}
