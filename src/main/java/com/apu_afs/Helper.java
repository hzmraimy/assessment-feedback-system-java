package com.apu_afs;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Helper {

  public static String firstLetterUpperCase(String string) {
    return string.substring(0, 1).toUpperCase() + string.substring(1);
  }

  public static ImageIcon iconResizer(ImageIcon icon, int width, int height) {
    Image transformedImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
    ImageIcon newIcon = new ImageIcon(transformedImage);
    return newIcon;
  }
}
