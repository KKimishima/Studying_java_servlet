package com.github.KKimishima.dokoTsubuDB.filter;

import com.github.KKimishima.dokoTsubuDB.model.bean.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/dokoTsubuDB/MainPage")
public class LoginFilter implements Filter{
  @Override
  public void init(FilterConfig filterConfig) {

  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
  throws IOException,ServletException{

    HttpSession session = ((HttpServletRequest)request).getSession();
    User user = (User)session.getAttribute("user");

    if (user == null){
      session.removeAttribute("user");
      ((HttpServletResponse)response).sendRedirect("/StudyingServlet/jsp/TsubuDBIndex.jsp");
      System.out.println("ログインフィルタテスト");
      return;
    }

    chain.doFilter(request,response);
  }

  @Override
  public void destroy() {

  }
}
