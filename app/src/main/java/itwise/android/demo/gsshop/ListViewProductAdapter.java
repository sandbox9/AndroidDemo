package itwise.android.demo.gsshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

import itwise.android.demo.R;

public class ListViewProductAdapter extends ArrayAdapter<ListViewProduct> {

    public ListViewProductAdapter(Context context, List<ListViewProduct> items) {
		super(context, R.layout.gsshop_listview_item, items);
    }
 
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        
        if(convertView == null) {
            // inflate the GridView item layout

			LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.gsshop_listview_item, parent, false);
            
            // initialize the view holder
            viewHolder = new ViewHolder();
            viewHolder.ivIcon = (ImageView) convertView.findViewById(R.id.ivIcon);
            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
//            viewHolder.tvStatus = (TextView) convertView.findViewById(R.id.tvStatus);
            viewHolder.tvPrice = (TextView) convertView.findViewById(R.id.tvPrice);
//            viewHolder.tvSaleStock = (TextView) convertView.findViewById(R.id.tvSaleStock);
//			viewHolder.tvDescription = (TextView) convertView.findViewById(R.id.tvDescription);
            convertView.setTag(viewHolder);

        } else {
            // recycle the already inflated view 
            viewHolder = (ViewHolder) convertView.getTag();
        }
        
        // update the item view
        ListViewProduct item = getItem(position);

        viewHolder.ivIcon.setImageDrawable(item.icon);
        viewHolder.tvTitle.setText(item.title);
//        viewHolder.tvStatus.setText(item.status);
        viewHolder.tvPrice.setText("" + item.price);
//        viewHolder.tvSaleStock.setText("" + item.saleStock);
//        viewHolder.tvDescription.setText(item.status);

        return convertView;
    }
    
    /**
     * The view holder design pattern prevents using findViewById()
     * repeatedly in the getView() method of the adapter.
     * 
     * @see http://developer.android.com/training/improving-layouts/smooth-scrolling.html#ViewHolder
     */
    private static class ViewHolder {
        ImageView ivIcon;
        TextView tvTitle;
        TextView tvStatus;
        TextView tvPrice;
        TextView tvSaleStock;
        TextView tvDescription;
    }
}