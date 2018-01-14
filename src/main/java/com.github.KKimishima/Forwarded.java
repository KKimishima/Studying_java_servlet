package com.github.KKimishima;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Forwarded")
public class Forwarded extends HttpServlet{
  private static final long serialVersion = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    RequestDispatcher rewd = req.getRequestDispatcher("/WEB-INF/jsp/forwarded.jsp");
    rewd.forward(req,resp);
  }
}
