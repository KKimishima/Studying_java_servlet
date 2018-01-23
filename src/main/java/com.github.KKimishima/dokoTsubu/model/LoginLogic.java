package com.github.KKimishima.dokoTsubu.model;

import com.github.KKimishima.dokoTsubu.model.User;

public class LoginLogic {
  public Boolean extcute(User user){
    if (user.getPass().equals("1234")){
      return true;
    }
    return false;
  }
}
