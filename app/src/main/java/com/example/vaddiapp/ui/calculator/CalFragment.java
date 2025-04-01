package com.example.vaddiapp.ui.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.vaddiapp.databinding.FragmentCalBinding;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CalFragment extends Fragment {
    private FragmentCalBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CalViewModel calViewModel = new ViewModelProvider(this).get(CalViewModel.class);
        binding = FragmentCalBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        setupUI();

        return root;
    }

    private void setupUI() {
        binding.refreshButton.setOnClickListener(v -> resetFields());
        addCurrencyFormatting(binding.amountInput);
        setupDateInput(binding.dateTakenInput);
        setupDateInput(binding.dateReturnedInput);
        binding.calculateButton.setOnClickListener(v -> calculateInterest());
    }

    private void addCurrencyFormatting(EditText editText) {
        editText.addTextChangedListener(new TextWatcher() {
            private String current = "";

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().equals(current)) {
                    editText.removeTextChangedListener(this);
                    String cleanString = s.toString().replaceAll("[₹,]", "");
                    try {
                        double parsed = cleanString.isEmpty() ? 0 : Double.parseDouble(cleanString);
                        String formatted = NumberFormat.getNumberInstance(new Locale("en", "IN")).format(parsed);
                        current = formatted;
                        editText.setText(formatted);
                        editText.setSelection(formatted.length());
                    } catch (NumberFormatException ignored) {}
                    editText.addTextChangedListener(this);
                }
            }
        });
    }

    private void setupDateInput(EditText editText) {
        editText.addTextChangedListener(new TextWatcher() {
            private String current = "";

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                String input = s.toString().replace("/", "");
                if (!input.equals(current)) {
                    editText.removeTextChangedListener(this);
                    String formattedDate = formatAsDate(input);
                    current = formattedDate;
                    editText.setText(formattedDate);
                    editText.setSelection(formattedDate.length());
                    editText.addTextChangedListener(this);
                }
            }
        });
    }

    private String formatAsDate(String input) {
        if (input.length() <= 2) return input;
        if (input.length() <= 4) return input.substring(0, 2) + "/" + input.substring(2);
        return input.substring(0, 2) + "/" + input.substring(2, 4) + "/" + input.substring(4, Math.min(8, input.length()));
    }

    private void resetFields() {
        binding.amountInput.setText("");
        binding.rateInput.setText("");
        binding.dateTakenInput.setText("");
        binding.dateReturnedInput.setText("");
        binding.amountInput.requestFocus();
        Toast.makeText(getContext(), "All fields have been reset!", Toast.LENGTH_SHORT).show();
    }

    private void calculateInterest() {
        String amountStr = binding.amountInput.getText().toString().replace(",", "").trim();
        String rateStr = binding.rateInput.getText().toString().trim();
        String dateTaken = binding.dateTakenInput.getText().toString().trim();
        String dateReturned = binding.dateReturnedInput.getText().toString().trim();

        if (amountStr.isEmpty() || rateStr.isEmpty() || dateTaken.isEmpty() || dateReturned.isEmpty()) {
            Toast.makeText(getContext(), "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double amount = Double.parseDouble(amountStr);
            double rate = Double.parseDouble(rateStr);

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
            sdf.setLenient(false); // Ensures strict date format validation

            Date startDate = sdf.parse(dateTaken);
            Date endDate = sdf.parse(dateReturned);

            if (endDate.before(startDate)) {
                Toast.makeText(getContext(), "Date Returned cannot be before Date Taken!", Toast.LENGTH_SHORT).show();
                return;
            }

            Calendar startCalendar = Calendar.getInstance();
            Calendar endCalendar = Calendar.getInstance();
            startCalendar.setTime(startDate);
            endCalendar.setTime(endDate);

            int yearsDifference = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
            int monthsDifference = endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);
            int totalMonths = yearsDifference * 12 + monthsDifference;

            int daysDifference = endCalendar.get(Calendar.DAY_OF_MONTH) - startCalendar.get(Calendar.DAY_OF_MONTH);
            if (daysDifference < 0) {
                totalMonths -= 1;
                Calendar tempCalendar = (Calendar) endCalendar.clone();
                tempCalendar.add(Calendar.MONTH, -1);
                daysDifference += tempCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
            }

            double interest = (amount * rate * (totalMonths + (double) daysDifference / 30)) / 100;
            double total = amount + interest;

            String interestFormatted = NumberFormat.getCurrencyInstance(new Locale("en", "IN")).format(interest);
            String totalFormatted = NumberFormat.getCurrencyInstance(new Locale("en", "IN")).format(total);

            showResultDialog(interestFormatted, totalFormatted, totalMonths, daysDifference);
        }catch (NumberFormatException | ParseException e) {
            Toast.makeText(getContext(), "Invalid input or date format (dd/MM/yyyy)", Toast.LENGTH_SHORT).show();
        }
    }

    private void showResultDialog(String interest, String total, int months, int days) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Calculation Result")
                .setMessage(String.format(Locale.US, "%d years, %d Months, %d days\n\nInterest: %s\n\nTotal Amount: %s",
                        months / 12, months % 12, days, interest, total))
                .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                .setCancelable(false)
                .show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
