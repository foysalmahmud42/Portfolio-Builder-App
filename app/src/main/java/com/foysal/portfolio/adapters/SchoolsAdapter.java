package com.foysal.portfolio.adapters;

import androidx.annotation.NonNull;

import com.foysal.portfolio.datamodel.School;

import java.util.List;



public class SchoolsAdapter extends ResumeEventAdapter<School> {

    public SchoolsAdapter(@NonNull List<School> list,
                          ResumeEventOnClickListener resumeEventOnClickListener) {
        super(list, resumeEventOnClickListener);
    }
}