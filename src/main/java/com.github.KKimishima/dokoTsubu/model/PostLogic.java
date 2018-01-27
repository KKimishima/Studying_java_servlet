package com.github.KKimishima.dokoTsubu.model;

import java.util.List;

public class PostLogic {
  public void exexcute(Tsubu tsubu, List<Tsubu> listTsubu){
    listTsubu.add(0,tsubu); //一番最初に挿入して移行は最後に追加
  }
}
