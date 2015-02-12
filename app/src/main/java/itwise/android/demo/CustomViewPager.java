package itwise.android.demo;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by kkuru on 2015-02-09.
 */
public class CustomViewPager extends ViewPager {

	float mStartDragX;
	OnSwipeOutListener mListener;

	public CustomViewPager(Context context) {
		super(context);
	}


	public void setOnSwipeOutListener(OnSwipeOutListener listener) {
		mListener = listener;
	}


	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		Log.i("adapter", "onInterceptTouchEvent : ");
		float x = ev.getX();
		switch (ev.getAction()) {
			case MotionEvent.ACTION_DOWN:
				mStartDragX = x;
				break;
			case MotionEvent.ACTION_MOVE:
				if (mStartDragX < x && getCurrentItem() == 0) {
					mListener.onSwipeOutAtStart();
				} else if (mStartDragX > x && getCurrentItem() == getAdapter().getCount() - 1) {
					mListener.onSwipeOutAtEnd();
				}
				break;
		}
		return super.onInterceptTouchEvent(ev);
	}

	public interface OnSwipeOutListener {
		public void onSwipeOutAtStart();
		public void onSwipeOutAtEnd();
	}

}
