package com.apu_afs.Models;

import java.util.ArrayList;
import java.util.List;

public class IDIncrement {
  private Integer userID;
  private Integer adminID;
  private Integer academicID;
  private Integer lecturerID;
  private Integer studentID;

  private static final String filePath = "data/idIncrements.txt";

  IDIncrement() {
    List<String> incrementIds = Data.fetch(filePath);

    this.userID = Integer.parseInt(incrementIds.get(0).trim());
    this.adminID = Integer.parseInt(incrementIds.get(1).trim());
    this.academicID = Integer.parseInt(incrementIds.get(2).trim());
    this.lecturerID = Integer.parseInt(incrementIds.get(3).trim());
    this.studentID = Integer.parseInt(incrementIds.get(4).trim());
  }

  public Integer getUserID() {
    this.userID++;
    saveIDIncrement();
    return this.userID;
  }

  public Integer getAdminID() {
    this.adminID++;
    saveIDIncrement();
    return this.adminID;
  }

  public Integer getAcademicID() {
    this.academicID++;
    saveIDIncrement();
    return this.academicID;
  }

  public Integer getLecturerID() {
    this.lecturerID++;
    saveIDIncrement();
    return this.lecturerID;
  }

  public Integer getStudentID() {
    this.studentID++;
    saveIDIncrement();
    return this.studentID;
  }

  private void saveIDIncrement() {
    List<String> rows = new ArrayList<>();
    rows.add(String.valueOf(this.userID));
    rows.add(String.valueOf(this.adminID));
    rows.add(String.valueOf(this.academicID));
    rows.add(String.valueOf(this.lecturerID));
    rows.add(String.valueOf(this.studentID));

    Data.save(filePath, String.join("\n", rows));
  }
}
