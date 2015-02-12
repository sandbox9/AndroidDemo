package itwise.android.demo;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import java.util.HashMap;

public class GSShopMain extends FragmentActivity implements ActionBar.TabListener {

	private static final String SELECTED_ITEM = "selected_item";

	AppSectionsPagerAdapter mAppSectionsPagerAdapter;

	ViewPager mViewPager;

//	private BkPagerAdapter mAdapter;										//아답터 객체. 아이템을 추가 하기 위해 변수 선언

	HashMap<Integer, Integer> menuMap = new HashMap<Integer, Integer>();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.i("MyActivity", "onCreate");
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.scrollable_contents);
		setContentView(R.layout.gsshop_main);

		menuMap.put(R.id.mainMenu01, R.array.subMenu01);
		menuMap.put(R.id.mainMenu02, R.array.subMenu02);
		menuMap.put(R.id.mainMenu03, R.array.subMenu03);
		menuMap.put(R.id.mainMenu04, R.array.subMenu04);
		menuMap.put(R.id.mainMenu05, R.array.subMenu05);
		menuMap.put(R.id.mainMenu06, R.array.subMenu06);


		final ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
//		actionBar.setDisplayShowHomeEnabled(false);
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setDisplayHomeAsUpEnabled(false);
		actionBar.setDisplayShowCustomEnabled(true);
//		actionBar.setLogo(null);

//		mAppSectionsPagerAdapter.setCount(subMenus.length);
//		String[] subMenus = getResources().getStringArray(R.array.subMenu01);
//		getApplicationContext();

//		mAppSectionsPagerAdapter = new AppSectionsPagerAdapter(getSupportFragmentManager());
		mAppSectionsPagerAdapter = new AppSectionsPagerAdapter(getSupportFragmentManager(), getApplicationContext());
//		mAdapter = new BkPagerAdapter(getApplicationContext());
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mAppSectionsPagerAdapter);
		mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
				actionBar.setSelectedNavigationItem(position);
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
			}
		});

		View homeIcon = findViewById(android.R.id.home);
		((View) homeIcon.getParent()).setLayoutParams(new LinearLayout.LayoutParams(0, 0));
		((View) homeIcon).setVisibility(View.GONE);

		LayoutInflater mInflater = LayoutInflater.from(this);
		View customView = mInflater.inflate(R.layout.gsshop_main_menu, null);

		actionBar.setCustomView(customView);
		actionBar.setDisplayShowCustomEnabled(true);
	}


	@Override
	public void onStart(){
		Log.i("MyActivity", "onStart");
		super.onStart();

//		첫번째 mainMenu 버튼
		View v = findViewById(R.id.mainMenu01);
		v.performClick();
		v.setSelected(true);
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
		int position = tab.getPosition();
		Log.i("MyActivity", "onTabSelected = " + position + " : " + tab.getText());

		mViewPager.setCurrentItem(position);
	}

	@Override
	public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		Log.i("MyActivity", "onCreateOptionMenu");
		getMenuInflater().inflate(R.menu.browser_main, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		Log.i("MyActivity", "onMenuItemSelected");
		return super.onMenuItemSelected(featureId, item);
	}

	public void onRadioButtonClicked(View view){
		// Is the button now checked?
		boolean checked = ((RadioButton) view).isChecked();

		Log.i("MyActivity", "onRadioButtonClicked");
		final ActionBar actionBar = getActionBar();
		actionBar.removeAllTabs();
		String[] submenu = getSubmenu(menuMap.get(view.getId()));
//		mAdapter.mItems = new ArrayList<Integer>(submenu.length);

//		mAdapter.mItems = new HashMap<Integer, Integer>();
//		for(int i = 0; i < submenu.length; i++){
//			mAdapter.addItem(i);
//		}

		setSubmenu(submenu);
	}

	public String[] getSubmenu(int selectedMenu){
		return getResources().getStringArray(selectedMenu);
	}

	public void setSubmenu(String[] subMenus){
		final ActionBar actionBar = getActionBar();
		for(int i=0; i < subMenus.length; i++){
			actionBar.addTab(actionBar.newTab().setText(subMenus[i]).setTabListener(this));
		}
	}

}
