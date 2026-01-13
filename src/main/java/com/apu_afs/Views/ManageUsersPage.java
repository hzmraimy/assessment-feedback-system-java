package com.apu_afs.Views;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.apu_afs.GlobalState;
import com.apu_afs.Views.components.HeaderPanel;
import com.apu_afs.Views.components.NavPanel;

import net.miginfocom.swing.MigLayout;

public class ManageUsersPage extends JPanel {

  HeaderPanel header;
  NavPanel nav;

  JPanel contentBody;
  JPanel searchBar;
  
  public ManageUsersPage(Router router, GlobalState state) {
    super(new MigLayout(
      "fill, insets 0, gap 0",  
        "[][][grow]",              
        "[][grow]"   
    ));

    if (state.getCurrUser() == null) {
      SwingUtilities.invokeLater(() -> {
        router.showView(Pages.LOGIN, state);
      });
      return;
    }

    header = new HeaderPanel(router, state);
    nav = new NavPanel(router, state);

    contentBody = new JPanel(new MigLayout("align center center"));
    contentBody.setBackground(App.slate100);

    JLabel temp = new JLabel();
    temp.setText("this is manage users page" + router.getCurrPage().getDisplay());
    contentBody.add(temp);
    
    this.add(header, "span, growx, wrap");
    this.add(nav, "growy");
    this.add(contentBody, "span, grow");
  }
}
