package itwise.android.demo.utils;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.DigitalClock;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;


import java.text.SimpleDateFormat;
import java.util.Date;

import itwise.android.demo.R;

public class BkUtils {
	/** 뷰페이저 아이템 종류 */
	public static final int
			TYPE_TEXTVIEW = 0
			, TYPE_SCROLLVIEW = 1
			, TYPE_LISTVIEW = 2;
	
	/**
	 * 뷰 페이저에 추가할 뷰를 생성하여 반환한다
	 * @param type - 추가할 뷰 타입
	 * @param con - 뷰 생성에 사용할 Context
	 * @return 뷰 객체
	 */
	public static View getView(int type, Context con) {
		if(type == TYPE_TEXTVIEW)
			return getTextView(con);
		else if(type == TYPE_SCROLLVIEW)
			return getScrollView(con);
		else if(type == TYPE_LISTVIEW)
			return getListView(con);
		else
			return getDigitalClock(con);
	}
	
	/**
	 * 텍스트 뷰를 생성하여 반환한다
	 * @param con - 뷰 생성에 사용할 Context
	 * @return 텍스트 뷰
	 */
	private static TextView getTextView(Context con) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		Log.i("adapter", "new TextView : " + timeStamp);
		int color = (int)(Math.random()*256);
		TextView tv = new TextView(con);
		tv.setBackgroundColor(Color.rgb(color, color, color));	//배경색 지정
		tv.setText("TextView Item : " + timeStamp);							//글자지정
		tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24);		//글자 크기 24sp
		
		color = 255 - color;
		tv.setTextColor(Color.rgb(color, color, color));			//글자 색상은 배경과 다른 색으로
		tv.setGravity(Gravity.CENTER);
		return tv;
	}
	
	/**
	 * 여러개의 뷰가 있는 스크롤 뷰를 반환한다
	 * @param con - 뷰 생성에 사용할 Context
	 * @return 스크롤 뷰
	 */
	private static ScrollView getScrollView(Context con) {
		ScrollView sv = new ScrollView(con);
		
		LinearLayout ll = new LinearLayout(con);
		ll.setOrientation(LinearLayout.VERTICAL);
		
		ll.addView(getTextView(con));
		ll.addView(getAnalogClock(con));
		ll.addView(getDigitalClock(con));
		ll.addView(getImageView(con));
		
		sv.addView(ll);
		return sv;
	}
	
	/**
	 * 리스트 뷰를 생성하여 반환한다
	 * @param con - 뷰 생성에 사용할 Context
	 * @return 리스트 뷰
	 */
	private static ListView getListView(Context con) {
		ListView lv = new ListView(con);
		lv.setScrollingCacheEnabled(false);
		lv.setAnimationCacheEnabled(false);
		
		lv.setAdapter(new BkListViewAdapter(con));
		return  lv;
	}
	
	private static ImageView getImageView(Context con) {
		ImageView iv = new ImageView(con);
		iv.setImageResource(R.drawable.tab_icon01_ov);
		return iv;
	}
	
	private static AnalogClock getAnalogClock(Context con) {
		AnalogClock clock = new AnalogClock(con);
		return clock;
	}
	
	private static DigitalClock getDigitalClock(Context con){
		return new DigitalClock(con);
	}
}
