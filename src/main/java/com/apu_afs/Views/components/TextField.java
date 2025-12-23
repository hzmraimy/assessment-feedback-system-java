package com.apu_afs.Views.components;

import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JTextField;

public class TextField extends JTextField{
  
  public TextField(String placeholder) {
    super();
    this.setText(placeholder);
    this.addFocusListener(new FocusAdapter() {
      @Override
      public void focusGained(FocusEvent e) {
        if (TextField.this.getText().equals(placeholder)) {
          TextField.this.setText("");
          TextField.this.setForeground(Color.BLACK);
        }
      }
      
      @Override
      public void focusLost(FocusEvent e) {
        if (TextField.this.getText().isEmpty()) {
          TextField.this.setText(placeholder);
          TextField.this.setForeground(Color.GRAY);
        }
      }
    });
  }


}
