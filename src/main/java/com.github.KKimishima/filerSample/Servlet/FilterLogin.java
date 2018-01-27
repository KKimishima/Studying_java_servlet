package com.github.KKimishima.filerSample.Servlet;


import com.github.KKimishima.filerSample.Model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/FilterLogin")
public class FilterLogin extends HttpServlet{
  private static final Long serialVarsion = 1l;

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // リクエストの取得
    req.setCharacterEncoding("UTF-8");
    String text = req.getParameter("text");


    if(text != null && text.length() != 0) {
      HttpSession session = req.getSession();
      //User user = (User)session.setAttribute("login");
    }
  }
}
