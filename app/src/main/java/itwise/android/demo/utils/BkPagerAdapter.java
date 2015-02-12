package itwise.android.demo.utils;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashMap;

//Pager 아답터 구현
public class BkPagerAdapter extends PagerAdapter {

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
		mItems.put(position, BkUtils.TYPE_LISTVIEW);
		notifyDataSetChanged();		//아답터에 데이터 변경되었다고 알림. 알아서 새로고침
	}

} // end class