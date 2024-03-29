// Generated by view binder compiler. Do not edit!
package com.rana.muncakapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.rana.muncakapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityLaporanPendakianBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final CardView btnBuatPDF;

  @NonNull
  public final TextView btnInputPendakian;

  @NonNull
  public final Button btnTampil;

  @NonNull
  public final ImageView imageAdd;

  @NonNull
  public final ImageView imgDoubleArrow;

  @NonNull
  public final ImageView ivBack;

  @NonNull
  public final RecyclerView rvLaporan;

  @NonNull
  public final EditText tglPesan1;

  @NonNull
  public final EditText tglPesan2;

  @NonNull
  public final TextView tvLihatPendakian;

  private ActivityLaporanPendakianBinding(@NonNull ConstraintLayout rootView,
      @NonNull CardView btnBuatPDF, @NonNull TextView btnInputPendakian, @NonNull Button btnTampil,
      @NonNull ImageView imageAdd, @NonNull ImageView imgDoubleArrow, @NonNull ImageView ivBack,
      @NonNull RecyclerView rvLaporan, @NonNull EditText tglPesan1, @NonNull EditText tglPesan2,
      @NonNull TextView tvLihatPendakian) {
    this.rootView = rootView;
    this.btnBuatPDF = btnBuatPDF;
    this.btnInputPendakian = btnInputPendakian;
    this.btnTampil = btnTampil;
    this.imageAdd = imageAdd;
    this.imgDoubleArrow = imgDoubleArrow;
    this.ivBack = ivBack;
    this.rvLaporan = rvLaporan;
    this.tglPesan1 = tglPesan1;
    this.tglPesan2 = tglPesan2;
    this.tvLihatPendakian = tvLihatPendakian;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityLaporanPendakianBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityLaporanPendakianBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_laporan_pendakian, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityLaporanPendakianBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_buatPDF;
      CardView btnBuatPDF = ViewBindings.findChildViewById(rootView, id);
      if (btnBuatPDF == null) {
        break missingId;
      }

      id = R.id.btn_inputPendakian;
      TextView btnInputPendakian = ViewBindings.findChildViewById(rootView, id);
      if (btnInputPendakian == null) {
        break missingId;
      }

      id = R.id.btn_tampil;
      Button btnTampil = ViewBindings.findChildViewById(rootView, id);
      if (btnTampil == null) {
        break missingId;
      }

      id = R.id.image_add;
      ImageView imageAdd = ViewBindings.findChildViewById(rootView, id);
      if (imageAdd == null) {
        break missingId;
      }

      id = R.id.img_doubleArrow;
      ImageView imgDoubleArrow = ViewBindings.findChildViewById(rootView, id);
      if (imgDoubleArrow == null) {
        break missingId;
      }

      id = R.id.iv_back;
      ImageView ivBack = ViewBindings.findChildViewById(rootView, id);
      if (ivBack == null) {
        break missingId;
      }

      id = R.id.rvLaporan;
      RecyclerView rvLaporan = ViewBindings.findChildViewById(rootView, id);
      if (rvLaporan == null) {
        break missingId;
      }

      id = R.id.tglPesan1;
      EditText tglPesan1 = ViewBindings.findChildViewById(rootView, id);
      if (tglPesan1 == null) {
        break missingId;
      }

      id = R.id.tglPesan2;
      EditText tglPesan2 = ViewBindings.findChildViewById(rootView, id);
      if (tglPesan2 == null) {
        break missingId;
      }

      id = R.id.tv_lihatPendakian;
      TextView tvLihatPendakian = ViewBindings.findChildViewById(rootView, id);
      if (tvLihatPendakian == null) {
        break missingId;
      }

      return new ActivityLaporanPendakianBinding((ConstraintLayout) rootView, btnBuatPDF,
          btnInputPendakian, btnTampil, imageAdd, imgDoubleArrow, ivBack, rvLaporan, tglPesan1,
          tglPesan2, tvLihatPendakian);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
