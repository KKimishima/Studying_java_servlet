package com.github.KKimishima.dokoTsubuDB.model.DAO;

import java.sql.*;

public class UserDAO {
  private final String jdbcURL = "jdbc:h2:file:/Volumes/data/Repo/Studying_java_servlet/src/main/resources/db/db";
  private final String dbUser = "sa";
  private final String dbPass = "";

  public Boolean execute(String name,String pass){
    Connection con = null;
    try{
      con = DriverManager.getConnection(jdbcURL,dbUser,dbPass);
      PreparedStatement ps = con.prepareStatement(
          "select * from USER where NAME = ? and PASS = ?;"
      );
      ps.setString(1,name);
      ps.setString(2,pass);

      ResultSet rs = ps.executeQuery();

      if(rs.next()){
        return true;
      }
      return false;
    }catch (SQLException e){
      e.printStackTrace();
      return false;
    }finally {
      if (con == null){
        try {
          con.close();
        }catch (SQLException e){
          e.printStackTrace();
        }
      }
    }
  }
}
