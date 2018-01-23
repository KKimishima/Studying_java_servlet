package com.github.KKimishima.dokoTsubu.servlet;

import com.github.KKimishima.dokoTsubu.model.LoginLogic;
import com.github.KKimishima.dokoTsubu.model.User;
import com.sun.net.httpserver.HttpServer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/dokoTsubLogin")
public class dokoTsubLogin extends HttpServlet{
  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 受け取パラメータ
    req.setCharacterEncoding("UTF-8");
    String name = req.getParameter("name");
    String pass = req.getParameter("pass");

    // ユーザ情報保存する
    User user = new User(name,pass);

    // ログイン
    LoginLogic loginLogic = new LoginLogic();
    if (loginLogic.extcute(user)){
      HttpSession httpSession = req.getSession();
      httpSession.setAttribute("user",user);
    }
    RequestDispatcher rd = req.getRequestDispatcher(
        "/WEB-INF/jsp/TubuResult.jsp"
    );
    rd.forward(req,resp);

  }
}
