package com.example.jamer.helloworld;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static android.content.ContentValues.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    private TextView say_my_name;
    private TextView welcome;
    private TextView p_age;
    private TextView p_occupation;
    private TextView p_description;


    public ProfileFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View profileView = inflater.inflate(R.layout.fragment_profile, container, false);


        say_my_name = profileView.findViewById(R.id.say_my_name);
        welcome = profileView.findViewById(R.id.welcome);
        p_age = profileView.findViewById(R.id.p_age);
        p_occupation = profileView.findViewById(R.id.p_occupation);
        p_description = profileView.findViewById(R.id.p_description);

        StringBuilder msg = new StringBuilder("Thank you for registering- ");
        Intent intent = getActivity().getIntent();
        Bundle b = intent.getExtras();
        Log.i(TAG, "intent");



        assert b != null;
        if (b.containsKey(Constants.KEY_USERNAME)){
            String userName = b.getString(Constants.KEY_USERNAME);
            welcome.append(userName);
        }

        if (b.containsKey(Constants.KEY_AGE)){
            String age = b.getString(Constants.KEY_AGE);
            p_age.append(age);
        }

        if (b.containsKey(Constants.KEY_OCCUPATION)){
            String occupation = b.getString(Constants.KEY_OCCUPATION);
            p_occupation.append(occupation);
        }

        if (b.containsKey(Constants.KEY_DESCRIPTION)){
            String description = b.getString(Constants.KEY_DESCRIPTION);
            p_description.append(description);
        }

        return profileView;
    }


}
