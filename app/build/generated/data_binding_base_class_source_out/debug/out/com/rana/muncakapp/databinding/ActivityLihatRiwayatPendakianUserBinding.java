// Generated by view binder compiler. Do not edit!
package com.rana.muncakapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.rana.muncakapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityLihatRiwayatPendakianUserBinding implements ViewBinding {
  @NonNull
  private final NestedScrollView rootView;

  @NonNull
  public final ImageView ivBack;

  @NonNull
  public final RecyclerView rvRiwayatPendakianUser;

  @NonNull
  public final TextView tvIdRegu;

  @NonNull
  public final TextView tvLihatPendakian;

  private ActivityLihatRiwayatPendakianUserBinding(@NonNull NestedScrollView rootView,
      @NonNull ImageView ivBack, @NonNull RecyclerView rvRiwayatPendakianUser,
      @NonNull TextView tvIdRegu, @NonNull TextView tvLihatPendakian) {
    this.rootView = rootView;
    this.ivBack = ivBack;
    this.rvRiwayatPendakianUser = rvRiwayatPendakianUser;
    this.tvIdRegu = tvIdRegu;
    this.tvLihatPendakian = tvLihatPendakian;
  }

  @Override
  @NonNull
  public NestedScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityLihatRiwayatPendakianUserBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityLihatRiwayatPendakianUserBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_lihat_riwayat_pendakian_user, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityLihatRiwayatPendakianUserBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.iv_back;
      ImageView ivBack = ViewBindings.findChildViewById(rootView, id);
      if (ivBack == null) {
        break missingId;
      }

      id = R.id.rvRiwayatPendakianUser;
      RecyclerView rvRiwayatPendakianUser = ViewBindings.findChildViewById(rootView, id);
      if (rvRiwayatPendakianUser == null) {
        break missingId;
      }

      id = R.id.tv_idRegu;
      TextView tvIdRegu = ViewBindings.findChildViewById(rootView, id);
      if (tvIdRegu == null) {
        break missingId;
      }

      id = R.id.tv_lihatPendakian;
      TextView tvLihatPendakian = ViewBindings.findChildViewById(rootView, id);
      if (tvLihatPendakian == null) {
        break missingId;
      }

      return new ActivityLihatRiwayatPendakianUserBinding((NestedScrollView) rootView, ivBack,
          rvRiwayatPendakianUser, tvIdRegu, tvLihatPendakian);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
