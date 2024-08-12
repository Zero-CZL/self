package cn.nothsea.fitter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class EncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //处理中文乱码
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //过滤非法请求
        //放行合法请求
        HttpSession session = request.getSession();
        Object user=session.getAttribute("user");
        if(user!=null||request.getRequestURI().contains("login")||request.getRequestURI().contains("register")||
                request.getRequestURI().contains("check")||request.getRequestURI().contains("findCity")){
            //选择放行
            filterChain.doFilter(request, response);
        }else {
            request.setAttribute("msg2","请先登录");
            request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
        }

    }

    @Override
    public void destroy() {

    }
}
