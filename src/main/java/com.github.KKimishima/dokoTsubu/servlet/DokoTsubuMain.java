package com.github.KKimishima.dokoTsubu.servlet;

import com.github.KKimishima.dokoTsubu.model.Tsubu;
import com.github.KKimishima.dokoTsubu.model.User;

import javax.jws.WebService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/DokoTsubuMain")
public class DokoTsubuMain extends HttpServlet{
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // つぶやきリストを取得
    ServletContext app = this.getServletContext();
    List<Tsubu> tsubuList = (List<Tsubu>)app.getAttribute("tsubu");

    // 取得できなかった場合、新規作成して保存
    if (tsubuList == null){
      tsubuList = new ArrayList<Tsubu>();
      app.setAttribute("tsubu",tsubuList);
    }

    // ログインチェック
    HttpSession httpSession = req.getSession();
    User user = (User)httpSession.getAttribute("user");

    if (user == null){
      resp.sendRedirect("/StudyingServlet/jsp/TsubuIndex.jsp");
    }else{
      RequestDispatcher rd = req.getRequestDispatcher(
          "/WEB-INF/jsp/DokoTsubuMain.jsp"
      );
      rd.forward(req,resp);
    }
  }
}
