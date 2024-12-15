package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserDaoJDBCImpl extends Util implements UserDao {

    private Connection connection;

    {
        try {
            connection = getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public UserDaoJDBCImpl() {
    }

    Scanner scanner = new Scanner(System.in);

    public void createUsersTable() {
        String createTable = "CREATE TABLE IF NOT EXISTS users (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(45), lastname VARCHAR(45), age INT)";

        try (PreparedStatement ps = connection.prepareStatement(createTable)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        /*
        try {
            ps = connection.prepareStatement(createTable);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        */

    }

    public void dropUsersTable() {

        String dropTable = "DROP TABLE IF EXISTS users";
        try (Statement st = connection.createStatement()) {
            st.executeUpdate(dropTable);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        /*
        try {
            st = connection.createStatement();
            st.executeUpdate(dropTable);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

         */

    }

    public void saveUser(String name, String lastName, byte age) {

        String sql = "INSERT users (name, lastname, age) VALUES ('" + name + "', '" + lastName + "', " + age + ")";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        /*
        try {
            ps = connection.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

         */
    }

    public void removeUserById(long id) {


        String sqlDelete = "DELETE FROM users WHERE id = " + id;
        try (PreparedStatement ps = connection.prepareStatement(sqlDelete)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
            /*
        try {
            ps = connection.prepareStatement(sqlDelete);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

             */
    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();

        String selectUsers = "SELECT * FROM users";
        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(selectUsers);
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setName(rs.getString("name"));
                user.setLastName(rs.getString("lastname"));
                user.setAge(rs.getByte("age"));
                userList.add(user);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        /*
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(selectUsers);
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setName(rs.getString("name"));
                user.setLastName(rs.getString("lastname"));
                user.setAge(rs.getByte("age"));
                userList.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

         */
        return userList;
    }

    public void cleanUsersTable() {
        String sqlDelete = "DELETE FROM users";
        try (PreparedStatement ps = connection.prepareStatement(sqlDelete)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        /*
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sqlDelete);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

         */
    }
}
