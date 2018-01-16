package com.lanou.bookstore.category.web;

import com.lanou.bookstore.category.dao.CategoryDao;
import com.lanou.bookstore.category.domain.Category;
import com.lanou.bookstore.category.service.AdminCategoryService;
import com.lanou.bookstore.category.service.exception.CategoryExistException;
import com.lanou.bookstore.category.service.exception.CategoryFailAddException;
import com.lanou.bookstore.category.service.exception.CategoryFailDeleteException;
import com.lanou.bookstore.category.service.exception.CategoryNotExistException;
import com.lanou.bookstore.user.util.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;
@WebServlet(name = "AdminCategoryServlet" ,urlPatterns = "/adminCategory")
public class AdminCategoryServlet extends BaseServlet {
    CategoryDao categoryDao = new CategoryDao();
    AdminCategoryService acs = new AdminCategoryService();
    public String findAll(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        List<Category> categories = categoryDao.queryAll();
        HttpSession session = request.getSession();
        session.setAttribute("categories",categories);

        return "f:/adminjsps/admin/category/list.jsp";
    }


    public String add(HttpServletRequest request,HttpServletResponse response) throws SQLException {
        String cname = request.getParameter("cname");
        HttpSession session = request.getSession();
        try {
            acs.add(0,cname);
        }catch (CategoryExistException e) {
            request.setAttribute("msg",e.getMessage());
            return "r:/adminjsps/admin/category/add.jsp";

        } catch (CategoryFailAddException e) {
            request.setAttribute("msg",e.getMessage());
            return "r:/adminjsps/admin/category/add.jsp";
        }
        request.setAttribute("msg","添加成功");
        return "r:/adminjsps/admin/category/add.jsp";
    }


    public String showDelete(HttpServletRequest request,HttpServletResponse response) throws SQLException {
        int cid = Integer.parseInt(request.getParameter("cid"));
        int chose =Integer.parseInt(request.getParameter("chose")) ;
        String s = categoryDao.queryCnameByCid(cid);
        HttpSession session = request.getSession();

        session.setAttribute("cname",s);
        session.setAttribute("cid",cid);

        if (chose==1){
            return  "f:/adminjsps/admin/category/mod.jsp";
        }
        if (chose==2){
            return  "f:/adminjsps/admin/category/del.jsp";
        }
        return "f:/adminjsps/admin/category/list                   .jsp";
    }


    public String delete(HttpServletRequest request,HttpServletResponse response) throws SQLException {
        int cid = Integer.parseInt(request.getParameter("cid"));
        String cname = categoryDao.queryCnameByCid(cid);

//
//        request.setAttribute("cname",cname);
        try {
            acs.delete(cid);
            request.setAttribute("msg", "删除成功");
            return "r:/adminjsps/admin/category/del.jsp";


        } catch (CategoryNotExistException e) {
            request.setAttribute("msg", e.getMessage());
            return "r:/adminjsps/admin/category/del.jsp";

        } catch (CategoryFailDeleteException e) {
            request.setAttribute("msg", e.getMessage());
            return "r:/adminjsps/admin/category/del.jsp";
        }
    }

    public String mod(HttpServletRequest request,HttpServletResponse response) throws SQLException {

        int cid = Integer.parseInt(request.getParameter("cid"));
        String cname1 = categoryDao.queryCnameByCid(cid);
        String cname = request.getParameter("cname");

        try {
            acs.delete(cid);
        } catch (CategoryNotExistException e) {
            request.setAttribute("msg", e.getMessage());
            return "r:/adminjsps/admin/category/mod.jsp";
        } catch (CategoryFailDeleteException e) {
            request.setAttribute("msg", "修改失败");
            return "r:/adminjsps/admin/category/mod.jsp";
        }

        try {
            acs.add(cid,cname);
        } catch (CategoryExistException e) {


            try {
                acs.add(cid,cname1);
            } catch (CategoryExistException e1) {
                e1.printStackTrace();
            } catch (CategoryFailAddException e1) {
                e1.printStackTrace();
            }

            request.setAttribute("msg", e.getMessage());
            return "r:/adminjsps/admin/category/mod.jsp";
        } catch (CategoryFailAddException e) {
            try {
                acs.add(cid,cname1);
            } catch (CategoryExistException e1) {
                e1.printStackTrace();
            } catch (CategoryFailAddException e1) {
                e1.printStackTrace();
            }
            request.setAttribute("msg", "修改失败");
            return "r:/adminjsps/admin/category/mod.jsp";
        }

        request.setAttribute("msg", "修改成功");
        return "r:/adminjsps/admin/category/mod.jsp";
    }



















}
