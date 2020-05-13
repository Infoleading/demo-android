package edu.cque.jianxing.demolistview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FirstActivity extends Activity {
	
	private ListView listView;
	private String[] data = {"Alan Curtis Kay", "Alan Turing", "Andrew Chi-Chih Yao", "Andrew S. Tanenbaum", "Charles P. Thacker", "Claude Elwood Shannon", "Donald Knuth", "Edgar F. Codd", "Edsger Dijkstra", "John Backus", "John McCarthy", "John von Neumann", "Ken Thompson", "Kenneth E. Iverson", "Linus Torvalds", "Marvin Minsky", "Niklaus Wirth", "Richard Stallman", "Stephen A. Cook", "Tim Berners-Lee", "Ward Cunningham"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first);
		
		ArrayAdapter<String> adapter = 
				new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
		listView = (ListView)findViewById(R.id.listView);
		listView.setAdapter(adapter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.first, menu);
		menu.findItem(R.id.activity1).setIntent(new Intent(this, FirstActivity.class));
		menu.findItem(R.id.activity2).setIntent(new Intent(this, SecondActivity.class));
		menu.findItem(R.id.activity3).setIntent(new Intent(this, ThirdActivity.class));
		menu.findItem(R.id.activity4).setIntent(new Intent(this, ForthActivity.class));
		menu.findItem(R.id.activity5).setIntent(new Intent(this, FifthActivity.class));
		menu.findItem(R.id.activity6).setIntent(new Intent(this, SimpleAdapterActivity.class));
		menu.findItem(R.id.activity7).setIntent(new Intent(this, BaseAdapterActivity.class));
		return true;
	}

}
