// Generated by view binder compiler. Do not edit!
package com.rana.muncakapp.databinding;

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
import com.rana.muncakapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityLoginBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btnLogin;

  @NonNull
  public final TextView btnLupaPass;

  @NonNull
  public final TextView btnRegister;

  @NonNull
  public final EditText edPasswordLogin;

  @NonNull
  public final EditText edUsernameLogin;

  @NonNull
  public final TextView judulLogin;

  private ActivityLoginBinding(@NonNull ConstraintLayout rootView, @NonNull Button btnLogin,
      @NonNull TextView btnLupaPass, @NonNull TextView btnRegister,
      @NonNull EditText edPasswordLogin, @NonNull EditText edUsernameLogin,
      @NonNull TextView judulLogin) {
    this.rootView = rootView;
    this.btnLogin = btnLogin;
    this.btnLupaPass = btnLupaPass;
    this.btnRegister = btnRegister;
    this.edPasswordLogin = edPasswordLogin;
    this.edUsernameLogin = edUsernameLogin;
    this.judulLogin = judulLogin;
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
      id = R.id.btn_login;
      Button btnLogin = ViewBindings.findChildViewById(rootView, id);
      if (btnLogin == null) {
        break missingId;
      }

      id = R.id.btn_lupaPass;
      TextView btnLupaPass = ViewBindings.findChildViewById(rootView, id);
      if (btnLupaPass == null) {
        break missingId;
      }

      id = R.id.btn_register;
      TextView btnRegister = ViewBindings.findChildViewById(rootView, id);
      if (btnRegister == null) {
        break missingId;
      }

      id = R.id.ed_passwordLogin;
      EditText edPasswordLogin = ViewBindings.findChildViewById(rootView, id);
      if (edPasswordLogin == null) {
        break missingId;
      }

      id = R.id.ed_usernameLogin;
      EditText edUsernameLogin = ViewBindings.findChildViewById(rootView, id);
      if (edUsernameLogin == null) {
        break missingId;
      }

      id = R.id.judulLogin;
      TextView judulLogin = ViewBindings.findChildViewById(rootView, id);
      if (judulLogin == null) {
        break missingId;
      }

      return new ActivityLoginBinding((ConstraintLayout) rootView, btnLogin, btnLupaPass,
          btnRegister, edPasswordLogin, edUsernameLogin, judulLogin);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}