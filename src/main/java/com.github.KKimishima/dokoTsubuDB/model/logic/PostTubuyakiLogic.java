package com.github.KKimishima.dokoTsubuDB.model.logic;

import com.github.KKimishima.dokoTsubuDB.model.DAO.TsubuyakiDAO;
import com.github.KKimishima.dokoTsubuDB.model.bean.Tubuyaki;

public class PostTubuyakiLogic {
  public Boolean execute(Tubuyaki tsubuyaki){
    TsubuyakiDAO tsubuyakiDAO = new TsubuyakiDAO();
    return tsubuyakiDAO.create(tsubuyaki);
  }
}
