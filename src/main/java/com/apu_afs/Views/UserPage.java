package com.apu_afs.Views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import com.apu_afs.GlobalState;
import com.apu_afs.Models.User;
import com.apu_afs.TableModels.UserTableModel;
import com.apu_afs.Views.components.HeaderPanel;
import com.apu_afs.Views.components.NavPanel;
import com.apu_afs.Views.components.TextField;

import net.miginfocom.swing.MigLayout;

public class UserPage extends JPanel {

  HeaderPanel header;
  NavPanel nav;

  JPanel contentBody;

  JLabel formTitle;

  JPanel idRow;
  JPanel idFieldGroup;
  JLabel idLabel;
  TextField idField;

  JPanel usernamePasswordRow;
  JPanel usernameFieldGroup;
  JLabel usernameLabel;
  TextField usernameField;
  JLabel usernameErrorLabel;
  JPanel passwordFieldGroup;
  JLabel passwordLabel;
  TextField passwordField;
  JLabel passwordErrorLabel;

  JPanel firstLastNameRow;
  JPanel firstNameFieldGroup;
  JLabel firstNameLabel;
  TextField firstNamField;
  JLabel firstNameErrorLabel;
  JPanel lastNameFieldGroup;
  JLabel lastNameLabel;
  TextField lastNameField;
  JLabel lastNameErrorLabel;

  JPanel genderEmailRow;
  JPanel genderFieldGroup;
  JLabel genderLabel;
  JComboBox<String> gender;
  JLabel genderErrorLabel;
  JPanel emailFieldGroup;
  JLabel emailLabel;
  TextField emailField;
  JLabel emailErrorLabel;
  
 
  private static final String[] allowedRoles = {"admin"};
  private static final String dataContext = "User";
  
  public UserPage(Router router, GlobalState state, String selectedUserID) {
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
    } else if (!Arrays.asList(allowedRoles).contains(state.getCurrUser().getRole())) {
        SwingUtilities.invokeLater(() -> {
            router.showView(Pages.DASHBOARD, state);
        });
    }

    header = new HeaderPanel(router, state);
    nav = new NavPanel(router, state);

    contentBody = new JPanel(new MigLayout("insets 20 20, wrap 1, gapy 10"));
    contentBody.setBackground(App.slate100);

    
    
    this.add(header, "span, growx, wrap");
    this.add(nav, "growy");
    this.add(contentBody, "span, grow");
  }
}
