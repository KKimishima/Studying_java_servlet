package com.github.KKimishima.dokoTsubuDB.servlet.dokoTsubuDB;

import com.github.KKimishima.dokoTsubuDB.model.bean.User;
import com.github.KKimishima.dokoTsubuDB.model.logic.LoginLogic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/dokoTsubuDB/Login")
public class Login extends HttpServlet{
  private static final long serialVersion =1l;

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 受け取りパラメータ
    String name = req.getParameter("name");
    String pass = req.getParameter("pass");

    // ユーザ情報保持
    User user = new User(name,pass);

    // ログイン
    LoginLogic loginLogic = new LoginLogic();
    if (loginLogic.execut(user)){
      // セッションスコープに設定
      HttpSession httpSession = req.getSession();
      httpSession.setAttribute("user",user);
    }else {
      // セッションスコープ廃棄
      HttpSession httpSession = req.getSession();
      httpSession.removeAttribute("user");
    }

    RequestDispatcher rd = req.getRequestDispatcher(
        "/WEB-INF/jsp/DokotsubDBLoginResult.jsp"
    );
    rd.forward(req,resp);

  }
}
