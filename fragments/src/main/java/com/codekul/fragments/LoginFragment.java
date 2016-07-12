package com.codekul.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {


    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_login, container, false);

        rootView.findViewById(R.id.btnLogin)
                .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final EditText edtUserName = (EditText)
                        rootView.findViewById(R.id.edtUserName);

                final EditText edtPassword = (EditText)
                        rootView.findViewById(R.id.edtPassword);

                if(edtUserName
                        .getText()
                        .toString()
                        .equals("android") && edtPassword
                        .getText()
                        .toString()
                        .equals("android")){

                    MainActivity act = (MainActivity) getActivity();

                    /*FirstFragment frag = new FirstFragment();
                    Bundle bundle =
                            new Bundle();
                    bundle.putBoolean("key_start_anim",true);
                    frag.setArguments(bundle);*/

                    act.runFragmentTransaction(R.id.frameContainer,
                            FirstFragment.getInstance(true));

                }

            }
        });

        return rootView;
    }

}
