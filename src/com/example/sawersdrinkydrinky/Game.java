package com.example.sawersdrinkydrinky;

import java.util.ArrayList;
import java.util.Random;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Game extends ActionBarActivity {
	
	public ArrayList<String> questions = new ArrayList<String>();
	public ArrayList<String> answers = new ArrayList<String>();
	public ArrayList<Player> players = new ArrayList<Player>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		
		Intent intent = getIntent();
		ArrayList<String> playerNames = (ArrayList<String>) intent.getStringArrayListExtra("Players");
		players.add(new Player(playerNames.get(0)));
		players.add(new Player(playerNames.get(1)));
		players.add(new Player(playerNames.get(2)));
		players.add(new Player(playerNames.get(3)));
		
		Button b1 = (Button) findViewById(R.id.button1);
		b1.setText(buttonText(players.get(0))); 
		Button b2 = (Button) findViewById(R.id.button2);
		b2.setText(buttonText(players.get(1)));
		Button b3 = (Button) findViewById(R.id.button3);
		b3.setText(buttonText(players.get(2)));
		Button b4 = (Button) findViewById(R.id.button4);
		b4.setText(buttonText(players.get(3)));
		
		
		for(String s : getResources().getStringArray(R.array.questions)){
			questions.add(s);
		}
		for(String s : getResources().getStringArray(R.array.answers)){
			answers.add(s);
		}
		
		TextView textView = (TextView) findViewById(R.id.textView1);
		TextView textView2 = (TextView) findViewById(R.id.textView2);
		
		Random rand = new Random();
	    int index = rand.nextInt(questions.size());
		
		textView.setText(questions.get(index));
		textView2.setText(answers.get(index));
		
		questions.remove(index);
		answers.remove(index);
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game, menu);
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
	
	private String buttonText(Player p){
		return p.name + " - " + p.points;
	}
	
	public void nextQuestion(View view){
		if(questions.size() == 0){
			return;
		}
		
		Button button = (Button) view;
		
		switch(button.getId()){
			case (R.id.button1):
				players.get(0).points += 1;
				button.setText(buttonText(players.get(0)));
				break;
			case (R.id.button2):
				players.get(1).points += 1;
				button.setText(buttonText(players.get(1)));
				break;
			case (R.id.button3):
				players.get(2).points += 1;
				button.setText(buttonText(players.get(2)));
				break;
			case (R.id.button4):
				players.get(3).points += 1;
				button.setText(buttonText(players.get(3)));
				break;
		}
				
		TextView textView = (TextView) findViewById(R.id.textView1);
		TextView textView2 = (TextView) findViewById(R.id.textView2);
		
		Random rand = new Random();
	    int index = rand.nextInt(questions.size());
		
		textView.setText(questions.get(index));
		textView2.setText(answers.get(index));
		
		questions.remove(index);
		answers.remove(index);
	}
}
