package com.apu_afs.Models;

import java.util.HashMap;
import java.util.List;

import com.apu_afs.Views.Pages;

public class Admin extends User {
  
  public Admin(List<String> props) {
    super(props);
    this.navOptions.add(new NavOption(Pages.MANAGEUSERS));
  }

  public Admin(HashMap<String, String> inputValues) {
    super(inputValues);
  }

  @Override
  public void updateUser() {
    super.updateUser();
  }  
}
