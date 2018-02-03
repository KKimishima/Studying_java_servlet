package com.github.KKimishima.dokoTsubuDB.model.logic;

import com.github.KKimishima.dokoTsubuDB.model.DAO.TsubuyakiDAO;
import com.github.KKimishima.dokoTsubuDB.model.bean.Tubuyaki;

import java.util.List;

public class FindAllLogic {
  public List<Tubuyaki> FindAllExecute(){
    TsubuyakiDAO tsDAO = new TsubuyakiDAO();
    return tsDAO.FindAll();
  }
}
