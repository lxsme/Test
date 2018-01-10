package homework.service;

import homework.bean.User;
import homework.dao.UserDao;
import homework.service.exception.*;

import java.sql.SQLException;
import java.util.regex.Pattern;

public class UserService {
    private UserDao userDao = new UserDao();
    public User login(User fromU) throws SQLException, InvalidUsernameException,PasswordNotMatchedException {
        User fromDb = userDao.queryBeanByUname(fromU.getUname());
        if(fromDb == null){
                throw new InvalidUsernameException();
        }
        if (!fromDb.getPassword().equals(fromU.getPassword())){
            throw new PasswordNotMatchedException();
        }
        return fromDb;
    }


    public String registerByMail(User fromU) throws SQLException, RegisterException {
        User formDb = userDao.queryBeanByUname(fromU.getUname());
        if (formDb !=null){
            throw new UserExistException();
        }
        boolean isMatched;

        if (!(isMatched = Pattern.matches("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$",fromU.getUname()))){
            throw new IsNotMailException();
        }
        userDao.update(fromU);
        return "success";
    }






}
