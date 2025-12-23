package com.apu_afs.Views;


import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.apu_afs.GlobalState;

public class LoginPage extends JPanel {
  JPanel imageContainer;
  JPanel formContainer;
  
  public LoginPage(Router router, GlobalState state) {
    super(new GridLayout(1, 2));

    ImageIcon backgroundImage = new ImageIcon("assets/apu-background-dimmed.png");
    JLabel imageLabel = new JLabel();
    imageLabel.setIcon(backgroundImage);

    imageContainer = new JPanel();
    imageContainer.add(imageLabel);
    
    formContainer = new JPanel();
    
    this.add(imageContainer);
    this.add(formContainer);
  }
}
