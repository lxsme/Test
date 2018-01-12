package com.lanou.bookstore.order.service;

import com.lanou.bookstore.book.dao.BookDao;
import com.lanou.bookstore.book.domain.Book;
import com.lanou.bookstore.cart.domain.Cartltem;
import com.lanou.bookstore.order.dao.OrderDao;
import com.lanou.bookstore.order.domain.Order;
import com.lanou.bookstore.order.domain.Orderltem;
import com.lanou.bookstore.order.service.exception.AddressNotChangeException;
import com.lanou.bookstore.order.service.exception.StateErrorException;
import com.lanou.bookstore.order.service.web.servlet.ShowOrder;
import com.lanou.bookstore.user.domain.User;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class OrderService {
    OrderDao orderDao = new OrderDao();
    BookDao bookDao = new BookDao();


    public Order add(String address, List<Cartltem> cart, User user,int orderCount,double sumMoney) throws SQLException {
        Order order = new Order();
        Orderltem orderltem = new Orderltem();
//        orderltem.setIid(lid);

        long l = System.currentTimeMillis();
        Timestamp ts = new Timestamp(l);

        String string = user.getCode();
        String substring = string.substring(16);
       String oid =substring+l;
//        DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//        Timestamp format = sdf.format(ts);

        order.setOid(oid);
        order.setOrdertime(ts);
        order.setState(0);
        order.setUid(user.getCode());
        order.setAddress(address);
        order.setTotal(sumMoney);
        orderDao.insertOrder(order);



        int count=0;
        int bid=0;
        for (Cartltem cartltem : cart) {
            List<Orderltem> orders = orderDao.queryAll();
            int size = orders.size();

            count = cartltem.getCount();
            bid = cartltem.getBook().getBid();
            orderltem.setBid(bid);
            orderltem.setCount(count);
            orderltem.setIid(size+1);
            orderltem.setOid(oid);

            orderDao.insert(orderltem);
        }

        return order;
    }





    public List<Order> findByUid(String uid) throws SQLException {

        List<Order> orders = orderDao.queryByUid(uid);

        return orders;
    }
    public List<Orderltem> findAllOrder() throws SQLException {

        List<Orderltem> orderltems = orderDao.queryAll();
        return orderltems;
    }


public  List<Cartltem> load(String oid) throws SQLException {

        List<Object[]> list = orderDao.queryBookByOid(oid);
        int bid =0;
        int count=0;
        Cartltem cartltem=null;
        List<Cartltem> cart = new ArrayList<>();
        for (Object[] o : list) {
            bid=Integer.parseInt(o[1].toString());
            count = Integer.parseInt(o[0].toString());
            Book byBid = bookDao.findByBid(bid);
            cartltem  = new Cartltem(byBid,count);
            cart.add(cartltem);
        }

    return cart;

}

public Order queryOrderByOid(String oid) throws SQLException {
    Order order = orderDao.queryOrderByOid(oid);
    return order;
}

    public String updateOrder(String address,String oid) throws SQLException, StateErrorException, AddressNotChangeException {
        orderDao.updateState(1,oid);
        orderDao.updateAddress(address,oid);
        int state = orderDao.getState(oid);
        String address1 = orderDao.getAddress(oid);
        if (state !=1){
            throw new StateErrorException();
        }else {
           if (!(address.equals(address1))){
            throw new AddressNotChangeException();
           }
        }
        return "success";

    }

    public String confirm(String oid) throws SQLException, StateErrorException {

        orderDao.updateState(2,oid);
        int state = orderDao.getState(oid);
        if (state==2){
            return "success";
        }else {
            throw new StateErrorException();
        }

    }


    public List<ShowOrder> showOrder(int state) throws SQLException {

        List<Order> orders=null;
        if (state==8){
            orders = orderDao.queryAllOrder();
        }else {
            orders = orderDao.queryByState(state);
        }

        List<ShowOrder> showOrders = new ArrayList<>();
        List<Order> orderss=new ArrayList<>();
        int j =0;
        for (int i =orders.size()-1; i >=0 ; i--) {
            orderss.add(j,orders.get(i));
            j++;
        }

        for (Order order : orderss) {
            showOrders.add(new ShowOrder(order));
        }
        return showOrders;

    }






}
