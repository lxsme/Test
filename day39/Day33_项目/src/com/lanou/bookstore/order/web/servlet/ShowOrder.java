package com.lanou.bookstore.order.web.servlet;

import com.lanou.bookstore.book.dao.BookDao;
import com.lanou.bookstore.book.domain.Book;
import com.lanou.bookstore.cart.domain.Cartltem;
import com.lanou.bookstore.order.dao.OrderDao;
import com.lanou.bookstore.order.domain.Order;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShowOrder extends Order {
    List<Cartltem> allitems = new ArrayList<Cartltem>();
    private int totalPages;
    private int totalData;
    private int pageCode;
    private int pageSize=10;

    public int getTotalPages() {
        if(totalData%pageSize==0){
            return  totalData/pageSize;
        }else {
            return totalData/pageSize+1;
        }
    }

    public void setTotalData(int totalData) {
        this.totalData = totalData;
    }

    public int getPageCode() {
            return pageCode;
    }

    public void setPageCode(int pageCode) {
        this.pageCode = pageCode;
    }

    public int getPageSize() {
        return pageSize;
    }

    public List<Cartltem> getAllitems() {
        return allitems;
    }

    public void setAllitems(List<Cartltem> allitems) {
        this.allitems = allitems;
}



    public ShowOrder(Order order) throws SQLException {


        List<Object[]> objects = new OrderDao().queryBookByOid(order.getOid());

        BookDao bookDao = new BookDao();
        for (Object[] object : objects) {
            Book book = bookDao.findByBid(Integer.parseInt(object[1].toString()));
            Cartltem Cartltem = new Cartltem(book,Integer.parseInt(object[0].toString()));
            allitems.add(Cartltem);

        }
        this.setOid(order.getOid());
        this.setOrdertime(order.getOrdertime());
        this.setTotal(order.getTotal());
        this.setState(order.getState());
        this.setAdminState(order.getAdminState());

    }
}

