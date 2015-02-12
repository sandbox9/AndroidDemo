package itwise.android.demo.gsshop;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

import itwise.android.demo.R;

public class ListViewDemoFragment extends ListFragment {
	private List<ListViewItem> mItems;        // ListView items list
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // initialize the items list
        mItems = new ArrayList<ListViewItem>();
        Resources resources = getResources();

		String[] mActors = getResources().getStringArray(R.array.actor);
		String[] mTitles = getResources().getStringArray(R.array.avengers);

		for(int i = 0; i < 5; i++){
			mItems.add(new ListViewItem(resources.getDrawable(R.drawable.avengers1), mActors[0] + i, mTitles[0]));
			mItems.add(new ListViewItem(resources.getDrawable(R.drawable.avengers2), mActors[1] + i, mTitles[1]));
			mItems.add(new ListViewItem(resources.getDrawable(R.drawable.avengers3), mActors[2] + i, mTitles[2]));
		}

        // initialize and set the list adapter
        setListAdapter(new ListViewDemoAdapter(getActivity(), mItems));
    }
    
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // remove the dividers from the ListView of the ListFragment
        getListView().setDivider(null);
    }
 
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // retrieve theListView item
        ListViewItem item = mItems.get(position);
        
        // do something
        Toast.makeText(getActivity(), item.title, Toast.LENGTH_SHORT).show();
    }
}