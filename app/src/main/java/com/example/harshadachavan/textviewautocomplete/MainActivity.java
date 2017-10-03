package com.example.harshadachavan.textviewautocomplete;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    private SQLiteCountryAssistant sqlliteCountryAssistant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.autocompleteCountry);

        sqlliteCountryAssistant = new SQLiteCountryAssistant(MainActivity.this);
        sqlliteCountryAssistant.openDB();

        // Insert a few countries that begin with "C"
        sqlliteCountryAssistant.insertCountry("HP inkjet printer");
        sqlliteCountryAssistant.insertCountry("Television");
        sqlliteCountryAssistant.insertCountry("Laptop");
        sqlliteCountryAssistant.insertCountry("Mobile");
        sqlliteCountryAssistant.insertCountry("Refrigerator");
        sqlliteCountryAssistant.insertCountry("Furniture");
        sqlliteCountryAssistant.insertCountry("Textbook");
        sqlliteCountryAssistant.insertCountry("China clay pot");

        //sqlliteCountryAssistant.removeCountry("Chad");
        //sqlliteCountryAssistant.updateCountry("Canada", "Costa Rica");

        String[] countries = sqlliteCountryAssistant.getAllCountries();

        // Print out the values to the log
        for(int i = 0; i < countries.length; i++)
        {
            Log.i(this.toString(), countries[i]);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item, countries);
        textView.setAdapter(adapter);
    }

    public void onDestroy()
    {
        super.onDestroy();
        sqlliteCountryAssistant.close();
    }
    }

