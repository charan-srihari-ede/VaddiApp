// Generated by view binder compiler. Do not edit!
package com.example.vaddiapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.vaddiapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentCalBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final EditText amountInput;

  @NonNull
  public final Button calculateButton;

  @NonNull
  public final TextView copyrightText;

  @NonNull
  public final EditText dateReturnedInput;

  @NonNull
  public final EditText dateTakenInput;

  @NonNull
  public final ImageView openLinkButton;

  @NonNull
  public final EditText rateInput;

  @NonNull
  public final ImageView refreshButton;

  @NonNull
  public final TextView titleText;

  private FragmentCalBinding(@NonNull ConstraintLayout rootView, @NonNull EditText amountInput,
      @NonNull Button calculateButton, @NonNull TextView copyrightText,
      @NonNull EditText dateReturnedInput, @NonNull EditText dateTakenInput,
      @NonNull ImageView openLinkButton, @NonNull EditText rateInput,
      @NonNull ImageView refreshButton, @NonNull TextView titleText) {
    this.rootView = rootView;
    this.amountInput = amountInput;
    this.calculateButton = calculateButton;
    this.copyrightText = copyrightText;
    this.dateReturnedInput = dateReturnedInput;
    this.dateTakenInput = dateTakenInput;
    this.openLinkButton = openLinkButton;
    this.rateInput = rateInput;
    this.refreshButton = refreshButton;
    this.titleText = titleText;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentCalBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentCalBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_cal, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentCalBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.amountInput;
      EditText amountInput = ViewBindings.findChildViewById(rootView, id);
      if (amountInput == null) {
        break missingId;
      }

      id = R.id.calculateButton;
      Button calculateButton = ViewBindings.findChildViewById(rootView, id);
      if (calculateButton == null) {
        break missingId;
      }

      id = R.id.copyrightText;
      TextView copyrightText = ViewBindings.findChildViewById(rootView, id);
      if (copyrightText == null) {
        break missingId;
      }

      id = R.id.dateReturnedInput;
      EditText dateReturnedInput = ViewBindings.findChildViewById(rootView, id);
      if (dateReturnedInput == null) {
        break missingId;
      }

      id = R.id.dateTakenInput;
      EditText dateTakenInput = ViewBindings.findChildViewById(rootView, id);
      if (dateTakenInput == null) {
        break missingId;
      }

      id = R.id.openLinkButton;
      ImageView openLinkButton = ViewBindings.findChildViewById(rootView, id);
      if (openLinkButton == null) {
        break missingId;
      }

      id = R.id.rateInput;
      EditText rateInput = ViewBindings.findChildViewById(rootView, id);
      if (rateInput == null) {
        break missingId;
      }

      id = R.id.refreshButton;
      ImageView refreshButton = ViewBindings.findChildViewById(rootView, id);
      if (refreshButton == null) {
        break missingId;
      }

      id = R.id.titleText;
      TextView titleText = ViewBindings.findChildViewById(rootView, id);
      if (titleText == null) {
        break missingId;
      }

      return new FragmentCalBinding((ConstraintLayout) rootView, amountInput, calculateButton,
          copyrightText, dateReturnedInput, dateTakenInput, openLinkButton, rateInput,
          refreshButton, titleText);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
