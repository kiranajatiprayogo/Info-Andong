// Generated by view binder compiler. Do not edit!
package com.rana.muncakapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.rana.muncakapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityLupaPasswordBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btnUbah;

  @NonNull
  public final EditText edHint;

  @NonNull
  public final EditText edPassword;

  @NonNull
  public final EditText edUsername;

  @NonNull
  public final Spinner spHint;

  @NonNull
  public final TextView tvReset;

  private ActivityLupaPasswordBinding(@NonNull ConstraintLayout rootView, @NonNull Button btnUbah,
      @NonNull EditText edHint, @NonNull EditText edPassword, @NonNull EditText edUsername,
      @NonNull Spinner spHint, @NonNull TextView tvReset) {
    this.rootView = rootView;
    this.btnUbah = btnUbah;
    this.edHint = edHint;
    this.edPassword = edPassword;
    this.edUsername = edUsername;
    this.spHint = spHint;
    this.tvReset = tvReset;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityLupaPasswordBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityLupaPasswordBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_lupa_password, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityLupaPasswordBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_ubah;
      Button btnUbah = ViewBindings.findChildViewById(rootView, id);
      if (btnUbah == null) {
        break missingId;
      }

      id = R.id.ed_hint;
      EditText edHint = ViewBindings.findChildViewById(rootView, id);
      if (edHint == null) {
        break missingId;
      }

      id = R.id.ed_password;
      EditText edPassword = ViewBindings.findChildViewById(rootView, id);
      if (edPassword == null) {
        break missingId;
      }

      id = R.id.ed_username;
      EditText edUsername = ViewBindings.findChildViewById(rootView, id);
      if (edUsername == null) {
        break missingId;
      }

      id = R.id.sp_hint;
      Spinner spHint = ViewBindings.findChildViewById(rootView, id);
      if (spHint == null) {
        break missingId;
      }

      id = R.id.tv_reset;
      TextView tvReset = ViewBindings.findChildViewById(rootView, id);
      if (tvReset == null) {
        break missingId;
      }

      return new ActivityLupaPasswordBinding((ConstraintLayout) rootView, btnUbah, edHint,
          edPassword, edUsername, spHint, tvReset);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
