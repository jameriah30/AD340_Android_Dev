package com.example.jamer.helloworld;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.jamer.helloworld.entity.Settings;

import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Objects;

public class SettingsFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    TextView settingsTitle;
    TextView timeReminderText;
    Spinner timeReminder;
    TextView maxDistText;
    Spinner maxDist;
    TextView genderText;
//    Spinner gender;
    EditText gender;

    ToggleButton privacy;
    TextView minAgeText;
    TextView maxAgeText;
    EditText minAge;
    EditText maxAge;
    Button update;

//    String genderResult;
    String maxDistUpdate;
    String timeReminderUpdate;

    ArrayAdapter<CharSequence> timeReminderAdapter;
    ArrayAdapter<CharSequence> distanceAdapter;
//    ArrayAdapter<CharSequence> genderAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        settingsTitle = view.findViewById(R.id.settingsFragment);
        timeReminderText = view.findViewById(R.id.timeReminderText);
        timeReminder = view.findViewById(R.id.timeReminder);
        maxDistText = view.findViewById(R.id.maxDistText);
        maxDist = view.findViewById(R.id.maxDist);
        genderText = view.findViewById(R.id.genderText);
        gender = view.findViewById(R.id.gender);
        privacy = view.findViewById(R.id.privacy);
        minAgeText = view.findViewById(R.id.minAgeText);
        minAge = view.findViewById(R.id.minAge);
        maxAgeText = view.findViewById(R.id.maxAgeText);
        maxAge = view.findViewById(R.id.maxAge);
        update = view.findViewById(R.id.updateBtn);

        new GetSettingsTask(getActivity(), this, Constants.DB_PRIMARYKEY).execute();


        distanceAdapter = ArrayAdapter.createFromResource(Objects.requireNonNull(getContext()),
                R.array.max_distance_array, android.R.layout.simple_spinner_dropdown_item);
        distanceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        maxDist.setAdapter(distanceAdapter);

        timeReminderAdapter = ArrayAdapter.createFromResource(Objects.requireNonNull(getContext()),
                R.array.time_reminder_array, android.R.layout.simple_spinner_dropdown_item);
        timeReminderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        timeReminder.setAdapter(timeReminderAdapter);

        update.setOnClickListener(v -> {

            Settings settings = new Settings();


            if (!gender.getText().toString().isEmpty()) {
                String genderResult = gender.getText().toString();
                settings.setGender(genderResult);
            } else {
                Alert(Constants.GENDER_MESSAGE);
            }

            if (!minAge.getText().toString().isEmpty()) {
                String minAgeUpdate = minAge.getText().toString();
                int finalMinAge = Integer.parseInt(minAgeUpdate);
                settings.setMinAge(finalMinAge);//
            } else {
                Alert(Constants.AGE_MSG);
            }

            if (!maxAge.getText().toString().isEmpty()) {
                String maxAgeUpdate = maxAge.getText().toString();
                int updatedMaxAge = Integer.parseInt(maxAgeUpdate);
                settings.setMaxAge(updatedMaxAge);
            } else {
                Alert(Constants.AGE_MSG);

            }

            if (privacy.isChecked()) {
                Boolean profilePrivateBool = privacy.isChecked();
                settings.setProfilePublic(profilePrivateBool);
            } else {
                settings.setProfilePublic(false);
            }


            maxDistUpdate = maxDist.getSelectedItem().toString();
            settings.setMaxDistance(maxDistUpdate);

            timeReminderUpdate = timeReminder.getSelectedItem().toString();
            settings.setMatchTimeReminder(timeReminderUpdate);

        });

        return view;
    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    public void Alert(String message) {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext());
        builder1.setMessage(message);
        builder1.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        builder1.show();
    }

    private static class UpdateSettingsTask extends AsyncTask<Void, Void, Settings> {

        private WeakReference<Activity> weakActivity;
        private Settings settings;


        public UpdateSettingsTask(Activity activity, Settings settings) {
            weakActivity = new WeakReference<>(activity);
            this.settings = settings;
        }

        @Override
        protected Settings doInBackground(Void... voids) {
            Activity activity = weakActivity.get();
            if (activity == null) {
                return null;
            }
            AppDatabase db = AppDatabaseSingleton.getDatabase(activity.getApplicationContext());
            db.settingsDao().insertAll(settings);

            return settings;
        }
    }

    private static class GetSettingsTask extends AsyncTask<Void, Void, Settings> {

        private WeakReference<Activity> weakActivity;
        private WeakReference<SettingsFragment> weakFrag;
        private String appId;
        private SettingsFragment fragment;

        public GetSettingsTask(Activity activity, SettingsFragment fragment, String appId) {
            this.weakActivity = new WeakReference<>(activity);
            this.appId = appId;
            this.weakFrag = new WeakReference<>(fragment);
        }

        @Override
        protected Settings doInBackground(Void... voids) {
            Activity activity = weakActivity.get();
            if (activity == null) {
                return null;
            }

            AppDatabase db = AppDatabaseSingleton.getDatabase(activity.getApplicationContext());

            String[] appIds = {this.appId};
            List<Settings> settings = db.settingsDao().loadAllByIds(appIds);

            if (settings.size() <= 0 || settings.get(0) == null) {
                return null;
            }
            Log.v("ListSettings", settings.get(0).toString());
            return settings.get(0);
        }

        @Override
        protected void onPostExecute(Settings settings) {
            this.fragment = weakFrag.get();
            if (settings == null || fragment == null) {
                return;
            }





            String timeReminderValue = settings.getMatchTimeReminder();
            if (timeReminderValue != null) {
                int spinnerPosition = fragment.timeReminderAdapter.getPosition(timeReminderValue);
                fragment.timeReminder.setSelection(spinnerPosition);
            }

            String maxDistValue = settings.getMaxDistance();
            if (maxDistValue != null) {
                int spinnerPosition = fragment.distanceAdapter.getPosition(maxDistValue);
                fragment.maxDist.setSelection(spinnerPosition);
            }

            if (settings.isProfilePublic()) {
                fragment.privacy.toggle();
            }

            String genderUpdate = settings.getGender();
            fragment.gender.setText(genderUpdate);

            String finalMinAge = Integer.toString(settings.getMinAge());
            fragment.minAge.setText(finalMinAge);

            String finalMaxAge = Integer.toString(settings.getMaxAge());
            fragment.maxAge.setText(finalMaxAge);
        }
    }
}