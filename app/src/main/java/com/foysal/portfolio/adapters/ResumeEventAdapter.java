package com.foysal.portfolio.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.foysal.portfolio.R;
import com.foysal.portfolio.datamodel.ResumeEvent;

import java.util.List;



abstract public class ResumeEventAdapter<T extends ResumeEvent>
        extends RecyclerView.Adapter<ResumeEventAdapterViewHolder> {
    private List<T> list;
    private ResumeEventOnClickListener mResumeEventOnClickListener;

    public ResumeEventAdapter(@NonNull List<T> list,
                              ResumeEventOnClickListener resumeEventOnClickListener) {
        this.list = list;
        mResumeEventOnClickListener = resumeEventOnClickListener;
    }

    public interface ResumeEventOnClickListener {
        void onClick(int position);
    }

    @NonNull
    @Override
    public ResumeEventAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_resume_event, parent, false);
        ResumeEventAdapterViewHolder viewHolder =
                new ResumeEventAdapterViewHolder(itemView, mResumeEventOnClickListener);
        updateViewHolder(viewHolder);
        return viewHolder;
    }

    protected void updateViewHolder(ResumeEventAdapterViewHolder viewHolder) {

    }

    private View emptyView;
    public ResumeEventAdapter<T> setEmptyView(final View emptyView) {
        this.emptyView = emptyView;
        return this;
    }

    @Override
    public void onBindViewHolder(@NonNull ResumeEventAdapterViewHolder holder, int position) {
        ResumeEvent event = list.get(position);
        holder.itemView.setTag(position);
        holder.title.setText(event.getTitle());
        holder.detail.setText(event.getDetail());
        holder.subtitle.setText(event.getSubtitle());
        holder.description.setText(event.getDescription());
    }

    @Override
    public int getItemCount() {
        if(emptyView != null) {
            if (list.size() == 0) {
                emptyView.setVisibility(View.VISIBLE);
            } else {
                emptyView.setVisibility(View.INVISIBLE);
            }
        }
        return list.size();
    }
}
