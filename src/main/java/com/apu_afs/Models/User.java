package com.apu_afs.Models;

import java.util.*;
import java.util.stream.Collectors;

public abstract class User {
  String username;
  String password;
  String firstName;
  String lastName;
  char gender;
  String email;
  String phoneNumber;
  String role;

  public static final String filePath = "data/users.txt";

  public User(ArrayList<String> props) {
    this.username = props.get(0);
    this.password = props.get(1);
    this.firstName = props.get(2);
    this.lastName = props.get(3);
    this.gender = props.get(4).charAt(0);
    this.email = props.get(5);
    this.phoneNumber = props.get(6);
    this.role = props.get(7);
  }

  public static User userAuth(String username, String password) {
    ArrayList<String> usersData = Data.fetch(User.filePath);

    for (String user : usersData) {
      ArrayList<String> props = new ArrayList<String>(Arrays.asList(user.split(", ")));

      if (props.get(0).equals(username) && props.get(1).equals(password)) {

        if (props.get(7).equals("admin")) {
          return new Admin(props);
        } else if (props.get(7).equals("academic")) {
          return new AcademicLeader(props);
        } else if (props.get(7).equals("lecturer")) {
          return new Lecturer(props);
        } else {
          return new Student(props);
        }
      }
    }

    return null;
  }

  public static User getUserByUsername(String username) {
    ArrayList<String> usersData = Data.fetch(User.filePath);

    for (String user : usersData) {
      ArrayList<String> props = new ArrayList<String>(Arrays.asList(user.split(", ")));
      
      if (props.get(0).equals(username)) {
        if (props.get(7).equals("admin")) {
          return new Admin(props);
        } else if (props.get(7).equals("academic")) {
          return new AcademicLeader(props);
        } else if (props.get(7).equals("lecturer")) {
          return new Lecturer(props);
        } else {
          return new Student(props);
        }
      }
    }

    return null;
  }

  public String getUsername() {
    return this.username;
  }
  
  public String getPassword() {
    return this.password;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public char getGender() {
    return this.gender;
  }

  public String getEmail() {
    return this.email;
  }

  public String getPhoneNumber() {
    return this.phoneNumber;
  }

  public String getRole() {
    return this.role;
  }

  public void setUsername(String username) {
    this.username = username;
    updateUser();
  }

  public void setPassword(String password) {
    this.password = password;
    updateUser();
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
    updateUser();
  }
  
  public void setLastName(String lastName) {
    this.lastName = lastName;
    updateUser();
  }

  public void setGender(char gender) {
    this.gender = gender;
    updateUser();
  }

  public void setEmail(String email) {
    this.email = email;
    updateUser();
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
    updateUser();
  }

  public void setRole(String role) {
    this.role = role;
    updateUser();
  }

  public void updateUser() {
    ArrayList<String> usersData = Data.fetch(User.filePath);
    ArrayList<String> updatedUsersData = usersData.stream().filter((userRow) -> {
      ArrayList<String> props = new ArrayList<String>(Arrays.asList(userRow.split(", ")));
      return !props.get(0).equals(this.username);
    }).collect(Collectors.toCollection(ArrayList::new));

    ArrayList<String> updatedUserProps = new ArrayList<String>();
    updatedUserProps.add(this.username);
    updatedUserProps.add(this.password);
    updatedUserProps.add(this.firstName);
    updatedUserProps.add(this.lastName);
    updatedUserProps.add(String.valueOf(this.gender));
    updatedUserProps.add(this.email);
    updatedUserProps.add(this.phoneNumber);
    updatedUserProps.add(this.role);

    updatedUsersData.add(String.join(", ", updatedUserProps));
    Data.save(User.filePath, String.join("\n", updatedUsersData));
  }
}
