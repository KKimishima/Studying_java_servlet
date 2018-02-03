package com.github.KKimishima.dokoTsubuDB.servlet.dokoTsubuDB;

import com.github.KKimishima.dokoTsubu.model.PostLogic;
import com.github.KKimishima.dokoTsubuDB.model.bean.Tubuyaki;
import com.github.KKimishima.dokoTsubuDB.model.bean.User;
import com.github.KKimishima.dokoTsubuDB.model.logic.FindAllLogic;
import com.github.KKimishima.dokoTsubuDB.model.logic.PostTubuyakiLogic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/dokoTsubuDB/MainPage")
public class MainPage extends HttpServlet{
  private static final Long serialVersion = 1l;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    FindAllLogic findAllLogic = new FindAllLogic();
    List<Tubuyaki> tubuyakiList = findAllLogic.FindAllExecute();
    req.setAttribute("tubuyakiList",tubuyakiList);

    RequestDispatcher rd = req.getRequestDispatcher(
        "/WEB-INF/jsp/DokotsubuDBMainPage.jsp"
    );
    rd.forward(req,resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String text = req.getParameter("text");

    if (text != null && text.length() != 0){
      HttpSession httpSession = req.getSession();
      User user = (User)httpSession.getAttribute("user");

      Tubuyaki tubuyaki = new Tubuyaki(user.getUserName(),text);
      PostTubuyakiLogic postLogic = new PostTubuyakiLogic();
      postLogic.execute(tubuyaki);
    }else {
      req.setAttribute("errorMs","つぶやきを入力してください");
    }

    FindAllLogic findAllLogic = new FindAllLogic();
    List<Tubuyaki> tubuyakiList = findAllLogic.FindAllExecute();
    req.setAttribute("tubuyakiList",tubuyakiList);

    RequestDispatcher rd = req.getRequestDispatcher(
        "/WEB-INF/jsp/DokotsubuDBMainPage.jsp"
    );
    rd.forward(req,resp);
  }
}
