package homework.web;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "AllFilter",urlPatterns = {"/index.jsp","/showBook.jsp"})
public class AllFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        Object user = request.getSession().getAttribute("user");
        if(user != null ) {
            chain.doFilter(req, resp);
            return;
        }

        response.sendRedirect(request.getContextPath()+"/123_login.jsp");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
