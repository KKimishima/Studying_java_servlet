package com.github.KKimishima.dokoTsubuDB.model.DAO;

import com.github.KKimishima.dokoTsubu.model.Tsubu;
import com.github.KKimishima.dokoTsubuDB.model.bean.Tubuyaki;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TsubuyakiDAO {
  private final String jdbcURL = "jdbc:h2:file:/Volumes/data/Repo/Studying_java_servlet/src/main/resources/db/db";
  private final String dbUser = "sa";
  private final String dbPass = "";
  public List<Tubuyaki> FindAll(){
    Connection con = null;
    List<Tubuyaki> tu = new ArrayList<>();
    try{
      con = DriverManager.getConnection(jdbcURL,dbUser,dbPass);

      String sql = "select ID,USERNAME,TSUBUYAKI FROM TSUBUYAKI;";

      PreparedStatement ps = con.prepareStatement(sql);
      ResultSet rs = ps.executeQuery();

      while (rs.next()){
        Tubuyaki tubuyaki = new Tubuyaki(
            rs.getString("USERNAME"),
            rs.getString("TSUBUYAKI")
        );
        tu.add(tubuyaki);
      }
    }catch (SQLException e){
      e.printStackTrace();
      return null;
    }finally {
      if(con != null){
        try{
          con.close();
        }catch (SQLException e){
          e.printStackTrace();
          return null;
        }
      }
    }
    return tu;
  }
  public Boolean create(Tubuyaki tubuyaki){
    Connection con =null;
    try {
      con = DriverManager.getConnection(jdbcURL, dbUser, dbPass);

      String sql = "INSERT INTO TSUBUYAKI(USERNAME,TSUBUYAKI) VALUES(?,?);";

      PreparedStatement ps = con.prepareStatement(sql);
      ps.setString(1,tubuyaki.getUserName());
      ps.setString(2,tubuyaki.getTex());
      int rs = ps.executeUpdate();

      if (rs != 1){
        return false;
      }
    }catch (SQLException e){
      e.printStackTrace();
      return false;
    }finally {
      if (con != null){
        try{
          con.close();
        }catch (SQLException e){
          e.printStackTrace();
        }
      }
    }
    return true;
  }
}
