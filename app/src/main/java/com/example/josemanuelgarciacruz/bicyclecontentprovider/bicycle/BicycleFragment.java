package com.example.josemanuelgarciacruz.bicyclecontentprovider.bicycle;

import android.app.LoaderManager;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.josemanuelgarciacruz.bicyclecontentprovider.R;
import com.example.josemanuelgarciacruz.bicyclecontentprovider.bicycle.BicycleContract;

public class BicycleFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {

    public MyBicycleRecyclerViewAdapter mAdapter;


    public BicycleFragment() {
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bicycle_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            mAdapter = new MyBicycleRecyclerViewAdapter();
            recyclerView.setAdapter(new MyBicycleRecyclerViewAdapter());
        }
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        getLoaderManager().initLoader(0, null, true);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String proyection[] = {
                BicycleContract.MODEL,
                BicycleContract.YEAR
        };

        Uri uri = Uri.parse(BicycleContract.CONTENT_URI);

        return new CursorLoader(getActivity(), uri, proyection, null, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {

        mAdapter.setCursor(cursor);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

        mAdapter.setCursor(null);
        mAdapter.notifyDataSetChanged();
    }
}
