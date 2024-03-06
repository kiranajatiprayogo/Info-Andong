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
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.rana.muncakapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityKelolaRiwayatPendakiBinding implements ViewBinding {
  @NonNull
  private final NestedScrollView rootView;

  @NonNull
  public final Button btnEditPendaki;

  @NonNull
  public final Button btnHapusPendaki;

  @NonNull
  public final Button btnSimpanPendaki;

  @NonNull
  public final EditText edAlamat;

  @NonNull
  public final TextView edIdPendaki;

  @NonNull
  public final EditText edNamaPendaki;

  @NonNull
  public final EditText edNamaregu;

  @NonNull
  public final EditText edNoHPKeluarga;

  @NonNull
  public final EditText edNoHPPribadi;

  @NonNull
  public final EditText edUmurPendaki;

  @NonNull
  public final ImageView ivBack;

  @NonNull
  public final TextView tvAlamat;

  @NonNull
  public final TextView tvHpKeluarga;

  @NonNull
  public final TextView tvHpPribadi;

  @NonNull
  public final TextView tvId;

  @NonNull
  public final TextView tvInputPendaki;

  @NonNull
  public final TextView tvNama;

  @NonNull
  public final TextView tvNamaregu;

  @NonNull
  public final TextView tvRegu;

  @NonNull
  public final TextView tvUmur;

  @NonNull
  public final TextView tvYakin;

  private ActivityKelolaRiwayatPendakiBinding(@NonNull NestedScrollView rootView,
      @NonNull Button btnEditPendaki, @NonNull Button btnHapusPendaki,
      @NonNull Button btnSimpanPendaki, @NonNull EditText edAlamat, @NonNull TextView edIdPendaki,
      @NonNull EditText edNamaPendaki, @NonNull EditText edNamaregu,
      @NonNull EditText edNoHPKeluarga, @NonNull EditText edNoHPPribadi,
      @NonNull EditText edUmurPendaki, @NonNull ImageView ivBack, @NonNull TextView tvAlamat,
      @NonNull TextView tvHpKeluarga, @NonNull TextView tvHpPribadi, @NonNull TextView tvId,
      @NonNull TextView tvInputPendaki, @NonNull TextView tvNama, @NonNull TextView tvNamaregu,
      @NonNull TextView tvRegu, @NonNull TextView tvUmur, @NonNull TextView tvYakin) {
    this.rootView = rootView;
    this.btnEditPendaki = btnEditPendaki;
    this.btnHapusPendaki = btnHapusPendaki;
    this.btnSimpanPendaki = btnSimpanPendaki;
    this.edAlamat = edAlamat;
    this.edIdPendaki = edIdPendaki;
    this.edNamaPendaki = edNamaPendaki;
    this.edNamaregu = edNamaregu;
    this.edNoHPKeluarga = edNoHPKeluarga;
    this.edNoHPPribadi = edNoHPPribadi;
    this.edUmurPendaki = edUmurPendaki;
    this.ivBack = ivBack;
    this.tvAlamat = tvAlamat;
    this.tvHpKeluarga = tvHpKeluarga;
    this.tvHpPribadi = tvHpPribadi;
    this.tvId = tvId;
    this.tvInputPendaki = tvInputPendaki;
    this.tvNama = tvNama;
    this.tvNamaregu = tvNamaregu;
    this.tvRegu = tvRegu;
    this.tvUmur = tvUmur;
    this.tvYakin = tvYakin;
  }

  @Override
  @NonNull
  public NestedScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityKelolaRiwayatPendakiBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityKelolaRiwayatPendakiBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_kelola_riwayat_pendaki, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityKelolaRiwayatPendakiBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_editPendaki;
      Button btnEditPendaki = ViewBindings.findChildViewById(rootView, id);
      if (btnEditPendaki == null) {
        break missingId;
      }

      id = R.id.btn_hapusPendaki;
      Button btnHapusPendaki = ViewBindings.findChildViewById(rootView, id);
      if (btnHapusPendaki == null) {
        break missingId;
      }

      id = R.id.btn_simpanPendaki;
      Button btnSimpanPendaki = ViewBindings.findChildViewById(rootView, id);
      if (btnSimpanPendaki == null) {
        break missingId;
      }

      id = R.id.ed_alamat;
      EditText edAlamat = ViewBindings.findChildViewById(rootView, id);
      if (edAlamat == null) {
        break missingId;
      }

      id = R.id.ed_idPendaki;
      TextView edIdPendaki = ViewBindings.findChildViewById(rootView, id);
      if (edIdPendaki == null) {
        break missingId;
      }

      id = R.id.ed_namaPendaki;
      EditText edNamaPendaki = ViewBindings.findChildViewById(rootView, id);
      if (edNamaPendaki == null) {
        break missingId;
      }

      id = R.id.ed_namaregu;
      EditText edNamaregu = ViewBindings.findChildViewById(rootView, id);
      if (edNamaregu == null) {
        break missingId;
      }

      id = R.id.ed_noHPKeluarga;
      EditText edNoHPKeluarga = ViewBindings.findChildViewById(rootView, id);
      if (edNoHPKeluarga == null) {
        break missingId;
      }

      id = R.id.ed_noHPPribadi;
      EditText edNoHPPribadi = ViewBindings.findChildViewById(rootView, id);
      if (edNoHPPribadi == null) {
        break missingId;
      }

      id = R.id.ed_umurPendaki;
      EditText edUmurPendaki = ViewBindings.findChildViewById(rootView, id);
      if (edUmurPendaki == null) {
        break missingId;
      }

      id = R.id.iv_back;
      ImageView ivBack = ViewBindings.findChildViewById(rootView, id);
      if (ivBack == null) {
        break missingId;
      }

      id = R.id.tv_alamat;
      TextView tvAlamat = ViewBindings.findChildViewById(rootView, id);
      if (tvAlamat == null) {
        break missingId;
      }

      id = R.id.tv_hpKeluarga;
      TextView tvHpKeluarga = ViewBindings.findChildViewById(rootView, id);
      if (tvHpKeluarga == null) {
        break missingId;
      }

      id = R.id.tv_hpPribadi;
      TextView tvHpPribadi = ViewBindings.findChildViewById(rootView, id);
      if (tvHpPribadi == null) {
        break missingId;
      }

      id = R.id.tv_id;
      TextView tvId = ViewBindings.findChildViewById(rootView, id);
      if (tvId == null) {
        break missingId;
      }

      id = R.id.tv_inputPendaki;
      TextView tvInputPendaki = ViewBindings.findChildViewById(rootView, id);
      if (tvInputPendaki == null) {
        break missingId;
      }

      id = R.id.tv_nama;
      TextView tvNama = ViewBindings.findChildViewById(rootView, id);
      if (tvNama == null) {
        break missingId;
      }

      id = R.id.tv_namaregu;
      TextView tvNamaregu = ViewBindings.findChildViewById(rootView, id);
      if (tvNamaregu == null) {
        break missingId;
      }

      id = R.id.tv_regu;
      TextView tvRegu = ViewBindings.findChildViewById(rootView, id);
      if (tvRegu == null) {
        break missingId;
      }

      id = R.id.tv_umur;
      TextView tvUmur = ViewBindings.findChildViewById(rootView, id);
      if (tvUmur == null) {
        break missingId;
      }

      id = R.id.tv_yakin;
      TextView tvYakin = ViewBindings.findChildViewById(rootView, id);
      if (tvYakin == null) {
        break missingId;
      }

      return new ActivityKelolaRiwayatPendakiBinding((NestedScrollView) rootView, btnEditPendaki,
          btnHapusPendaki, btnSimpanPendaki, edAlamat, edIdPendaki, edNamaPendaki, edNamaregu,
          edNoHPKeluarga, edNoHPPribadi, edUmurPendaki, ivBack, tvAlamat, tvHpKeluarga, tvHpPribadi,
          tvId, tvInputPendaki, tvNama, tvNamaregu, tvRegu, tvUmur, tvYakin);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}