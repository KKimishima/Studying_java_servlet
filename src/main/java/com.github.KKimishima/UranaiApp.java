package com.github.KKimishima;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * リクエストが来るととランダムなメッセージを返す
 */
@WebServlet("/UranaiApp")
public class UranaiApp extends HttpServlet{
  private static final long serialVersionUID = 1L;

  /**
   * HashMapに適宜された文字からランダム選択して<br>
   * htmlに文字を埋め込んで返す
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    HashMap<Integer,String> map = new HashMap<>();
    map.put(0,"幸運");
    map.put(1,"普通");
    map.put(2,"不幸");

    Integer index = (int)(Math.random() *3);
    String resultStr = map.get(index);

    resp.setContentType("text/html; charset=UTF-8");
    PrintWriter out = resp.getWriter();
    out.print("<html>");
    out.print("<head>");
    out.print("<title>占いアプリケーション</title>");
    out.print("</head>");
    out.print("<body>");
    out.print("<h1>占い結果</h1>");
    out.print("<p>"+resultStr+"</p>");
    out.print("</body>");
    out.print("</html>");
  }
}
