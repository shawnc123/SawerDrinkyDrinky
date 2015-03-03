package com.example.sawersdrinkydrinky;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class EnterPlayers extends ActionBarActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_enter_players);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.enter_players, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void startGame(View view){
		ArrayList<String> players = new ArrayList<String>();
		
		String p1;
		EditText editText = (EditText) findViewById(R.id.player1);
		p1 = editText.getText().toString();
		players.add(p1);
		
		String p2;
		editText = (EditText) findViewById(R.id.player2);
		p2= editText.getText().toString();
		players.add(p2);
		
		String p3;
		editText = (EditText) findViewById(R.id.player3);
		p3 = editText.getText().toString();
		players.add(p3);
		
		String p4;
		editText = (EditText) findViewById(R.id.player4);
		p4 = editText.getText().toString();
		players.add(p4);
		
		
		Log.d("HERE", "HERE");
		
		Intent intent = new Intent(this, Game.class);
		intent.putStringArrayListExtra("Players", players);
    	startActivity(intent);
	}
}
