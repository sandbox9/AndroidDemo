package itwise.android.demo;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class ActionBarTabNav extends Activity implements ActionBar.TabListener {
	private static final String SELECTED_ITEM = "selected_item";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tabnav);
		final ActionBar actionBar = getActionBar();

		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionBar.setDisplayShowHomeEnabled(false);
		actionBar.setDisplayShowTitleEnabled(false);

//		View view = View.inflate(getApplicationContext(), R.layout.actionbar, null);

		actionBar.addTab(actionBar.newTab().setText("홈").setTabListener(this));
		actionBar.addTab(actionBar.newTab().setText("의류속옷").setTabListener(this));
		actionBar.addTab(actionBar.newTab().setText("잡화뷰티").setTabListener(this));
		actionBar.addTab(actionBar.newTab().setText("유아식품").setTabListener(this));
		actionBar.addTab(actionBar.newTab().setText("리빙가전").setTabListener(this));
		actionBar.addTab(actionBar.newTab().setText("레저e티켓").setTabListener(this));
	}

	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		if (savedInstanceState.containsKey(SELECTED_ITEM)) {
			getActionBar().setSelectedNavigationItem(savedInstanceState.getInt(SELECTED_ITEM));
		}
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		outState.putInt(SELECTED_ITEM, getActionBar().getSelectedNavigationIndex());
	}

	@Override
	public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

	}

	@Override
	public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
		Fragment fragment = new DummyFragment1();
		Fragment fragment2 = new DummyFragment3();

		Bundle args = new Bundle();
		args.putInt(DummyFragment1.ARG_SECTION_NUMBER, tab.getPosition() + 1);
		args.putInt(DummyFragment3.ARG_SECTION_NUMBER, tab.getPosition() + 1);
		fragment.setArguments(args);
		FragmentTransaction ft = getFragmentManager().beginTransaction();
		ft.replace(R.id.container, fragment);
		ft.commit();
	}

	@Override
	public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

	}

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//
//		getMenuInflater().inflate(R.menu.browser_main, menu);
//		RelativeLayout relativeLayout = (RelativeLayout) menu.findItem(
//				R.id.layout_item).getActionView();
//
//		View inflatedView = getLayoutInflater().inflate(
//				R.layout.media_bottombar, null);
//
//		relativeLayout.addView(inflatedView);
//
//		return true;
//	}
}
