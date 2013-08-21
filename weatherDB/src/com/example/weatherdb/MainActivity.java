/*
* Query Yahoo! weather web server and parse the temperature information for a given key (zipcode).
* Author: JJ
*/
package com.example.weatherdb;

import com.example.weatherdb.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;


public class MainActivity extends Activity {
	Button OKbutton = null;
	EditText tEdit = null;
	String inZipcode = "";
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        OKbutton = (Button)findViewById(R.id.OKbutton);
    	tEdit = (EditText)findViewById(R.id.editText1);
    	
    	// Note: this is just for practice; unused in the app
        tEdit.setOnEditorActionListener(
                new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH ||
                    event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                	
                		
                    return true;
                }
                return false;
            }
        });
        
        
        // Button click listener and callback
        OKbutton.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		inZipcode = tEdit.getText().toString();
        		View myView = tEdit.getRootView();
        		
        		// New thread for sending HTTP request
        		FetchForcast fCast = new FetchForcast(myView);
        		fCast.execute(inZipcode);
        	}
        	}
        );
    }

    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
