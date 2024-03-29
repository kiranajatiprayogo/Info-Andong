// Generated by view binder compiler. Do not edit!
package com.rana.muncakapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.rana.muncakapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityDetailGunungBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final Toolbar btnKembali;

  @NonNull
  public final ImageView imgGunung;

  @NonNull
  public final TextView tvDeskripsi;

  @NonNull
  public final TextView tvJalur;

  @NonNull
  public final TextView tvKetinggian;

  @NonNull
  public final TextView tvLokasi;

  @NonNull
  public final TextView tvNamagunung;

  private ActivityDetailGunungBinding(@NonNull RelativeLayout rootView, @NonNull Toolbar btnKembali,
      @NonNull ImageView imgGunung, @NonNull TextView tvDeskripsi, @NonNull TextView tvJalur,
      @NonNull TextView tvKetinggian, @NonNull TextView tvLokasi, @NonNull TextView tvNamagunung) {
    this.rootView = rootView;
    this.btnKembali = btnKembali;
    this.imgGunung = imgGunung;
    this.tvDeskripsi = tvDeskripsi;
    this.tvJalur = tvJalur;
    this.tvKetinggian = tvKetinggian;
    this.tvLokasi = tvLokasi;
    this.tvNamagunung = tvNamagunung;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityDetailGunungBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityDetailGunungBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_detail_gunung, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityDetailGunungBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_kembali;
      Toolbar btnKembali = ViewBindings.findChildViewById(rootView, id);
      if (btnKembali == null) {
        break missingId;
      }

      id = R.id.img_gunung;
      ImageView imgGunung = ViewBindings.findChildViewById(rootView, id);
      if (imgGunung == null) {
        break missingId;
      }

      id = R.id.tv_deskripsi;
      TextView tvDeskripsi = ViewBindings.findChildViewById(rootView, id);
      if (tvDeskripsi == null) {
        break missingId;
      }

      id = R.id.tv_jalur;
      TextView tvJalur = ViewBindings.findChildViewById(rootView, id);
      if (tvJalur == null) {
        break missingId;
      }

      id = R.id.tv_ketinggian;
      TextView tvKetinggian = ViewBindings.findChildViewById(rootView, id);
      if (tvKetinggian == null) {
        break missingId;
      }

      id = R.id.tv_lokasi;
      TextView tvLokasi = ViewBindings.findChildViewById(rootView, id);
      if (tvLokasi == null) {
        break missingId;
      }

      id = R.id.tv_namagunung;
      TextView tvNamagunung = ViewBindings.findChildViewById(rootView, id);
      if (tvNamagunung == null) {
        break missingId;
      }

      return new ActivityDetailGunungBinding((RelativeLayout) rootView, btnKembali, imgGunung,
          tvDeskripsi, tvJalur, tvKetinggian, tvLokasi, tvNamagunung);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
