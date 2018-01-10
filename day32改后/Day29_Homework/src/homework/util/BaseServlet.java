package homework.util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String methodName = req.getParameter("method");

        Class<? extends BaseServlet> service = this.getClass();
        Method method=null;
        try {
            method = service.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("找不到方法名为:"+methodName+"的方法");
        }

        try {
            String path = (String) method.invoke(this,req,resp);
            String[] paths = path.split(":");
            if(paths[0].equals("f")){
                resp.sendRedirect(req.getContextPath()+paths[1]);
            }

            if (paths[0].equals("r")){
                req.getRequestDispatcher(paths[1]).forward(req,resp);
            }
            if (paths[0].equals("i")){
                req.getRequestDispatcher(paths[1]).include(req,resp);
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
