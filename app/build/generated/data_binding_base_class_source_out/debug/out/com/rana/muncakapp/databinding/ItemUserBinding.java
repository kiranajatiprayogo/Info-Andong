// Generated by view binder compiler. Do not edit!
package com.rana.muncakapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.rana.muncakapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemUserBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final RelativeLayout cvUser;

  @NonNull
  public final TextView emailUser;

  @NonNull
  public final TextView profilUser;

  @NonNull
  public final TextView tipeUser;

  private ItemUserBinding(@NonNull RelativeLayout rootView, @NonNull RelativeLayout cvUser,
      @NonNull TextView emailUser, @NonNull TextView profilUser, @NonNull TextView tipeUser) {
    this.rootView = rootView;
    this.cvUser = cvUser;
    this.emailUser = emailUser;
    this.profilUser = profilUser;
    this.tipeUser = tipeUser;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemUserBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemUserBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_user, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemUserBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      RelativeLayout cvUser = (RelativeLayout) rootView;

      id = R.id.emailUser;
      TextView emailUser = ViewBindings.findChildViewById(rootView, id);
      if (emailUser == null) {
        break missingId;
      }

      id = R.id.profilUser;
      TextView profilUser = ViewBindings.findChildViewById(rootView, id);
      if (profilUser == null) {
        break missingId;
      }

      id = R.id.tipeUser;
      TextView tipeUser = ViewBindings.findChildViewById(rootView, id);
      if (tipeUser == null) {
        break missingId;
      }

      return new ItemUserBinding((RelativeLayout) rootView, cvUser, emailUser, profilUser,
          tipeUser);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
