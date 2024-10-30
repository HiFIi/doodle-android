/*
 * This file is part of Doodle Android.
 *
 * Doodle Android is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Doodle Android is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Doodle Android. If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright (c) 2019-2024 by Patrick Zedler
 */

package xyz.zedler.patrick.doodle.fragment.dialog;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;

import androidx.annotation.NonNull;

import xyz.zedler.patrick.doodle.R;
import xyz.zedler.patrick.doodle.databinding.FragmentBottomsheetTextBinding;
import xyz.zedler.patrick.doodle.util.ResUtil;

public class TextBottomSheetDialogFragment extends BaseBottomSheetDialogFragment {

    private static final String TAG = "TextBottomSheet";

    private FragmentBottomsheetTextBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle state) {
        binding = FragmentBottomsheetTextBinding.inflate(inflater, container, false);

        TextBottomSheetDialogFragmentArgs args
                = TextBottomSheetDialogFragmentArgs.fromBundle(requireArguments());

        binding.toolbarText.setTitle(getString(args.getTitle()));

        String link = args.getLink() != 0 ? getString(args.getLink()) : null;
        if (link != null) {
            binding.toolbarText.inflateMenu(R.menu.menu_link);
            ResUtil.tintMenuIcons(requireContext(), binding.toolbarText.getMenu());
            binding.toolbarText.setOnMenuItemClickListener(item -> {
                int id = item.getItemId();
                if (id == R.id.action_open_link && getViewUtil().isClickEnabled(id)) {
                    performHapticClick();
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(link)));
                    return true;
                } else {
                    return false;
                }
            });
        }
        binding.toolbarText.setTitleCentered(link == null);

        String[] highlights = args.getHighlights();
        if (highlights == null) {
            highlights = new String[]{};
        }
        binding.formattedText.setText(ResUtil.getRawText(requireContext(), args.getFile()), highlights);

        return binding.getRoot();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }

    @Override
    public void applyBottomInset(int bottom) {
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 0, 0, bottom);
        binding.formattedText.setLayoutParams(params);
    }

    @NonNull
    @Override
    public String toString() {
        return TAG;
    }
}
