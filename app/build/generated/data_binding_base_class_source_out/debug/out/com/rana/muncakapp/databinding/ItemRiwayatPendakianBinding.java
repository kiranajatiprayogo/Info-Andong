// Generated by view binder compiler. Do not edit!
package com.rana.muncakapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.rana.muncakapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemRiwayatPendakianBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final LinearLayout btnEdit;

  @NonNull
  public final LinearLayout btnHapus;

  @NonNull
  public final CardView cvRiwayatPendakian;

  @NonNull
  public final ImageView imgDoubleArrow;

  @NonNull
  public final TextView tvNaik;

  @NonNull
  public final TextView tvNaikPos1;

  @NonNull
  public final TextView tvNaikPos2;

  @NonNull
  public final TextView tvNaikPos3;

  @NonNull
  public final TextView tvNamaPendaki;

  @NonNull
  public final TextView tvNamaRegu;

  @NonNull
  public final TextView tvStatusPendakian;

  @NonNull
  public final TextView tvTurun;

  @NonNull
  public final TextView tvTurunPos1;

  @NonNull
  public final TextView tvTurunPos2;

  @NonNull
  public final TextView tvTurunPos3;

  @NonNull
  public final TextView tvWaktuMulai;

  @NonNull
  public final TextView tvWaktuSelesai;

  private ItemRiwayatPendakianBinding(@NonNull CardView rootView, @NonNull LinearLayout btnEdit,
      @NonNull LinearLayout btnHapus, @NonNull CardView cvRiwayatPendakian,
      @NonNull ImageView imgDoubleArrow, @NonNull TextView tvNaik, @NonNull TextView tvNaikPos1,
      @NonNull TextView tvNaikPos2, @NonNull TextView tvNaikPos3, @NonNull TextView tvNamaPendaki,
      @NonNull TextView tvNamaRegu, @NonNull TextView tvStatusPendakian, @NonNull TextView tvTurun,
      @NonNull TextView tvTurunPos1, @NonNull TextView tvTurunPos2, @NonNull TextView tvTurunPos3,
      @NonNull TextView tvWaktuMulai, @NonNull TextView tvWaktuSelesai) {
    this.rootView = rootView;
    this.btnEdit = btnEdit;
    this.btnHapus = btnHapus;
    this.cvRiwayatPendakian = cvRiwayatPendakian;
    this.imgDoubleArrow = imgDoubleArrow;
    this.tvNaik = tvNaik;
    this.tvNaikPos1 = tvNaikPos1;
    this.tvNaikPos2 = tvNaikPos2;
    this.tvNaikPos3 = tvNaikPos3;
    this.tvNamaPendaki = tvNamaPendaki;
    this.tvNamaRegu = tvNamaRegu;
    this.tvStatusPendakian = tvStatusPendakian;
    this.tvTurun = tvTurun;
    this.tvTurunPos1 = tvTurunPos1;
    this.tvTurunPos2 = tvTurunPos2;
    this.tvTurunPos3 = tvTurunPos3;
    this.tvWaktuMulai = tvWaktuMulai;
    this.tvWaktuSelesai = tvWaktuSelesai;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemRiwayatPendakianBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemRiwayatPendakianBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_riwayat_pendakian, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemRiwayatPendakianBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_edit;
      LinearLayout btnEdit = ViewBindings.findChildViewById(rootView, id);
      if (btnEdit == null) {
        break missingId;
      }

      id = R.id.btn_hapus;
      LinearLayout btnHapus = ViewBindings.findChildViewById(rootView, id);
      if (btnHapus == null) {
        break missingId;
      }

      CardView cvRiwayatPendakian = (CardView) rootView;

      id = R.id.img_doubleArrow;
      ImageView imgDoubleArrow = ViewBindings.findChildViewById(rootView, id);
      if (imgDoubleArrow == null) {
        break missingId;
      }

      id = R.id.tv_naik;
      TextView tvNaik = ViewBindings.findChildViewById(rootView, id);
      if (tvNaik == null) {
        break missingId;
      }

      id = R.id.tv_naikPos1;
      TextView tvNaikPos1 = ViewBindings.findChildViewById(rootView, id);
      if (tvNaikPos1 == null) {
        break missingId;
      }

      id = R.id.tv_naikPos2;
      TextView tvNaikPos2 = ViewBindings.findChildViewById(rootView, id);
      if (tvNaikPos2 == null) {
        break missingId;
      }

      id = R.id.tv_naikPos3;
      TextView tvNaikPos3 = ViewBindings.findChildViewById(rootView, id);
      if (tvNaikPos3 == null) {
        break missingId;
      }

      id = R.id.tv_namaPendaki;
      TextView tvNamaPendaki = ViewBindings.findChildViewById(rootView, id);
      if (tvNamaPendaki == null) {
        break missingId;
      }

      id = R.id.tv_namaRegu;
      TextView tvNamaRegu = ViewBindings.findChildViewById(rootView, id);
      if (tvNamaRegu == null) {
        break missingId;
      }

      id = R.id.tv_statusPendakian;
      TextView tvStatusPendakian = ViewBindings.findChildViewById(rootView, id);
      if (tvStatusPendakian == null) {
        break missingId;
      }

      id = R.id.tv_turun;
      TextView tvTurun = ViewBindings.findChildViewById(rootView, id);
      if (tvTurun == null) {
        break missingId;
      }

      id = R.id.tv_turunPos1;
      TextView tvTurunPos1 = ViewBindings.findChildViewById(rootView, id);
      if (tvTurunPos1 == null) {
        break missingId;
      }

      id = R.id.tv_turunPos2;
      TextView tvTurunPos2 = ViewBindings.findChildViewById(rootView, id);
      if (tvTurunPos2 == null) {
        break missingId;
      }

      id = R.id.tv_turunPos3;
      TextView tvTurunPos3 = ViewBindings.findChildViewById(rootView, id);
      if (tvTurunPos3 == null) {
        break missingId;
      }

      id = R.id.tv_waktuMulai;
      TextView tvWaktuMulai = ViewBindings.findChildViewById(rootView, id);
      if (tvWaktuMulai == null) {
        break missingId;
      }

      id = R.id.tv_waktuSelesai;
      TextView tvWaktuSelesai = ViewBindings.findChildViewById(rootView, id);
      if (tvWaktuSelesai == null) {
        break missingId;
      }

      return new ItemRiwayatPendakianBinding((CardView) rootView, btnEdit, btnHapus,
          cvRiwayatPendakian, imgDoubleArrow, tvNaik, tvNaikPos1, tvNaikPos2, tvNaikPos3,
          tvNamaPendaki, tvNamaRegu, tvStatusPendakian, tvTurun, tvTurunPos1, tvTurunPos2,
          tvTurunPos3, tvWaktuMulai, tvWaktuSelesai);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
