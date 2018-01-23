package com.github.KKimishima.dokoTsubu.model;

import java.io.Serializable;

public class Tsubu implements Serializable{
  private String userName;
  private String tex;
  public Tsubu(){}
  public Tsubu(String userName,String tex){
    this.userName = userName;
    this.tex = tex;
  }

  public String getTex() {
    return tex;
  }

  public String getUserName() {
    return userName;
  }
}
