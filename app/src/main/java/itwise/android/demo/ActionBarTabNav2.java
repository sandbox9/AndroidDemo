package itwise.android.demo;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import itwise.android.demo.utils.BkUtils;

import java.util.HashMap;

public class ActionBarTabNav2 extends FragmentActivity implements ActionBar.TabListener {

	private static final String SELECTED_ITEM = "selected_item";

	AppSectionsPagerAdapter mAppSectionsPagerAdapter;

	ViewPager mViewPager;

	private BkPagerAdapter mAdapter;										//아답터 객체. 아이템을 추가 하기 위해 변수 선언

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
		mAdapter = new BkPagerAdapter(getApplicationContext());
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mAdapter);
		mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
//				Log.i("MyActivity", "onPageSelected :" + position);
				actionBar.setSelectedNavigationItem(position);
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
//				Log.i("MyActivity", "onPageScrolled" + arg0 + ", " + arg1 + ", " + arg2);
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
//				Log.i("MyActivity", "onPageScrollStateChanged :" + arg0);
			}
		});

		View homeIcon = findViewById(android.R.id.home);
		((View) homeIcon.getParent()).setLayoutParams(new LinearLayout.LayoutParams(0, 0));
		((View) homeIcon).setVisibility(View.GONE);

		LayoutInflater mInflater = LayoutInflater.from(this);
		View customView = mInflater.inflate(R.layout.custom_actionbar, null);

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

//		int currentItem = mViewPager.getCurrentItem();
//		mAdapter.addItem(position);
//		if (currentItem > 0) {
//
//		}

//		if (! mAdapter.mItems.containsKey(position)) {
//			Log.i("MyActivity", "포함되있지 않음 :" + position);
//			mAdapter.addItem(position);
//		}

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
		mAdapter.mItems = new HashMap<Integer, Integer>();
		for(int i = 0; i < submenu.length; i++){
			mAdapter.addItem(i);
		}
		setSubmenu(submenu);


//		reset item
//		for(int i = 0; i < submenu.length; i++){
//			mAppSectionsPagerAdapter.addItem(i);
//		}

//		mAppSectionsPagerAdapter.setCount(submenu.length);
//		mViewPager = (ViewPager) findViewById(R.id.pager);
//		mViewPager.setAdapter(mAppSectionsPagerAdapter);
//		mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
//			@Override
//			public void onPageSelected(int position) {
//				// When swiping between different app sections, select the corresponding tab.
//				// We can also use ActionBar.Tab#select() to do this if we have a reference to the
//				// Tab.
//				actionBar.setSelectedNavigationItem(position);
//			}
//		});

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

	//Pager 아답터 구현
	private class BkPagerAdapter extends PagerAdapter {

		private Context mContext;
		private HashMap<Integer, Integer> mItems;			//아이템 뷰의 타입. 아이템 갯수 만큼

		public BkPagerAdapter(Context context) {
			super();
			mContext = context;
//			mItems = new ArrayList<Integer>();
//			mItems.add(BkUtils.TYPE_TEXTVIEW);		//최초 1개의 아이템은 기본으로 생성한다

			//최초 1개의 아이템은 기본으로 생성한다
			mItems = new HashMap<Integer, Integer>();
			mItems.put(0, BkUtils.TYPE_TEXTVIEW);
		}

		//뷰 페이저의 아이템 갯수는 리스트의 갯수
		//나중에 뷰 페이저에 아이템을 추가하면 리스트에 아이템의 타입을 추가 후 새로 고침하게 되면
		//자동으로 뷰 페이저의 갯수도 늘어난다.
		@Override
		public int getCount() {
			return mItems == null ? 0 : mItems.size();
//			return 5;
		}

//		//뷰페이저에서 사용할 뷰객체 생성/등록
//		@Override
//		public Object instantiateItem(View pager, int position) 	{
//			Log.i("adapter", "position : " + position);
//
//			View v = null;
//
//			v = BkUtils.getView(mItems.get(position), mContext);	//해당 포지션의 아이템 뷰를 생성한다
//			((ViewPager)pager).addView(v);
//
//			return v;
//		}

		//뷰페이저에서 사용할 뷰객체 생성/등록
		@Override
		public Object instantiateItem(ViewGroup container, int position) 	{
			Log.i("adapter", "*** position : " + position);
			View v = null;
			v = BkUtils.getView(mItems.get(position), mContext);	//해당 포지션의 아이템 뷰를 생성한다
			container.addView(v);
//			container.onInterceptTouchEvent()
			return v;
		}

		//뷰 객체 삭제.
		@Override
		public void destroyItem(View pager, int position, Object view) {
			((ViewPager)pager).removeView((View)view);
		}

		// instantiateItem메소드에서 생성한 객체를 이용할 것인지
		@Override
		public boolean isViewFromObject(View view, Object obj) {
			return view == obj;
		}

//		@Override public void finishUpdate(View arg0) {}
		@Override public void restoreState(Parcelable arg0, ClassLoader arg1) {}
		@Override public Parcelable saveState() { return null; }
//		@Override public void startUpdate(View arg0) {}

		/**
		 * 동적으로 아이템을 추가하는 메소드
		 * @param position - 아이템 타입
		 */
		public void addItem(int position){
			Log.i("adapter", "addItem " + position);
//			mItems.add(position);			//아이템 목록에 추가
			mItems.put(position, BkUtils.TYPE_TEXTVIEW);
			notifyDataSetChanged();		//아답터에 데이터 변경되었다고 알림. 알아서 새로고침
		}
	} // end class
}
