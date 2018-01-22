package com.github.KKimishima.LoginServlet;

import com.github.KKimishima.model.SiteI;
import com.github.KKimishima.model.SiteILogic;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("IineIServe")
public class IineIServe extends HttpServlet{
    private static final long serialVersion =1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // アプリケーションリクエストのスコープ作製
    ServletContext app = this.getServletContext();
    SiteI siteI = (SiteI)app.getAttribute("siteI");

    // 初回リクエスト時に時に評価初期化
    if(siteI ==null){
      siteI = new SiteI();
    }
    // リクエストパラメータ取得
    req.setCharacterEncoding("UTF-8");
    String action = req.getParameter("aciton");

    // サイトのサイトの評価処理(初回時は実行しない)
    SiteILogic siteILogic = new SiteILogic();
    if (action != null && action.equals("like")){
      siteILogic.like(siteI);
    }else if (action != null && action.equals("dislike")){
      siteILogic.disLike(siteI);
    }


    app.setAttribute("siteI",siteI);

  }
}
