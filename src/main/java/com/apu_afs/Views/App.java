package com.apu_afs.Views;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.apu_afs.GlobalState;

public class App extends JFrame {
  private static String title = "Assessment Feedback System - APU";
  private static int frameWidth = 1440;
  private static int frameHeight = 900;
  private static String icoPath = "assets/apu-icon.png"; 
  
  public App(GlobalState state) {
    this.setTitle(App.title);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setResizable(true);
    this.setSize(App.frameWidth, App.frameHeight);
    this.setLocationRelativeTo(null);
    this.add(new Router(state));
    
    ImageIcon ico = new ImageIcon(App.icoPath);
    this.setIconImage(ico.getImage());
    this.getContentPane().setBackground(new Color(0xcad5e2));
    this.setVisible(true);
  }
}
