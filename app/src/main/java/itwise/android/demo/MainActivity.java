package itwise.android.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	Intent intent = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		findViewById(R.id.button1).setOnClickListener(
			new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					intent = new Intent(MainActivity.this, ActionBarTabNav.class);
					startActivity(intent);
				}
			}
		);

		findViewById(R.id.button2).setOnClickListener(
			new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					intent = new Intent(MainActivity.this, ActionBarTabSwipeNav.class);
					startActivity(intent);
				}
			}
		);

		findViewById(R.id.button3).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						intent = new Intent(MainActivity.this, ActionBarTabNav2.class);
						startActivity(intent);
					}
				}
		);

		findViewById(R.id.button4).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						intent = new Intent(MainActivity.this, GSShopMain.class);
						startActivity(intent);
					}
				}
		);

	}
}
