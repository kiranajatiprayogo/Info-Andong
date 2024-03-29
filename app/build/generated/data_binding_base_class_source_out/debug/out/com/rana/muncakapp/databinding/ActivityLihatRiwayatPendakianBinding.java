// Generated by view binder compiler. Do not edit!
package com.rana.muncakapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.rana.muncakapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityLihatRiwayatPendakianBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView btnInputPendakian;

  @NonNull
  public final CardView btnRiwayatPendakian;

  @NonNull
  public final ImageView imageAdd;

  @NonNull
  public final ImageView ivBack;

  @NonNull
  public final RecyclerView rvRiwayatPendakian;

  @NonNull
  public final SearchView searchRiwayatPendakian;

  @NonNull
  public final TextView tvLihatRiwayatPendakian;

  private ActivityLihatRiwayatPendakianBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextView btnInputPendakian, @NonNull CardView btnRiwayatPendakian,
      @NonNull ImageView imageAdd, @NonNull ImageView ivBack,
      @NonNull RecyclerView rvRiwayatPendakian, @NonNull SearchView searchRiwayatPendakian,
      @NonNull TextView tvLihatRiwayatPendakian) {
    this.rootView = rootView;
    this.btnInputPendakian = btnInputPendakian;
    this.btnRiwayatPendakian = btnRiwayatPendakian;
    this.imageAdd = imageAdd;
    this.ivBack = ivBack;
    this.rvRiwayatPendakian = rvRiwayatPendakian;
    this.searchRiwayatPendakian = searchRiwayatPendakian;
    this.tvLihatRiwayatPendakian = tvLihatRiwayatPendakian;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityLihatRiwayatPendakianBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityLihatRiwayatPendakianBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_lihat_riwayat_pendakian, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityLihatRiwayatPendakianBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_inputPendakian;
      TextView btnInputPendakian = ViewBindings.findChildViewById(rootView, id);
      if (btnInputPendakian == null) {
        break missingId;
      }

      id = R.id.btn_RiwayatPendakian;
      CardView btnRiwayatPendakian = ViewBindings.findChildViewById(rootView, id);
      if (btnRiwayatPendakian == null) {
        break missingId;
      }

      id = R.id.image_add;
      ImageView imageAdd = ViewBindings.findChildViewById(rootView, id);
      if (imageAdd == null) {
        break missingId;
      }

      id = R.id.iv_back;
      ImageView ivBack = ViewBindings.findChildViewById(rootView, id);
      if (ivBack == null) {
        break missingId;
      }

      id = R.id.rvRiwayatPendakian;
      RecyclerView rvRiwayatPendakian = ViewBindings.findChildViewById(rootView, id);
      if (rvRiwayatPendakian == null) {
        break missingId;
      }

      id = R.id.searchRiwayatPendakian;
      SearchView searchRiwayatPendakian = ViewBindings.findChildViewById(rootView, id);
      if (searchRiwayatPendakian == null) {
        break missingId;
      }

      id = R.id.tv_lihatRiwayatPendakian;
      TextView tvLihatRiwayatPendakian = ViewBindings.findChildViewById(rootView, id);
      if (tvLihatRiwayatPendakian == null) {
        break missingId;
      }

      return new ActivityLihatRiwayatPendakianBinding((ConstraintLayout) rootView,
          btnInputPendakian, btnRiwayatPendakian, imageAdd, ivBack, rvRiwayatPendakian,
          searchRiwayatPendakian, tvLihatRiwayatPendakian);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
