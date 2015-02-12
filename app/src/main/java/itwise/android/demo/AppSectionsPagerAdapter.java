package itwise.android.demo;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import itwise.android.demo.gsshop.ListViewDemoFragment;
import itwise.android.demo.gsshop.ListViewProductFragment;

/**
 * Created by kkuru on 2015-02-05.
 */
public class AppSectionsPagerAdapter extends FragmentPagerAdapter {

	private int count = 5;
	private Context context;

//	public AppSectionsPagerAdapter(FragmentManager fm) {
//		super(fm);
//	}


	public AppSectionsPagerAdapter(FragmentManager fm, Context context) {
		super(fm);
		context = context;
	}


	@Override
	public Fragment getItem(int i) {

		switch (i) {
			case 0:
				// The first section of the app is the most interesting -- it offers
				// a launchpad into the other demonstrations in this example application.
				return new LaunchpadSectionFragment();

			case 1:
				Log.i("eeeee", "case 1 ListViewDemoFragment");
				return new ListViewDemoFragment();
			case 2 :
				Log.i("eeeee", "case 2 ListViewProductFragment");
				return new ListViewProductFragment();

			default:
				// The other sections of the app are dummy placeholders.
				Log.i("eeeee", "default Dummy");
				Fragment fragment = new DummySectionFragment();
				Bundle args = new Bundle();
				args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, i + 1);
				fragment.setArguments(args);
				return fragment;
		}
	}

	@Override
	public int getCount() {
		return this.count;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return "Section " + (position + 1);
	}

	public void setCount(int count) {
		this.count = count;
	}
}