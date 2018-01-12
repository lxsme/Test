package com.lanou.bookstore.order.service.web.servlet;

import com.lanou.bookstore.book.dao.BookDao;
import com.lanou.bookstore.book.domain.Book;
import com.lanou.bookstore.cart.domain.Cartltem;
import com.lanou.bookstore.order.dao.OrderDao;
import com.lanou.bookstore.order.domain.Order;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShowOrder extends Order
{
    public List<Cartltem> getAllitems() {
        return allitems;
    }

    public void setAllitems(List<Cartltem> allitems) {
        this.allitems = allitems;
}

  List<Cartltem> allitems = new ArrayList<Cartltem>();

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
    }
}

