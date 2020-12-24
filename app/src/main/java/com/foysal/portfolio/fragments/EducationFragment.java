package com.foysal.portfolio.fragments;


import android.app.Activity;
import android.content.Intent;
import android.view.View;

import androidx.annotation.Nullable;

import com.foysal.portfolio.EditActivity;
import com.foysal.portfolio.adapters.ResumeEventAdapter;
import com.foysal.portfolio.adapters.SchoolsAdapter;
import com.foysal.portfolio.datamodel.Resume;
import com.foysal.portfolio.datamodel.School;
import com.foysal.portfolio.helper.ResumeEventFragment;
import com.foysal.portfolio.helper.ResumeFragment;

public class EducationFragment extends ResumeEventFragment<School> {



    public static ResumeFragment newInstance(Resume resume) {
        ResumeFragment fragment = new EducationFragment();
        fragment.setResume(resume);
        return fragment;
    }

    @Override
    protected void delete(int pos) {
        getResume().schools.remove(pos);
    }

    @Override
    public void onClick(int position) {
        Intent intent = EditActivity.getSchoolIntent(getActivity());
        EditActivity.setData(intent, position, getResume().schools.get(position));
        startActivityForResult(intent, REQUEST_EDIT);
    }

    @Override
    protected void addClicked() {
        Intent intent = EditActivity.getSchoolIntent(getActivity());
        startActivityForResult(intent, REQUEST_ADD);
    }

    @Override
    protected ResumeEventAdapter<School> getAdapter(View emptyView) {
        return new SchoolsAdapter(getResume().schools, this)
                .setEmptyView(emptyView);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_ADD && resultCode == Activity.RESULT_OK) {
            getResume().schools.add(new School(EditActivity.getEvent(data)));
            notifyDataChanged();
        }
        if (requestCode == REQUEST_EDIT && resultCode == Activity.RESULT_OK) {
            int id = data.getIntExtra(EditActivity.FIELD_ID, -1);
            getResume().schools.get(id).cloneThis(EditActivity.getEvent(data));
            notifyDataChanged();
        }
    }
}
