package com.basith.cbseapp.Activities.Dashboard.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.basith.cbseapp.Activities.ChaptersActivity.ChaptersActivity;
import com.basith.cbseapp.Models.AppModel;
import com.basith.cbseapp.R;

public class TenthFragment extends Fragment {

    CardView science,socialscience,english,maths,hindi;

    public TenthFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tenth, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        science = getView().findViewById(R.id.science);
        science.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!AppModel.sharedInstance.isNetworkAvailable(getContext())) {
                    Toast.makeText(getContext(), "Please turn on internet.", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(getContext(), ChaptersActivity.class);
                    intent.putExtra("subjectId", "56");
                    startActivity(intent);
                }
            }
        });

        socialscience = getView().findViewById(R.id.socialscience);
        socialscience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!AppModel.sharedInstance.isNetworkAvailable(getContext())) {
                    Toast.makeText(getContext(), "Please turn on internet.", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(getContext(), ChaptersActivity.class);
                    intent.putExtra("subjectId", "57");
                    startActivity(intent);
                }
            }
        });

        hindi = getView().findViewById(R.id.hindi);
        hindi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!AppModel.sharedInstance.isNetworkAvailable(getContext())) {
                    Toast.makeText(getContext(), "Please turn on internet.", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(getContext(), ChaptersActivity.class);
                    intent.putExtra("subjectId", "58");
                    startActivity(intent);
                }
            }
        });

        english = getView().findViewById(R.id.english);
        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!AppModel.sharedInstance.isNetworkAvailable(getContext())) {
                    Toast.makeText(getContext(), "Please turn on internet.", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(getContext(), ChaptersActivity.class);
                    intent.putExtra("subjectId", "59");
                    startActivity(intent);
                }
            }
        });

        maths = getView().findViewById(R.id.maths);
        maths.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!AppModel.sharedInstance.isNetworkAvailable(getContext())) {
                    Toast.makeText(getContext(), "Please turn on internet.", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(getContext(), ChaptersActivity.class);
                    intent.putExtra("subjectId", "55");
                    startActivity(intent);
                }
            }
        });

    }
}