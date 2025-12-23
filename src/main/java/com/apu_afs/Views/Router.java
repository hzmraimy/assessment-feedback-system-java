package com.apu_afs.Views;

import javax.swing.JPanel;
import com.apu_afs.GlobalState;

public class Router extends JPanel {

  public Router(GlobalState state) {

    this.showView("login", state);
  }
  
  public void showView(String page, GlobalState state) {
    this.removeAll();

    this.add(this.createPanel(page, state));

    revalidate();
    repaint();
  }

  private JPanel createPanel(String page, GlobalState state) {
    switch (page) {
      case "login": return new LoginPage(this, state);
      case "dashboard": return new DashboardPage(this, state);
      default: return new DashboardPage(this, state);
    }
  }
}
