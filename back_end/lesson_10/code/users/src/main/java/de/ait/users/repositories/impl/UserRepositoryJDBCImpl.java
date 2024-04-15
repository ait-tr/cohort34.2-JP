package de.ait.users.repositories.impl;

import de.ait.users.model.User;
import de.ait.users.repositories.UserRepository;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryJDBCImpl implements UserRepository {
    // 1. Connection
    // 2. SQL Statement
    // 3. Result Set

    public static final String ID="id";
    public static final String NAME = "name";
    public static final String PASSWORD = "password";
    public static final String EMAIL = "email";
    public static final String AGE ="age";
    private String dbDriver = "com.mysql.cj.jdbc.Driver";
    private String dbAddress = "jdbc:mysql://localhost:3306/";
    private String dbName = "user_app";
    private String dbUserName = "root";
    private String dbPassword = "admin";

    // jdbc:mysql://localhost:3306/user_app/?user=root&password=admin
    private Connection getConnection(){

        String connectionStr = String.format("%s%s?user=%s&password=%s",
                dbAddress,dbName,dbUserName, dbPassword);
        System.out.println(connectionStr);
        try {

            Class.forName(dbDriver);
            return DriverManager.getConnection(connectionStr);

        } catch (SQLException e) {
            System.out.println("Connection error");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver DB not found");
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<User> findAll() {
        try(
                Connection connection = getConnection();
            ){

            String sql = "SELECT * FROM t_user";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            List<User> users = new ArrayList<>();
            while (resultSet.next()){
                //long id = resultSet.getLong(1);
                long id = resultSet.getLong(ID);
                String name = resultSet.getString(NAME);
                String email = resultSet.getString(EMAIL);
                String password = resultSet.getString(PASSWORD);
                int age = resultSet.getInt(AGE);

                User user = new User(id, name, password,email, age );
                users.add(user);

            }
            return users;

        } catch (Exception ex){
            throw new RuntimeException();
        }

    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
