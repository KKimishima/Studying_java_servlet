package com.github.KKimishima.dokoTsubu.servlet;

import com.github.KKimishima.dokoTsubu.model.PostLogic;
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

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // リクエスト値の取得
    req.setCharacterEncoding("UTF-8");
    String text = req.getParameter("text");

    System.out.print(text);

    // 入力値のチェック
    if(text != null && text.length() != 0){
      // アプリケーションスコープに保存されているリストを取得
      ServletContext app = req.getServletContext();
      List<Tsubu> tsubuListt = (List<Tsubu>) app.getAttribute("tsubu");

      // セッションスコープに保存されているユーザ情報を取得
      HttpSession session = req.getSession();
      User user = (User) session.getAttribute("user");

      // つぶやきをリストに追加
      Tsubu tsubu = new Tsubu(user.getName(),text);
      PostLogic postLogic = new PostLogic();
      postLogic.exexcute(tsubu,tsubuListt);
    }else {
      req.setAttribute("errorMs","つぶやきを入力してください");
    }
    //メイン画面にフォワード
    RequestDispatcher rd = req.getRequestDispatcher(
      "/WEB-INF/jsp/DokoTsubuMain.jsp"
    );
    rd.forward(req,resp);
  }
}
