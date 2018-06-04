package android.benedetto.com.newsapp3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        /* The above code is the typical pattern used to add a fragment to an activity so that
         the fragment appears as the main content of the activity. You use:
         getFragmentManager() if the class extends Activity and the fragment extends
         PreferenceFragment.
         getSupportFragmentManager() if the class extends AppCompatActivity and the fragment
         extends PreferenceFragmentCompat.
        */
        getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragment())
                .commit();
    }
}
