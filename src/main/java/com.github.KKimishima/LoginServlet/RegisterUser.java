package com.github.KKimishima.LoginServlet;

import com.github.KKimishima.LoginModel.RegisterUserLogic;
import com.github.KKimishima.LoginModel.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet{
  private static final long serialVersion = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // フォワード先
    String forwardPath = null;

    // サーブレットサーブレットの動作を決定するantionの値を
    //リクエスリクエスパラメータから取得
    String action = req.getParameter("action");

    // 登録開始のリクエストリされた時の時の処理
    if (action == null){
      forwardPath = "/WEB-INF/jsp/registerFrom.jsp";

      // 登録画面から登録実行をリクエストされた処理
    }else if (action.equals("done")){
      // セッションスコープに保存された登録ユーザを取得
      HttpSession httpSession = req.getSession();
      User register = (User) httpSession.getAttribute("registerUser");

      // 登録処理の呼び出し
      RegisterUserLogic registerUserLogic = new RegisterUserLogic();
      registerUserLogic.execute(register);

      // 不要ななったセッションスコープを削除
      httpSession.removeAttribute("registerUser");

      // 登録登録後のフォワード
      forwardPath = "/WEB-INF/jsp/registerDone.jsp";
    }

    // 設定されたされたフォワード先へ
    RequestDispatcher reqd = req.getRequestDispatcher(
       forwardPath
    );
    reqd.forward(req,resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // リクエストパワメーの取得
    req.setCharacterEncoding("UTF-8");
    String id = req.getParameter("id");
    String name = req.getParameter("name");
    String pass = req.getParameter("pass");

    // 登録するユーザ情報の設定
    User registerUser = new User(id,name,pass);
    HttpSession httpSession = req.getSession();
    httpSession.setAttribute("registerUser",registerUser);

    // フォワード
    RequestDispatcher reqd = req.getRequestDispatcher(
        "/WEB-INF/jsp/registerConfirm.jsp"
    );
    reqd.forward(req,resp);
  }
}
