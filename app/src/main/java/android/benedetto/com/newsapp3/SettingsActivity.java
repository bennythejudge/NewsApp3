package android.benedetto.com.newsapp3;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import java.util.List;



public class SettingsActivity extends AppCompatActivity {
    static String TAG = "settings";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "inside SettingsActivity");
        setContentView(R.layout.settings_activity);
    }

    public static class NewsApp3PreferenceFragment
            extends PreferenceFragment
            implements Preference.OnPreferenceChangeListener {

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferences);

            Log.d(TAG, "inside onCreate inside NewsApp3PreferenceFragment");

            Preference searchString = findPreference(getString(R.string.settings_search_string_key));
            Log.d(TAG, "searchString >>>>>>>>> " + searchString);

            Log.d(TAG, "Take it easy");
            bindPreferenceSummaryToValue(searchString);
        }

        private void bindPreferenceSummaryToValue(Preference preference) {

            Log.d(TAG, "inside bindPreferenceSummaryToValue");

            preference.setOnPreferenceChangeListener(this);
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(preference.getContext());

            Log.d(TAG, "preference.getKey() >>>>>>>>> " + preference.getKey());

            String preferenceString = preferences.getString(preference.getKey(), "");
            Log.d(TAG, "preferenceString >>>>>>>>> " + preferenceString);
            onPreferenceChange(preference, preferenceString);
        }

        @Override
        public boolean onPreferenceChange(Preference preference, Object value) {

            Log.d(TAG, "inside onPreferenceChange preference: " + preference);

            String stringValue = value.toString();

            Log.d(TAG, "point 9 inside onPreferenceChange2 stringValue: " + stringValue);


            if (preference instanceof ListPreference) {
                Log.d(TAG, "inside onPreferenceChange inside if");

                ListPreference listPreference = (ListPreference) preference;
                int prefIndex = listPreference.findIndexOfValue(stringValue);
                Log.d(TAG, "point 10 prefIndex : " + prefIndex);
                if (prefIndex >= 0) {
                    CharSequence[] labels = listPreference.getEntries();
                    Log.d(TAG, "inside onPreferenceChange inside if about to setSummary");
                    Log.d(TAG, "prefIndex: " + prefIndex);
                    Log.d(TAG, "labels: " + labels);
                    Log.d(TAG, "labels length: " + labels.length);

                    preference.setSummary(labels[prefIndex]);
                }
            } else {
                Log.d(TAG, "inside onPreferenceChange inside else");

                preference.setSummary(stringValue);

                Log.d(TAG, "inside onPreferenceChange after setSummray");

            }
            return true;
        }
    }
}
