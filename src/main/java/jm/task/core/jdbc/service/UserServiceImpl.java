package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDao userSer = new UserDaoJDBCImpl();

    @Override
    public void createUsersTable() {

        userSer.createUsersTable();
    }

    @Override
    public void dropUsersTable() {
        userSer.dropUsersTable();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        userSer.saveUser(name, lastName, age);
        System.out.println("User с именем — " + name + " добавлен в базу данных");
    }

    @Override
    public void removeUserById(long id) {
        userSer.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userSer.getAllUsers();
    }

    @Override
    public void cleanUsersTable() {
        userSer.cleanUsersTable();
    }
}
