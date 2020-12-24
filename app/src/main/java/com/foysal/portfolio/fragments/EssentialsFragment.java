package com.foysal.portfolio.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.foysal.portfolio.R;
import com.foysal.portfolio.datamodel.Resume;
import com.foysal.portfolio.helper.ResumeFragment;
import com.foysal.portfolio.helper.TextChangeListener;

public class EssentialsFragment extends ResumeFragment {


    public static ResumeFragment newInstance(Resume resume) {

        ResumeFragment fragment = new EssentialsFragment();
        fragment.setResume(resume);
        return fragment;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root =
                inflater.inflate(R.layout.fragment_essentials, container, false);

        final Resume resume = getResume();

        EditText skillsText = root.findViewById(R.id.input_skills);
        skillsText.setText(resume.skills);
        skillsText.addTextChangedListener(new TextChangeListener() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                resume.skills = s.toString();
            }
        });
        EditText languagesText = root.findViewById(R.id.input_languages);
        languagesText.setText(resume.languages);
        languagesText.addTextChangedListener(new TextChangeListener() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                resume.languages = s.toString();
            }
        });
        return root;
    }
}
