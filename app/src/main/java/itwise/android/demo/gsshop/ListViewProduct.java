package itwise.android.demo.gsshop;

import android.graphics.drawable.Drawable;

public class ListViewProduct {
	public final Drawable icon;       	// 상품 이미지
    public final String title;        	// the text for the ListView item title
    public final int price;  			// 가격
    public final String status;  			// 판매 상태
    public final int saleStock;  		// 판매 수량

    public ListViewProduct(Drawable icon, String title, String description, int price, String status, int saleStock) {
        this.icon = icon;
        this.title = title;
		this.price = price;
		this.status = status;
		this.saleStock = saleStock;
	}
}