package com.github.KKimishima.dokoTsubuDB.servlet.dokoTsubuDB;

import com.github.KKimishima.dokoTsubuDB.model.bean.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/dokoTsubuDB/Logoff")
public class Logoff extends HttpServlet{
  private static final Long serialVersion = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HttpSession httpSession = req.getSession();
    httpSession.invalidate();

    RequestDispatcher rd = req.getRequestDispatcher(
        "/jsp/TsubuDBIndex.jsp"
    );
    rd.forward(req,resp);
  }
}
