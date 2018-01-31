package com.github.KKimishima.dokoTsubu.model;

import java.io.Serializable;

public class InitTest implements Serializable{
  public Integer initTest;
  public InitTest(){
    this.initTest = 0;
  }

  public Integer getInitTest() {
    return initTest;
  }

  public void setInitTest(Integer initTest) {
    this.initTest = initTest;
  }
}
