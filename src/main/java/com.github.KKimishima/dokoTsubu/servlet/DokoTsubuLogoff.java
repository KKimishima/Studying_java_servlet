package com.github.KKimishima.dokoTsubu.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/DokoTsubuLogoff")
public class DokoTsubuLogoff extends HttpServlet{
  private static final long serialVersion = 1L;
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // セッションスコープ削除
    HttpSession httpSession = req.getSession();
    httpSession.invalidate();

    // ログイン画面にリダイレクト
    RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/logout.jsp");
    rd.forward(req,resp);
  }
}
