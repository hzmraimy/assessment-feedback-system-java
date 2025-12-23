package com.apu_afs.Views;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.apu_afs.GlobalState;
import com.apu_afs.Views.components.TextField;

public class LoginPage extends JPanel {
  JPanel imageContainer;
  JLabel imageLabel;

  JPanel formContainer;
  JPanel form;
  JPanel formHeader;
  JLabel formHeaderImageLabel;
  JPanel titleContainer;
  JLabel titleAssessmentLabel;
  JLabel titleFeedbackLabel;
  JLabel titleSystemLabel;
  JPanel loginLabelContainer;
  JLabel loginLabel;
  JLabel usernameLabel;
  TextField usernameTextfield;
  JLabel usernameErrorLabel;
  JLabel passwordLabel;
  TextField passwordTextField;
  JLabel passwordErrorLabel;
  JCheckBox staySignedInCheckBox;
  JPanel loginBtnContainer;
  JButton loginBtn;

  static String usernamePlaceholder = "Enter your Username...";
  static String passwordPlaceholder = "Enter your Password...";
  
  public LoginPage(Router router, GlobalState state) {
    super(new GridLayout(1, 2));

    imageLabel = new JLabel();
    imageLabel.setIcon(new ImageIcon("assets/apu-background-dimmed.png"));

    imageContainer = new JPanel();
    imageContainer.add(imageLabel);

    formHeaderImageLabel = new JLabel();
    formHeaderImageLabel.setIcon(App.iconResizer(new ImageIcon("assets/apu-icon.png"), 64, 64));

    titleAssessmentLabel = new JLabel();
    titleAssessmentLabel.setText("Assessment");
    titleFeedbackLabel = new JLabel();
    titleFeedbackLabel.setText("Feedback");
    titleSystemLabel = new JLabel();
    titleSystemLabel.setText("System");

    titleContainer = new JPanel(new GridLayout(3, 1));
    titleContainer.setBackground(new Color(0xf1f5f9));
    titleContainer.add(titleAssessmentLabel);
    titleContainer.add(titleFeedbackLabel);
    titleContainer.add(titleSystemLabel);

    formHeader = new JPanel();
    formHeader.setBackground(new Color(0xf1f5f9));
    formHeader.setAlignmentX(JPanel.LEFT_ALIGNMENT);
    formHeader.add(formHeaderImageLabel);
    formHeader.add(titleContainer);

    loginLabel = new JLabel();
    loginLabel.setText("Login");
    loginLabelContainer = new JPanel(new FlowLayout(FlowLayout.CENTER));
    loginLabelContainer.setBackground(new Color(0xf1f5f9));
    loginLabelContainer.setAlignmentX(JPanel.LEFT_ALIGNMENT);
    loginLabelContainer.add(loginLabel);
    usernameLabel = new JLabel();
    usernameLabel.setText("Username: ");
    usernameLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT);
    usernameTextfield = new TextField(LoginPage.usernamePlaceholder);
    usernameTextfield.setBackground(new Color(0xe2e8f0));
    usernameTextfield.setBorder(BorderFactory.createCompoundBorder(usernameTextfield.getBorder(), BorderFactory.createEmptyBorder(10, 15, 10, 15)));
    usernameTextfield.setPreferredSize(new Dimension(250, 50));
    usernameTextfield.setAlignmentX(JTextField.LEFT_ALIGNMENT);
    usernameErrorLabel = new JLabel();
    usernameErrorLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT);
    passwordLabel = new JLabel();
    passwordLabel.setText("Password: ");
    passwordLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT);
    passwordTextField = new TextField(LoginPage.passwordPlaceholder);
    passwordTextField.setBackground(new Color(0xe2e8f0));
    passwordTextField.setBorder(BorderFactory.createCompoundBorder(passwordTextField.getBorder(), BorderFactory.createEmptyBorder(10, 15, 10, 15)));
    passwordTextField.setPreferredSize(new Dimension(250, 50));
    passwordTextField.setAlignmentX(JTextField.LEFT_ALIGNMENT);
    passwordErrorLabel = new JLabel();
    passwordErrorLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT);
    staySignedInCheckBox = new JCheckBox();
    staySignedInCheckBox.setFocusable(false);
    staySignedInCheckBox.setText("Stay Signed In?");
    staySignedInCheckBox.setBackground(new Color(0xf1f5f9));
    staySignedInCheckBox.setAlignmentX(JCheckBox.LEFT_ALIGNMENT);

    loginBtn = new JButton();
    loginBtn.setText("Login");
    loginBtn.setBackground(new Color(0x155dfc));
    loginBtn.setForeground(Color.WHITE);
    loginBtn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
    loginBtnContainer = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    loginBtnContainer.setBackground(new Color(0xf1f5f9));
    loginBtnContainer.setAlignmentX(JPanel.LEFT_ALIGNMENT);
    loginBtnContainer.add(loginBtn);

    form = new JPanel();
    form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
    form.setBorder(BorderFactory.createEmptyBorder(15, 30, 15, 30));
    form.setBackground(new Color(0xf1f5f9));
    form.add(formHeader);
    form.add(Box.createVerticalStrut(10));
    form.add(loginLabelContainer);
    form.add(Box.createVerticalStrut(10));
    form.add(usernameLabel);
    form.add(Box.createVerticalStrut(10));
    form.add(usernameTextfield);
    form.add(Box.createVerticalStrut(10));
    form.add(usernameErrorLabel);
    form.add(Box.createVerticalStrut(10));
    form.add(passwordLabel);
    form.add(Box.createVerticalStrut(10));
    form.add(passwordTextField);
    form.add(Box.createVerticalStrut(10));
    form.add(passwordErrorLabel);
    form.add(Box.createVerticalStrut(10));
    form.add(staySignedInCheckBox);
    form.add(Box.createVerticalStrut(10));
    form.add(loginBtnContainer);
    
    formContainer = new JPanel(new GridBagLayout());
    formContainer.setBackground(new Color(0x0f172b));
    formContainer.add(form);
    
    this.add(imageContainer);
    this.add(formContainer);
  }
}
