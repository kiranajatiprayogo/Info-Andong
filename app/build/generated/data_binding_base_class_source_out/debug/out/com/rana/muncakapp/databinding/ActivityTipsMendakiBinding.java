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

public final class ActivityTipsMendakiBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final Toolbar btnKembali;

  @NonNull
  public final ImageView imgTips;

  @NonNull
  public final TextView tvSub1Tips;

  @NonNull
  public final TextView tvSub2Tips;

  @NonNull
  public final TextView tvSub3Tips;

  @NonNull
  public final TextView tvSub4Tips;

  @NonNull
  public final TextView tvSub5Tips;

  @NonNull
  public final TextView tvTipsMendaki;

  private ActivityTipsMendakiBinding(@NonNull RelativeLayout rootView, @NonNull Toolbar btnKembali,
      @NonNull ImageView imgTips, @NonNull TextView tvSub1Tips, @NonNull TextView tvSub2Tips,
      @NonNull TextView tvSub3Tips, @NonNull TextView tvSub4Tips, @NonNull TextView tvSub5Tips,
      @NonNull TextView tvTipsMendaki) {
    this.rootView = rootView;
    this.btnKembali = btnKembali;
    this.imgTips = imgTips;
    this.tvSub1Tips = tvSub1Tips;
    this.tvSub2Tips = tvSub2Tips;
    this.tvSub3Tips = tvSub3Tips;
    this.tvSub4Tips = tvSub4Tips;
    this.tvSub5Tips = tvSub5Tips;
    this.tvTipsMendaki = tvTipsMendaki;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityTipsMendakiBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityTipsMendakiBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_tips_mendaki, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityTipsMendakiBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_kembali;
      Toolbar btnKembali = ViewBindings.findChildViewById(rootView, id);
      if (btnKembali == null) {
        break missingId;
      }

      id = R.id.img_tips;
      ImageView imgTips = ViewBindings.findChildViewById(rootView, id);
      if (imgTips == null) {
        break missingId;
      }

      id = R.id.tv_sub1Tips;
      TextView tvSub1Tips = ViewBindings.findChildViewById(rootView, id);
      if (tvSub1Tips == null) {
        break missingId;
      }

      id = R.id.tv_sub2Tips;
      TextView tvSub2Tips = ViewBindings.findChildViewById(rootView, id);
      if (tvSub2Tips == null) {
        break missingId;
      }

      id = R.id.tv_sub3Tips;
      TextView tvSub3Tips = ViewBindings.findChildViewById(rootView, id);
      if (tvSub3Tips == null) {
        break missingId;
      }

      id = R.id.tv_sub4Tips;
      TextView tvSub4Tips = ViewBindings.findChildViewById(rootView, id);
      if (tvSub4Tips == null) {
        break missingId;
      }

      id = R.id.tv_sub5Tips;
      TextView tvSub5Tips = ViewBindings.findChildViewById(rootView, id);
      if (tvSub5Tips == null) {
        break missingId;
      }

      id = R.id.tv_tipsMendaki;
      TextView tvTipsMendaki = ViewBindings.findChildViewById(rootView, id);
      if (tvTipsMendaki == null) {
        break missingId;
      }

      return new ActivityTipsMendakiBinding((RelativeLayout) rootView, btnKembali, imgTips,
          tvSub1Tips, tvSub2Tips, tvSub3Tips, tvSub4Tips, tvSub5Tips, tvTipsMendaki);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}