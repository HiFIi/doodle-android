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
 * Copyright (c) 2020-2021 by Patrick Zedler
 */

package xyz.zedler.patrick.doodle.wallpaper;

import androidx.annotation.NonNull;

import xyz.zedler.patrick.doodle.Constants.WALLPAPER;
import xyz.zedler.patrick.doodle.R;

public class FloralWallpaper extends BaseWallpaper {

  public FloralWallpaper() {
    setRotationSupported(true);
  }

  @NonNull
  @Override
  public String getName() {
    return WALLPAPER.FLORAL;
  }

  @Override
  public int getThumbnailResId() {
    return R.drawable.selection_pixel;
  }

  @NonNull
  @Override
  public WallpaperVariant[] getVariants() {
    return new WallpaperVariant[]{
        new WallpaperVariant(
            R.raw.wallpaper_floral5,
            "#e0dcd3",
            "#ffb9a1",
            "#f4e3c9",
            true,
            false
        ),
    };
  }

  @NonNull
  @Override
  public WallpaperVariant[] getDarkVariants() {
      return new WallpaperVariant[]{
              new WallpaperVariant(
                      R.raw.wallpaper_floral5,
                      "#e0dcd3",
                      "#ffb9a1",
                      "#f4e3c9",
                      true,
                      false
              ),
      };
  }
}