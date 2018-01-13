package com.github.KKimishima;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * servletを使う場合は、このクラスを作らなければならない
 */
@WebServlet("/Hello")
public class Hello extends HttpServlet{

  private static final long seriaVersionUID = 1L;
  /**
   * getリクエストをチャッチするメソッド
   * @param req クライアントからのリクエスト
   * @param resp サーバからのレスポンス
   * @throws ServletException
   * @throws IOException
   */
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // htmlを出力してみる
    // レスポンスの種類を指定
    resp.setContentType("text/html; charset=UTF-8");
    // レスポンスをもじれ表示させる
    PrintWriter out = resp.getWriter();
    out.println("<html>");
    out.println("<head>");
    out.println("<title>hell表示ページ</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("Hello!!!!!!");
    out.println("</body>");
    out.println("</html>");

  }
}
