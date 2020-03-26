package com.hiq.sensor;

import android.content.res.Resources;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;

public class Preferences extends PreferenceActivity {
    private void a(final String str, EditTextPreference editTextPreference) {
        editTextPreference.setSummary(str + 9 + editTextPreference.getText());
        editTextPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            public boolean onPreferenceChange(Preference preference, Object obj) {
                preference.setSummary(str + 9 + ((String) obj));
                return true;
            }
        });
    }

    private void a(final String str, ListPreference listPreference) {
        listPreference.setSummary(str + 9 + listPreference.getEntry());
        listPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            public boolean onPreferenceChange(Preference preference, Object obj) {
                preference.setSummary(str + 9 + ((ListPreference) preference).getEntry());
                return true;
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Resources resources = getResources();
        addPreferencesFromResource(R.xml.settings);
        a(resources.getString(R.string.freq_summary), (EditTextPreference) findPreference("frequency"));
        a(resources.getString(R.string.ip_summary), (EditTextPreference) findPreference("ip"));
        a(resources.getString(R.string.port_summary), (EditTextPreference) findPreference("port"));
        a(resources.getString(R.string.logfile_summary), (EditTextPreference) findPreference("logfile"));
        a(resources.getString(R.string.maxFileSize_summary), (EditTextPreference) findPreference("maxLogSize"));
        a(resources.getString(R.string.colorScheme_summary), (ListPreference) findPreference("colorScheme"));
        a(resources.getString(R.string.updateSpeed_summary), (ListPreference) findPreference("updateSpeed"));
    }
}
