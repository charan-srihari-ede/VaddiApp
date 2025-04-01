package com.example.vaddiapp.ui.logout;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.vaddiapp.LoginActivity;
import com.example.vaddiapp.MainActivity;
import com.example.vaddiapp.Utils;
import com.example.vaddiapp.databinding.FragmentLogoutBinding;
import com.google.firebase.auth.FirebaseAuth;

public class LogoutFragment extends Fragment {
    private FragmentLogoutBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Using ViewBinding
        binding = FragmentLogoutBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        setupUI();

        return root;
    }

    private void setupUI() {
        // Set up logout confirmation button
        binding.logoutButton.setOnClickListener(v -> {
            Utils.showLoading(getContext(), "Logging out...");
            FirebaseAuth.getInstance().signOut(); // Sign out the user

            // Redirect to LoginActivity and clear back stack
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); // Clear stack
            Utils.hideLoading();
            startActivity(intent);
            getActivity().finish(); // Close MainActivity after logout
        });
        binding.noButton.setOnClickListener(v -> {
            if (getActivity() != null) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null; // Prevent memory leaks
    }
}
