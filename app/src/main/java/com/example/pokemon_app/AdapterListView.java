package com.example.pokemon_app;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pokemon_app.ItemListView;

import java.util.List;

public class AdapterListView extends BaseAdapter {
    private LayoutInflater mInflater;
    private List<ItemListView> itens;
    public AdapterListView(Context context, List<ItemListView> itens) {
        mInflater=LayoutInflater.from(context);
        this.itens = itens;    }
    public int getCount() {
        return itens.size();
    }
    public ItemListView getItem(int position) {
        return itens.get(position);
    }
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        ItemListView itemListView = getItem(position);

        viewHolder.imageView.setImageResource(itemListView.getImage());
        viewHolder.textView.setText(itemListView.getName());

        return convertView;
    }}

