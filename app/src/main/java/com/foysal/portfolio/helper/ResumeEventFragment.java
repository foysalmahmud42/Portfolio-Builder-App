package com.foysal.portfolio.helper;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.foysal.portfolio.R;
import com.foysal.portfolio.adapters.ResumeEventAdapter;
import com.foysal.portfolio.datamodel.ResumeEvent;


abstract public class ResumeEventFragment<T extends ResumeEvent> extends ResumeFragment
        implements ResumeEventAdapter.ResumeEventOnClickListener {

    Activity activity;
    public static final int REQUEST_ADD = 1;
    public static final int REQUEST_EDIT = 2;

    RecyclerView recyclerView;

    protected abstract void addClicked();

    protected abstract ResumeEventAdapter<T> getAdapter(View emptyView);

    protected abstract void delete(int pos);

    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }



    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_view, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        View emptyView = view.findViewById(android.R.id.empty);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        recyclerView.setAdapter(getAdapter(emptyView));
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }


            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                delete((int) viewHolder.itemView.getTag());
                notifyDataChanged();
            }
        }).attachToRecyclerView(recyclerView);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.add, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    public void notifyDataChanged() {
        recyclerView.getAdapter().notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_add) {
            addClicked();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
