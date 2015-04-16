package com.example.student.androidguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;


public class Terminology extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.terminology);

        init();
    }

    public void init() {
        AutoCompleteTextView acTVTerm = (AutoCompleteTextView) findViewById(R.id.acTVTerm);


        final String[] term;
        term = getResources().getStringArray(R.array.terms);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,term);
        acTVTerm.setAdapter(adapter);

        acTVTerm.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                int idx = 0;

                String str = parent.getItemAtPosition(position).toString();

                for(int i=0; i<term.length; i++){
                    if(str.equals(term[i])){
                        idx = i;
                    }
                }

                Toast.makeText(getApplicationContext(), "You have selected the term: " + (CharSequence)parent.getItemAtPosition(position), Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getApplicationContext(), TermDefinition.class);
                intent.putExtra("str", str);
                intent.putExtra("idx", idx);
                startActivity(intent);
            }

            //public AdapterView.OnItemClickListener getOnItemClickListener ()

        });




    }
    /*
    autoComplete.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            String str = (String) adapterView.getItemAtPosition(position);
            autoComplete.setText(str);
        }
    });
    */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}


