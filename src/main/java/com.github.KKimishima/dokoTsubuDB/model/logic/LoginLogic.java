package com.github.KKimishima.dokoTsubuDB.model.logic;

import com.github.KKimishima.dokoTsubuDB.model.DAO.UserDAO;
import com.github.KKimishima.dokoTsubuDB.model.bean.User;

public class LoginLogic {
  public Boolean execut(User user){
    UserDAO userDAO = new UserDAO();
    return userDAO.execute(user.getUserName(),user.getPass());
  }
}
