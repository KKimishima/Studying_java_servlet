package com.github.KKimishima.model;

import java.io.Serializable;

/**
 * JavaBeans
 * フォワードを使って使ってサーブレットクラスからjspにファイル連携<br>
 * Serializableを実装してバイト列にして直列化できるようにする
 */
public class Health implements Serializable{
  // フィールドはカプセルかする
  private String bodyType;
  private double height;
  private double weight;
  private double bmi;

  // pulicで引き数のないコンストラクタを実装
  public Health(){}

  //geterとsetterの実装
  public String getBodyType() {
    return bodyType;
  }

  public void setBodyType(String bodyType) {
    this.bodyType = bodyType;
  }

  public double getBmi() {
    return bmi;
  }

  public double getHeight() {
    return height;
  }

  public double getWeight() {
    return weight;
  }

  public void setBmi(double bmi) {
    this.bmi = bmi;
  }

  public void setHeight(double height) {
    this.height = height;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }
}
