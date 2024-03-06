// Generated by view binder compiler. Do not edit!
package com.rana.muncakapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.rana.muncakapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityDashboardAdminBinding implements ViewBinding {
  @NonNull
  private final NestedScrollView rootView;

  @NonNull
  public final CardView btnInputPendaki;

  @NonNull
  public final TextView btnInputPetugas;

  @NonNull
  public final Button btnLaporanPendakian;

  @NonNull
  public final Button btnLihatPendaki;

  @NonNull
  public final Button btnLihatPendakian;

  @NonNull
  public final Button btnRiwayatPendakian;

  @NonNull
  public final ImageView imageAdd;

  @NonNull
  public final ImageView imgProfil;

  @NonNull
  public final TextView tvDataPendaki;

  @NonNull
  public final TextView tvLaporan;

  @NonNull
  public final TextView tvLaporan2;

  @NonNull
  public final TextView tvPendakian;

  @NonNull
  public final TextView tvPetugas;

  @NonNull
  public final TextView tvWelcome;

  private ActivityDashboardAdminBinding(@NonNull NestedScrollView rootView,
      @NonNull CardView btnInputPendaki, @NonNull TextView btnInputPetugas,
      @NonNull Button btnLaporanPendakian, @NonNull Button btnLihatPendaki,
      @NonNull Button btnLihatPendakian, @NonNull Button btnRiwayatPendakian,
      @NonNull ImageView imageAdd, @NonNull ImageView imgProfil, @NonNull TextView tvDataPendaki,
      @NonNull TextView tvLaporan, @NonNull TextView tvLaporan2, @NonNull TextView tvPendakian,
      @NonNull TextView tvPetugas, @NonNull TextView tvWelcome) {
    this.rootView = rootView;
    this.btnInputPendaki = btnInputPendaki;
    this.btnInputPetugas = btnInputPetugas;
    this.btnLaporanPendakian = btnLaporanPendakian;
    this.btnLihatPendaki = btnLihatPendaki;
    this.btnLihatPendakian = btnLihatPendakian;
    this.btnRiwayatPendakian = btnRiwayatPendakian;
    this.imageAdd = imageAdd;
    this.imgProfil = imgProfil;
    this.tvDataPendaki = tvDataPendaki;
    this.tvLaporan = tvLaporan;
    this.tvLaporan2 = tvLaporan2;
    this.tvPendakian = tvPendakian;
    this.tvPetugas = tvPetugas;
    this.tvWelcome = tvWelcome;
  }

  @Override
  @NonNull
  public NestedScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityDashboardAdminBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityDashboardAdminBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_dashboard_admin, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityDashboardAdminBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_inputPendaki;
      CardView btnInputPendaki = ViewBindings.findChildViewById(rootView, id);
      if (btnInputPendaki == null) {
        break missingId;
      }

      id = R.id.btn_inputPetugas;
      TextView btnInputPetugas = ViewBindings.findChildViewById(rootView, id);
      if (btnInputPetugas == null) {
        break missingId;
      }

      id = R.id.btn_laporanPendakian;
      Button btnLaporanPendakian = ViewBindings.findChildViewById(rootView, id);
      if (btnLaporanPendakian == null) {
        break missingId;
      }

      id = R.id.btn_lihatPendaki;
      Button btnLihatPendaki = ViewBindings.findChildViewById(rootView, id);
      if (btnLihatPendaki == null) {
        break missingId;
      }

      id = R.id.btn_lihatPendakian;
      Button btnLihatPendakian = ViewBindings.findChildViewById(rootView, id);
      if (btnLihatPendakian == null) {
        break missingId;
      }

      id = R.id.btn_riwayatPendakian;
      Button btnRiwayatPendakian = ViewBindings.findChildViewById(rootView, id);
      if (btnRiwayatPendakian == null) {
        break missingId;
      }

      id = R.id.image_add;
      ImageView imageAdd = ViewBindings.findChildViewById(rootView, id);
      if (imageAdd == null) {
        break missingId;
      }

      id = R.id.img_profil;
      ImageView imgProfil = ViewBindings.findChildViewById(rootView, id);
      if (imgProfil == null) {
        break missingId;
      }

      id = R.id.tv_data_pendaki;
      TextView tvDataPendaki = ViewBindings.findChildViewById(rootView, id);
      if (tvDataPendaki == null) {
        break missingId;
      }

      id = R.id.tv_laporan;
      TextView tvLaporan = ViewBindings.findChildViewById(rootView, id);
      if (tvLaporan == null) {
        break missingId;
      }

      id = R.id.tv_laporan2;
      TextView tvLaporan2 = ViewBindings.findChildViewById(rootView, id);
      if (tvLaporan2 == null) {
        break missingId;
      }

      id = R.id.tv_pendakian;
      TextView tvPendakian = ViewBindings.findChildViewById(rootView, id);
      if (tvPendakian == null) {
        break missingId;
      }

      id = R.id.tv_petugas;
      TextView tvPetugas = ViewBindings.findChildViewById(rootView, id);
      if (tvPetugas == null) {
        break missingId;
      }

      id = R.id.tv_welcome;
      TextView tvWelcome = ViewBindings.findChildViewById(rootView, id);
      if (tvWelcome == null) {
        break missingId;
      }

      return new ActivityDashboardAdminBinding((NestedScrollView) rootView, btnInputPendaki,
          btnInputPetugas, btnLaporanPendakian, btnLihatPendaki, btnLihatPendakian,
          btnRiwayatPendakian, imageAdd, imgProfil, tvDataPendaki, tvLaporan, tvLaporan2,
          tvPendakian, tvPetugas, tvWelcome);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
