package itwise.android.demo;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DummyFragment2 extends Fragment {

	public static final String ARG_SECTION_NUMBER = "section_number";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		TextView textView = new TextView(getActivity());
		textView.setGravity(Gravity.CENTER_HORIZONTAL);
		Bundle args = getArguments();
		textView.setText("dummy fragment2 : " + args.getInt(ARG_SECTION_NUMBER) + " Tab ҳ");
		textView.setTextSize(30);

		return textView;
	}
}
