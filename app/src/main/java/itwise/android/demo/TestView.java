package itwise.android.demo;

import android.content.Context;
import android.util.Log;
import android.view.View;

/**
 * Created by kkuru on 2015-02-04.
 */
public class TestView extends View implements View.OnClickListener{
	public TestView(Context context) {
		super(context);
	}

	@Override
	public void onClick(View v) {
		Log.i("MyActivity", "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxr ");
	}
}
