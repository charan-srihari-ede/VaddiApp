package com.example.vaddiapp.ui.calculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.vaddiapp.databinding.FragmentCalBinding; // Corrected binding

public class CalFragment extends Fragment {

    private FragmentCalBinding binding; // Corrected binding

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CalViewModel calViewModel =
                new ViewModelProvider(this).get(CalViewModel.class);

        binding = FragmentCalBinding.inflate(inflater, container, false); // Corrected binding
        View root = binding.getRoot();

        // Example: If you want to set text dynamically
        binding.titleText.setText("Vaddi(₹) App");

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
