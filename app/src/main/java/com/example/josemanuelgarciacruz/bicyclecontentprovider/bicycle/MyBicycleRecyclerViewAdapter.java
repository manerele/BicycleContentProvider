package com.example.josemanuelgarciacruz.bicyclecontentprovider.bicycle;

import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.josemanuelgarciacruz.bicyclecontentprovider.R;
import com.example.josemanuelgarciacruz.bicyclecontentprovider.bicycle.dummy.DummyContent.DummyItem;

import java.util.List;


public class MyBicycleRecyclerViewAdapter extends RecyclerView.Adapter<MyBicycleRecyclerViewAdapter.ViewHolder> {

    Cursor cursor;

    public void setCursor(Cursor cursor) {
        this.cursor = cursor;
    }

    public MyBicycleRecyclerViewAdapter() {
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_bicycle, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        cursor.moveToPosition(position);
        holder.mModel.setText(cursor.getString(cursor.getColumnIndex(BicycleContract.MODEL)));
        holder.mYear.setText(cursor.getString(cursor.getColumnIndex(BicycleContract.YEAR)));


    }

    @Override
    public int getItemCount()  {
        if(cursor == null)
            return 0;
        return cursor.getCount();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mModel;
        public final TextView mYear;
        public DummyItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mModel = view.findViewById(R.id.textViewModel);
            mYear = view.findViewById(R.id.textViewYear);
        }

    }
}
