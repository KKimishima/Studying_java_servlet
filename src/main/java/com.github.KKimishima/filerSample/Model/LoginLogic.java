package com.github.KKimishima.filerSample.Model;

public class LoginLogic {
  public Boolean execute(User user){
    if (user.equals("1234")){
      return true;
    }
    return false;
  }
}
