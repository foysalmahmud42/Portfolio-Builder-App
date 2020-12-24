package com.foysal.portfolio.adapters;

import androidx.annotation.NonNull;

import com.foysal.portfolio.datamodel.Experience;

import java.util.List;


public class ExperienceAdapter extends ResumeEventAdapter<Experience> {

    public ExperienceAdapter(@NonNull List<Experience> list,
                             ResumeEventOnClickListener resumeEventOnClickListener) {
        super(list, resumeEventOnClickListener);
    }
}
