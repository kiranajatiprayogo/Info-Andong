// Generated by view binder compiler. Do not edit!
package com.rana.muncakapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

public final class ActivityTampilanAwalBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btnMulai;

  @NonNull
  public final TextView tvApk;

  @NonNull
  public final TextView tvDeskripsiApk;

  private ActivityTampilanAwalBinding(@NonNull ConstraintLayout rootView, @NonNull Button btnMulai,
      @NonNull TextView tvApk, @NonNull TextView tvDeskripsiApk) {
    this.rootView = rootView;
    this.btnMulai = btnMulai;
    this.tvApk = tvApk;
    this.tvDeskripsiApk = tvDeskripsiApk;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityTampilanAwalBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityTampilanAwalBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_tampilan_awal, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityTampilanAwalBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_mulai;
      Button btnMulai = ViewBindings.findChildViewById(rootView, id);
      if (btnMulai == null) {
        break missingId;
      }

      id = R.id.tv_Apk;
      TextView tvApk = ViewBindings.findChildViewById(rootView, id);
      if (tvApk == null) {
        break missingId;
      }

      id = R.id.tv_deskripsiApk;
      TextView tvDeskripsiApk = ViewBindings.findChildViewById(rootView, id);
      if (tvDeskripsiApk == null) {
        break missingId;
      }

      return new ActivityTampilanAwalBinding((ConstraintLayout) rootView, btnMulai, tvApk,
          tvDeskripsiApk);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}