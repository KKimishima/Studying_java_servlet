package com.github.KKimishima.dokoTsubuDB.model;

import java.io.Serializable;

public class Tubuyaki implements Serializable{
  private int id;
  private String tex;
  private String userName;

  public Tubuyaki(){}
  public Tubuyaki(int id,String tex,String userName){
    this.id = id;
    this.tex = tex;
    this.userName = userName;
  }

  public String getUserName() {
    return userName;
  }

  public String getTex() {
    return tex;
  }

  public int getId() {
    return id;
  }
}
