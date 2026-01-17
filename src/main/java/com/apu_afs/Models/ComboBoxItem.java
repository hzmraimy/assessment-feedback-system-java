package com.apu_afs.Models;

public class ComboBoxItem {
  private String value;      
  private String labelText;  

  public ComboBoxItem(String value, String labelText) {
    this.value = value;
    this.labelText = labelText;
  }

  public String getValue() {
      return value;
  }

  public String getLabelText() {
      return labelText;
  }
}
