package com.codekul.fragments;


import android.os.Bundle;
//import android.app.Fragment; will work on above 3.0
import android.support.v4.app.Fragment; // works on every version
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {

    private static final String KEY_START_ANIM = "startAnim";

    public FirstFragment() {
        // Required empty public constructor
    }

    public static FirstFragment getInstance(Boolean anim){

        FirstFragment frag = new FirstFragment();
        Bundle bundle =
                new Bundle();
        bundle.putBoolean(KEY_START_ANIM,anim);
        frag.setArguments(bundle);

        return frag;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView =
                inflater.inflate(R.layout.fragment_first, container, false);

        final ImageView imageSample =
                (ImageView) rootView.findViewById(R.id.imageSample);
        imageSample.setImageResource(R.drawable.my);

        if(getArguments()
                .getBoolean(KEY_START_ANIM)){

            imageSample
                    .startAnimation(AnimationUtils
                            .loadAnimation(getActivity(),
                                    R.anim.mixed_anim));
        }

        return rootView;
    }

}
