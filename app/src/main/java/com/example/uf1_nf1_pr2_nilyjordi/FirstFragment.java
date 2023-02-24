package com.example.uf1_nf1_pr2_nilyjordi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class FirstFragment extends Fragment {

    private Button openSecondFragmentButton;
    private SharedViewModel sharedViewModel;

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        openSecondFragmentButton = view.findViewById(R.id.open_second_fragment_button);
        openSecondFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new SecondFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });

        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        return view;
    }
}
