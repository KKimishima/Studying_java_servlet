package com.github.KKimishima.dokoTsubu.servlet;

import com.github.KKimishima.dokoTsubu.model.*;

import javax.jws.WebService;
import javax.servlet.*;
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
  public void init(ServletConfig config) throws ServletException {
    super.init(config);
    // 訪問回数
    // アプロケーションスコープに保存
    InitTest initTest = new InitTest();
    ServletContext app = config.getServletContext();
    app.setAttribute("initTest", initTest);
    System.out.println("初期化実行");

  }

  @Override
  public void destroy() {
    System.out.println("インスタンスの廃棄");
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // つぶやきリストを取得
    ServletContext app = this.getServletContext();
    List<Tsubu> tsubuList = (List<Tsubu>)app.getAttribute("tsubu");
    InitTest initTest = (InitTest) app.getAttribute("initTest");


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
      InitLogic initLogic = new InitLogic();
      initLogic.execute(initTest);
      app.setAttribute("initTest",initTest);

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
