package com.toptoche.sample;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;

import com.toptoche.searchablespinnerlibrary.SearchableListDialog;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SearchableSpinner spinner = (SearchableSpinner) findViewById(R.id.spinner);

        spinner.setFilter(new SearchableSpinner.IFilter() {
            @Override
            public boolean check(Object item, String text) {
                String itemString = item.toString();
                Pattern p = Pattern.compile(text, Pattern.CASE_INSENSITIVE);
                Matcher m = p.matcher(itemString);
                return m.find();
            }
        });
    }
}
