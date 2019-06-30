package com.grepiu.dbs.process.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "user")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long no;
  private String name;
  private String gender;
  private int age;
  private String etc;

  public Long getNo() {
    return no;
  }

  public void setNo(Long no) {
    this.no = no;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getEtc() {
    return etc;
  }

  public void setEtc(String etc) {
    this.etc = etc;
  }
}
