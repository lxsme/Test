package com.lanou.bookstore.category.service;

import com.lanou.bookstore.category.dao.CategoryDao;
import com.lanou.bookstore.category.domain.Category;
import com.lanou.bookstore.category.service.exception.CategoryExistException;
import com.lanou.bookstore.category.service.exception.CategoryFailAddException;
import com.lanou.bookstore.category.service.exception.CategoryFailDeleteException;
import com.lanou.bookstore.category.service.exception.CategoryNotExistException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class AdminCategoryService {
    CategoryDao categoryDao = new CategoryDao();
    public  List<Category> findAll() throws SQLException {
        List<Category> categories = categoryDao.queryAll();
      return categories;
    }

    public String add(int cid,String cname) throws SQLException, CategoryExistException, CategoryFailAddException {

        if(cid==0){
            cid = categoryDao.maxCid()+1;
        }

        Category category = categoryDao.queryByCname(cname);
        if (category !=null){
            throw new CategoryExistException();

        }

        categoryDao.add(cid,cname);
        String cname1 = categoryDao.queryCnameByCid(cid);
        if (cname1 ==null){
            throw new CategoryFailAddException();
        }

        return "success";

    }

    public String delete(int cid) throws SQLException, CategoryNotExistException, CategoryFailDeleteException {
        String s = categoryDao.queryCnameByCid(cid);
        if (s==null){
            throw new CategoryNotExistException();

        }

       categoryDao.deleteByCid(cid);
        String s1 = categoryDao.queryCnameByCid(cid);
        if (s1 !=null){
            throw new CategoryFailDeleteException();
        }

        return "success";
    }

    public List<Category> showAll() throws SQLException {
        List<Category> categories = categoryDao.queryAll();
   return categories;
    }




}
