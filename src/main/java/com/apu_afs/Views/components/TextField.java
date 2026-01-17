package com.apu_afs.Views.components;

import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JTextField;

public class TextField extends JTextField{
  String placeholder;
  boolean hasBeenFocused = false;
  
  public TextField(String placeholder) {
    super();
    this.placeholder = placeholder;
    this.setText(placeholder);
    this.setForeground(Color.GRAY);
    this.addFocusListener(new FocusAdapter() {
      @Override
      public void focusGained(FocusEvent e) {
        if (!hasBeenFocused) {
          TextField.this.setText("");
          TextField.this.setForeground(Color.BLACK);
          TextField.this.hasBeenFocused = true;
        }
      }
    });
  }

  @Override
  public String getText() {
    if (super.getText().equals(this.placeholder)) {
      return "";
    }
    return super.getText();
  }

  @Override
  public void setText(String text) {
    if (!text.equals(this.placeholder)) {
      this.setForeground(Color.BLACK);
      this.hasBeenFocused = true;
    }

    super.setText(text);
  }
}
