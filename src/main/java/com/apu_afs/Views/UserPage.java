package com.apu_afs.Views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
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

  JTabbedPane formTabbedPane;
  JPanel mainform;
  JPanel subform;

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
  TextField firstNameField;
  JLabel firstNameErrorLabel;
  JPanel lastNameFieldGroup;
  JLabel lastNameLabel;
  TextField lastNameField;
  JLabel lastNameErrorLabel;

  String[] genderOptions = {"Male", "Female"};

  JPanel genderEmailRow;
  JPanel genderFieldGroup;
  JLabel genderLabel;
  JComboBox<String> genderComboBox;
  JLabel genderErrorLabel;
  JPanel emailFieldGroup;
  JLabel emailLabel;
  TextField emailField;
  JLabel emailErrorLabel;

  String[] roleOptions = {"Admin", "Academic Leader", "Lecturer", "Student"};

  JPanel phoneRoleRow;
  JPanel phoneNumberFieldGroup;
  JLabel phoneNumberLabel;
  TextField phoneNumberField;
  JLabel phoneNumberErrorLabel;
  JPanel roleFieldGroup;
  JLabel roleLabel;
  JComboBox<String> roleComboBox;
  JLabel roleErrorLabel;

  JPanel actionButtonGroup;
  JButton submitBtn;
  JButton deleteBtn;

  User editingUser;
 
  private static final String[] allowedRoles = {"admin"};
  private static final String dataContext = "User";
  
  public UserPage(Router router, GlobalState state) {
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

    String actionContext;
    if (state.getSelectedUserID() == null) {
      actionContext = "add";
      editingUser = null;
    } else {
      actionContext = "edit";
      editingUser = User.getUserByID(state.getSelectedUserID());
    }

    header = new HeaderPanel(router, state);
    nav = new NavPanel(router, state);

    contentBody = new JPanel(new MigLayout("insets 20 20, wrap 1, gapy 10"));
    contentBody.setBackground(App.slate100);

    formTitle = new JLabel();
    if (actionContext.equals("edit")) {
      formTitle.setText("Editing User ID: " + editingUser.getID());
    } else {
      formTitle.setText("Create New User Form");
    }
    formTitle.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));

    usernameLabel = new JLabel();
    usernameLabel.setText("Username: ");
    usernameField = new TextField("Enter Username Here...");
    usernameField.setBackground(App.slate200);
    usernameField.setBorder(BorderFactory.createCompoundBorder(usernameField.getBorder(), BorderFactory.createEmptyBorder(10, 15, 10, 15)));
    usernameField.setPreferredSize(new Dimension(600, 35));
    if (actionContext.equals("edit")) {
      usernameField.setText(editingUser.getUsername());
    }
    usernameErrorLabel = new JLabel();
    usernameErrorLabel.setForeground(App.red600);
    usernameFieldGroup = new JPanel(new MigLayout("insets 0, wrap 1, gap 5"));
    usernameFieldGroup.add(usernameLabel);
    usernameFieldGroup.add(usernameField);
    usernameFieldGroup.add(usernameErrorLabel);

    passwordLabel = new JLabel();
    passwordLabel.setText("Password: ");
    passwordField = new TextField("Enter Password Here...");
    passwordField.setBackground(App.slate200);
    passwordField.setBorder(BorderFactory.createCompoundBorder(passwordField.getBorder(), BorderFactory.createEmptyBorder(10, 15, 10, 15)));
    passwordField.setPreferredSize(new Dimension(600, 35));
    if (actionContext.equals("edit")) {
      passwordField.setText(editingUser.getPassword());
    }
    passwordErrorLabel = new JLabel();
    passwordErrorLabel.setForeground(App.red600);
    passwordFieldGroup = new JPanel(new MigLayout("insets 0, wrap 1, gap 5"));
    passwordFieldGroup.add(passwordLabel);
    passwordFieldGroup.add(passwordField);
    passwordFieldGroup.add(passwordErrorLabel);

    firstNameLabel = new JLabel();
    firstNameLabel.setText("First Name: ");
    firstNameField = new TextField("Enter First Name Here...");
    firstNameField.setBackground(App.slate200);
    firstNameField.setBorder(BorderFactory.createCompoundBorder(firstNameField.getBorder(), BorderFactory.createEmptyBorder(10, 15, 10, 15)));
    firstNameField.setPreferredSize(new Dimension(600, 35));
    if (actionContext.equals("edit")) {
      firstNameField.setText(editingUser.getFirstName());
    }
    firstNameErrorLabel = new JLabel();
    firstNameErrorLabel.setForeground(App.red600);
    firstNameFieldGroup = new JPanel(new MigLayout("insets 0, wrap 1, gap 5"));
    firstNameFieldGroup.add(firstNameLabel);
    firstNameFieldGroup.add(firstNameField);
    firstNameFieldGroup.add(firstNameErrorLabel);

    lastNameLabel = new JLabel();
    lastNameLabel.setText("Last Name: ");
    lastNameField = new TextField("Enter Last Name Here...");
    lastNameField.setBackground(App.slate200);
    lastNameField.setBorder(BorderFactory.createCompoundBorder(lastNameField.getBorder(), BorderFactory.createEmptyBorder(10, 15, 10, 15)));
    lastNameField.setPreferredSize(new Dimension(600, 35));
    if (actionContext.equals("edit")) {
      lastNameField.setText(editingUser.getLastName());
    }
    lastNameErrorLabel = new JLabel();
    lastNameErrorLabel.setForeground(App.red600);
    lastNameFieldGroup = new JPanel(new MigLayout("insets 0, wrap 1, gap 5"));
    lastNameFieldGroup.add(lastNameLabel);
    lastNameFieldGroup.add(lastNameField);
    lastNameFieldGroup.add(lastNameErrorLabel);

    genderLabel = new JLabel();
    genderLabel.setText("Gender: ");
    genderComboBox = new JComboBox<>(genderOptions);
    genderComboBox.setBackground(App.slate200);
    genderComboBox.setBorder(BorderFactory.createCompoundBorder(genderComboBox.getBorder(), BorderFactory.createEmptyBorder(10, 15, 10, 15)));
    genderComboBox.setPreferredSize(new Dimension(600, 35));
    if (actionContext.equals("edit")) {
      genderComboBox.setSelectedIndex(editingUser.getGender() == 'm' ? 0 : 1);
    }
    genderErrorLabel = new JLabel();
    genderErrorLabel.setForeground(App.red600);
    genderFieldGroup = new JPanel(new MigLayout("insets 0, wrap 1, gap 5"));
    genderFieldGroup.add(genderLabel);
    genderFieldGroup.add(genderComboBox);
    genderFieldGroup.add(genderErrorLabel);

    emailLabel = new JLabel();
    emailLabel.setText("Email: ");
    emailField = new TextField("Enter Email Here...");
    emailField.setBackground(App.slate200);
    emailField.setBorder(BorderFactory.createCompoundBorder(emailField.getBorder(), BorderFactory.createEmptyBorder(10, 15, 10, 15)));
    emailField.setPreferredSize(new Dimension(600, 35));
    if (actionContext.equals("edit")) {
      emailField.setText(editingUser.getEmail());
    }
    emailErrorLabel = new JLabel();
    emailErrorLabel.setForeground(App.red600);
    emailFieldGroup = new JPanel(new MigLayout("insets 0, wrap 1, gap 5"));
    emailFieldGroup.add(emailLabel);
    emailFieldGroup.add(emailField);
    emailFieldGroup.add(emailErrorLabel);

    phoneNumberLabel = new JLabel();
    phoneNumberLabel.setText("Phone Number: ");
    phoneNumberField = new TextField("Enter Phone Number Here...");
    phoneNumberField.setBackground(App.slate200);
    phoneNumberField.setBorder(BorderFactory.createCompoundBorder(phoneNumberField.getBorder(), BorderFactory.createEmptyBorder(10, 15, 10, 15)));
    phoneNumberField.setPreferredSize(new Dimension(600, 35));
    if (actionContext.equals("edit")) {
      phoneNumberField.setText(editingUser.getPhoneNumber());
    }
    phoneNumberErrorLabel = new JLabel();
    phoneNumberErrorLabel.setForeground(App.red600);
    phoneNumberFieldGroup = new JPanel(new MigLayout("insets 0, wrap 1, gap 5"));
    phoneNumberFieldGroup.add(phoneNumberLabel);
    phoneNumberFieldGroup.add(phoneNumberField);
    phoneNumberFieldGroup.add(phoneNumberErrorLabel);

    roleLabel = new JLabel();
    roleLabel.setText("Role: ");
    roleComboBox = new JComboBox<>(roleOptions);
    roleComboBox.setBackground(App.slate200);
    roleComboBox.setBorder(BorderFactory.createCompoundBorder(roleComboBox.getBorder(), BorderFactory.createEmptyBorder(10, 15, 10, 15)));
    roleComboBox.setPreferredSize(new Dimension(600, 35));
    if (actionContext.equals("edit")) {
      if (editingUser.getRole().equals("admin")) {
        roleComboBox.setSelectedIndex(0);
      } else if (editingUser.getRole().equals("academic")) {
        roleComboBox.setSelectedIndex(1);
      } else if (editingUser.getRole().equals("lecturer")) {
        roleComboBox.setSelectedIndex(2);
      } else {
        roleComboBox.setSelectedIndex(3);
      }
    }
    roleErrorLabel = new JLabel();
    roleErrorLabel.setForeground(App.red600);
    roleFieldGroup = new JPanel(new MigLayout("insets 0, wrap 1, gap 5"));
    roleFieldGroup.add(roleLabel);
    roleFieldGroup.add(roleComboBox);
    roleFieldGroup.add(roleErrorLabel); 

    usernamePasswordRow = new JPanel(new MigLayout("insets 0, aligny center, gapx 100"));
    usernamePasswordRow.add(usernameFieldGroup);
    usernamePasswordRow.add(passwordFieldGroup);

    firstLastNameRow = new JPanel(new MigLayout("insets 0, aligny center, gapx 100"));
    firstLastNameRow.add(firstNameFieldGroup);
    firstLastNameRow.add(lastNameFieldGroup);

    genderEmailRow = new JPanel(new MigLayout("insets 0, aligny center, gapx 100"));
    genderEmailRow.add(genderFieldGroup);
    genderEmailRow.add(emailFieldGroup);

    phoneRoleRow = new JPanel(new MigLayout("insets 0, aligny center, gapx 100"));
    phoneRoleRow.add(phoneNumberFieldGroup);
    phoneRoleRow.add(roleFieldGroup);

    mainform = new JPanel(new MigLayout("insets 30 0, wrap 1, gapy 10"));
    mainform.setBackground(App.slate100);
    mainform.add(usernamePasswordRow, "width 100%");
    mainform.add(firstLastNameRow, "width 100%");
    mainform.add(genderEmailRow, "width 100%");
    mainform.add(phoneRoleRow, "width 100%");

    formTabbedPane = new JTabbedPane();
    formTabbedPane.addTab("User Information", mainform);

    submitBtn = new JButton();
    submitBtn.setText("Submit");
    submitBtn.setForeground(Color.WHITE);
    submitBtn.setBackground(App.green600);
    submitBtn.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
    submitBtn.setBorder(BorderFactory.createCompoundBorder(submitBtn.getBorder(), BorderFactory.createEmptyBorder(5, 6, 5, 6)));
    submitBtn.setFocusable(false);
    submitBtn.addActionListener(e -> {

    });

    deleteBtn = new JButton();
    deleteBtn.setText("Delete User");
    deleteBtn.setForeground(Color.WHITE);
    deleteBtn.setBackground(App.red600);
    deleteBtn.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
    deleteBtn.setBorder(BorderFactory.createCompoundBorder(deleteBtn.getBorder(), BorderFactory.createEmptyBorder(5, 6, 5, 6)));
    deleteBtn.setFocusable(false);
    deleteBtn.addActionListener(e -> {
      
    });

    actionButtonGroup = new JPanel(new MigLayout("insets 50 0, aligny center"));
    if (actionContext.equals("edit")) {
      actionButtonGroup.add(deleteBtn);
    }
    actionButtonGroup.add(submitBtn, "push, alignx right");

    contentBody.add(formTitle);
    contentBody.add(formTabbedPane, "width 100%");
    contentBody.add(actionButtonGroup, "width 100%");
    
    this.add(header, "span, growx, wrap");
    this.add(nav, "growy");
    this.add(contentBody, "span, grow");
  }
}
