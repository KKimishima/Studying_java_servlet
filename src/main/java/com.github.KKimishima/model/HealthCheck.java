package com.github.KKimishima.model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/HealthCheck")
public class HealthCheck extends HttpServlet{
  private static final long serialVersion = 1L;

  // ゲットリクエスト
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // フォワード
    RequestDispatcher reqd = req.getRequestDispatcher(
        "/WEB-INF/jsp/healthCheck.jsp"
    );
    reqd.forward(req,resp);
  }

  // ポストリクエス
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //Health health = (Health) req.getAttribute("healt");
    // リクエスのパース
    String weight = req.getParameter("weight");
    String height = req.getParameter("height");

    // プロパティの設定
    Health health = new Health();
    health.setHeight(Double.parseDouble(height));
    health.setWeight(Double.parseDouble(weight));

    // 診断結果を実行して設定
    HealthCheckLogic healthCheckLogic = new HealthCheckLogic();
    healthCheckLogic.execute(health);

    //リクエススコープに保存
    req.setAttribute("health",health);

    //フォワード
    RequestDispatcher reqd = req.getRequestDispatcher(
        "/WEB-INF/jsp/healthCheckResult.jsp"
    );
    reqd.forward(req,resp);
  }
}
