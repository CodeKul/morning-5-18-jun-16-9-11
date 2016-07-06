package com.codekul.fragments;


import android.os.Bundle;
//import android.app.Fragment; will work on above 3.0
import android.support.v4.app.Fragment; // works on every version
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {


    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView =
                inflater.inflate(R.layout.fragment_first, container, false);

        final ImageView imageSample =
                (ImageView) rootView.findViewById(R.id.imageSample);
        imageSample.setImageResource(R.drawable.my);


        return rootView;
    }

}
