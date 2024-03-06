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
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.rana.muncakapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityKelolaRencanaPendakianBinding implements ViewBinding {
  @NonNull
  private final NestedScrollView rootView;

  @NonNull
  public final Button btnEditPendakian;

  @NonNull
  public final Button btnHapusPendakian;

  @NonNull
  public final Button btnSimpanPendakian;

  @NonNull
  public final TextView edIdRegu;

  @NonNull
  public final EditText edJumlahRegu;

  @NonNull
  public final EditText edNamaRegu;

  @NonNull
  public final EditText edTglNaik;

  @NonNull
  public final TextView edTglPesan;

  @NonNull
  public final EditText edTglTurun;

  @NonNull
  public final TextView edUsername;

  @NonNull
  public final TextView tvId;

  @NonNull
  public final TextView tvInputPendakian;

  @NonNull
  public final TextView tvNamaRegu;

  @NonNull
  public final TextView tvStatusPendakian;

  @NonNull
  public final TextView tvTglPesan;

  @NonNull
  public final TextView tvUsername;

  private ActivityKelolaRencanaPendakianBinding(@NonNull NestedScrollView rootView,
      @NonNull Button btnEditPendakian, @NonNull Button btnHapusPendakian,
      @NonNull Button btnSimpanPendakian, @NonNull TextView edIdRegu,
      @NonNull EditText edJumlahRegu, @NonNull EditText edNamaRegu, @NonNull EditText edTglNaik,
      @NonNull TextView edTglPesan, @NonNull EditText edTglTurun, @NonNull TextView edUsername,
      @NonNull TextView tvId, @NonNull TextView tvInputPendakian, @NonNull TextView tvNamaRegu,
      @NonNull TextView tvStatusPendakian, @NonNull TextView tvTglPesan,
      @NonNull TextView tvUsername) {
    this.rootView = rootView;
    this.btnEditPendakian = btnEditPendakian;
    this.btnHapusPendakian = btnHapusPendakian;
    this.btnSimpanPendakian = btnSimpanPendakian;
    this.edIdRegu = edIdRegu;
    this.edJumlahRegu = edJumlahRegu;
    this.edNamaRegu = edNamaRegu;
    this.edTglNaik = edTglNaik;
    this.edTglPesan = edTglPesan;
    this.edTglTurun = edTglTurun;
    this.edUsername = edUsername;
    this.tvId = tvId;
    this.tvInputPendakian = tvInputPendakian;
    this.tvNamaRegu = tvNamaRegu;
    this.tvStatusPendakian = tvStatusPendakian;
    this.tvTglPesan = tvTglPesan;
    this.tvUsername = tvUsername;
  }

  @Override
  @NonNull
  public NestedScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityKelolaRencanaPendakianBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityKelolaRencanaPendakianBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_kelola_rencana_pendakian, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityKelolaRencanaPendakianBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_editPendakian;
      Button btnEditPendakian = ViewBindings.findChildViewById(rootView, id);
      if (btnEditPendakian == null) {
        break missingId;
      }

      id = R.id.btn_hapusPendakian;
      Button btnHapusPendakian = ViewBindings.findChildViewById(rootView, id);
      if (btnHapusPendakian == null) {
        break missingId;
      }

      id = R.id.btn_simpanPendakian;
      Button btnSimpanPendakian = ViewBindings.findChildViewById(rootView, id);
      if (btnSimpanPendakian == null) {
        break missingId;
      }

      id = R.id.ed_idRegu;
      TextView edIdRegu = ViewBindings.findChildViewById(rootView, id);
      if (edIdRegu == null) {
        break missingId;
      }

      id = R.id.ed_jumlahRegu;
      EditText edJumlahRegu = ViewBindings.findChildViewById(rootView, id);
      if (edJumlahRegu == null) {
        break missingId;
      }

      id = R.id.ed_namaRegu;
      EditText edNamaRegu = ViewBindings.findChildViewById(rootView, id);
      if (edNamaRegu == null) {
        break missingId;
      }

      id = R.id.ed_tglNaik;
      EditText edTglNaik = ViewBindings.findChildViewById(rootView, id);
      if (edTglNaik == null) {
        break missingId;
      }

      id = R.id.ed_tglPesan;
      TextView edTglPesan = ViewBindings.findChildViewById(rootView, id);
      if (edTglPesan == null) {
        break missingId;
      }

      id = R.id.ed_tglTurun;
      EditText edTglTurun = ViewBindings.findChildViewById(rootView, id);
      if (edTglTurun == null) {
        break missingId;
      }

      id = R.id.ed_username;
      TextView edUsername = ViewBindings.findChildViewById(rootView, id);
      if (edUsername == null) {
        break missingId;
      }

      id = R.id.tv_id;
      TextView tvId = ViewBindings.findChildViewById(rootView, id);
      if (tvId == null) {
        break missingId;
      }

      id = R.id.tv_inputPendakian;
      TextView tvInputPendakian = ViewBindings.findChildViewById(rootView, id);
      if (tvInputPendakian == null) {
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

      id = R.id.tv_tglPesan;
      TextView tvTglPesan = ViewBindings.findChildViewById(rootView, id);
      if (tvTglPesan == null) {
        break missingId;
      }

      id = R.id.tv_username;
      TextView tvUsername = ViewBindings.findChildViewById(rootView, id);
      if (tvUsername == null) {
        break missingId;
      }

      return new ActivityKelolaRencanaPendakianBinding((NestedScrollView) rootView,
          btnEditPendakian, btnHapusPendakian, btnSimpanPendakian, edIdRegu, edJumlahRegu,
          edNamaRegu, edTglNaik, edTglPesan, edTglTurun, edUsername, tvId, tvInputPendakian,
          tvNamaRegu, tvStatusPendakian, tvTglPesan, tvUsername);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}