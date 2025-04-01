// Generated by view binder compiler. Do not edit!
package com.example.vaddiapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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

public final class ActivityLoginBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final EditText email;

  @NonNull
  public final TextView forgotPasswordText;

  @NonNull
  public final Button loginBtn;

  @NonNull
  public final ConstraintLayout main;

  @NonNull
  public final EditText password;

  @NonNull
  public final TextView signUpText;

  private ActivityLoginBinding(@NonNull ConstraintLayout rootView, @NonNull EditText email,
      @NonNull TextView forgotPasswordText, @NonNull Button loginBtn,
      @NonNull ConstraintLayout main, @NonNull EditText password, @NonNull TextView signUpText) {
    this.rootView = rootView;
    this.email = email;
    this.forgotPasswordText = forgotPasswordText;
    this.loginBtn = loginBtn;
    this.main = main;
    this.password = password;
    this.signUpText = signUpText;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_login, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityLoginBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.email;
      EditText email = ViewBindings.findChildViewById(rootView, id);
      if (email == null) {
        break missingId;
      }

      id = R.id.forgotPasswordText;
      TextView forgotPasswordText = ViewBindings.findChildViewById(rootView, id);
      if (forgotPasswordText == null) {
        break missingId;
      }

      id = R.id.loginBtn;
      Button loginBtn = ViewBindings.findChildViewById(rootView, id);
      if (loginBtn == null) {
        break missingId;
      }

      ConstraintLayout main = (ConstraintLayout) rootView;

      id = R.id.password;
      EditText password = ViewBindings.findChildViewById(rootView, id);
      if (password == null) {
        break missingId;
      }

      id = R.id.signUpText;
      TextView signUpText = ViewBindings.findChildViewById(rootView, id);
      if (signUpText == null) {
        break missingId;
      }

      return new ActivityLoginBinding((ConstraintLayout) rootView, email, forgotPasswordText,
          loginBtn, main, password, signUpText);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
