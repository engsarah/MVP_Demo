package com.etisalat.foodmenuloader.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.etisalat.foodmenuloader.R;
import com.etisalat.foodmenuloader.data.model.Item;

import java.util.List;


/**
 * Recycler Adapter for Pizza Menu Items
 */
public class MenuItemsAdapter extends RecyclerView.Adapter<MenuItemsAdapter.ViewHolder> {

    Context context;
    List<Item> itemsList;

    public MenuItemsAdapter(Context context, List<Item> itemsList) {

        this.itemsList = itemsList;
        this.context = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView itemNameTv, itemDescTv, itemPriceTv;

        public ViewHolder(View v) {

            super(v);
            itemNameTv = (TextView) v.findViewById(R.id.item_name);
            itemDescTv = (TextView) v.findViewById(R.id.item_description);
            itemPriceTv = (TextView) v.findViewById(R.id.item_price);
        }


    }

    /**
     *
     * @param parent ViewGroup
     * @param viewType type
     * @return ViewHolder
     *
     * binding xml layout for Items in the recycler view
     */
    @Override
    public MenuItemsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view1 = LayoutInflater.from(context).inflate(R.layout.menu_item, parent, false);

        ViewHolder viewHolder1 = new ViewHolder(view1);

        return viewHolder1;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        final Item itemData = itemsList.get(position);

        viewHolder.itemNameTv.setText(itemData.getName());
        viewHolder.itemDescTv.setText(itemData.getDescription());
        viewHolder.itemPriceTv.setText(itemData.getCost() + " L.E.");

    }

    @Override
    public int getItemCount() {

        return itemsList.size();
    }


}