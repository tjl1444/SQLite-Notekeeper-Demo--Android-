package com.example.sqlitenotesdemo;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
	DatabaseDataManager dm;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		dm = new DatabaseDataManager(this);
		
		dm.saveNote(new Note("Note 1", "note 1 text"));
		dm.saveNote(new Note("Note 2", "note 2 text"));
		dm.saveNote(new Note("Note 3", "note 3 text"));
		
		List<Note> notes = dm.getAllNotes();
		Log.d("demo", notes.toString());
		
	       ListView myListView = (ListView) findViewById(R.id.listView1);        
	        ArrayAdapter<Note> adapter = new ArrayAdapter<Note>(this, 
	        		android.R.layout.simple_list_item_1, android.R.id.text1, notes);        
	        myListView.setAdapter(adapter);
		
	}

	@Override
	protected void onDestroy() {
		dm.close();
		super.onDestroy();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
