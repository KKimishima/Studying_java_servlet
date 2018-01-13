package com.github.KKimishima;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/FormSample")
public class FormSample extends HttpServlet {
  private static final long serialVirsionUID= 1L;
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // リクエストのの文字コード指定
    req.setCharacterEncoding("UTF-8");

    // リクエストからパラメータ取得
    String name = req.getParameter("name");
    String sex = req.getParameter("sex");
    String epoc = req.getParameter("epoc" );
    System.out.println(epoc);
    String errormsg = "";
    if(name==null||name.length() == 0){
      errormsg += ("名前の入力がありません<br>");
    }
    if (sex == null||sex.length() == 0){
      errormsg +=("性別の性別の入力がありません<br>");
    }else {
      if (sex.equals("0")){
        sex = "男性";
      }else {
        sex = "女性";
      }
    }
    String resultMsg = name +"さんは"+"(" + sex +")の登録が完了しました";
    if (errormsg.length() != 0){
      resultMsg =  errormsg;
    }
    resp.setContentType("text/html; charset=UTF-8");
    PrintWriter out = resp.getWriter();
    out.print("<html>");
    out.print("<head>");
    out.print("<title>フォーム入力結果</title>");
    out.print("</head>");
    out.print("<body>");
    out.print("<h1>登録結果メッセージ</h1>");
    out.print("<p>"+resultMsg+"</p>");
    out.print("<p>エポックタイム"+epoc+"</p>");
    out.print("</body>");
    out.print("</html>");
  }
}
