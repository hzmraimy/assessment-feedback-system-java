package com.apu_afs.Models;

import java.util.HashMap;
import java.util.List;

public class Student extends User {
  
  public Student(List<String> props) {
    super(props);
  }

  public Student(HashMap<String, String> inputValues) {
    super(inputValues);
  }

  @Override
  public void updateUser() {
    super.updateUser();
  }  
}
