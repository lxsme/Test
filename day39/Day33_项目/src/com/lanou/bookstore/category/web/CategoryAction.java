package com.lanou.bookstore.category.web;

import com.lanou.bookstore.category.domain.Category;
import com.lanou.bookstore.category.service.AdminCategoryService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class CategoryAction extends ActionSupport implements ServletRequestAware {
    private HttpServletRequest request;
    private AdminCategoryService service = new AdminCategoryService();
    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request=httpServletRequest;
    }

    public String show() throws SQLException {
        List<Category> categories = service.showAll();
        HttpSession session = request.getSession();
        session.setAttribute("categories",categories);

        return SUCCESS;
    }


}
