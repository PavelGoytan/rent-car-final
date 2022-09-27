package by.hoitan.rent.dao.impl;

import by.hoitan.rent.bean.RoleUser;
import by.hoitan.rent.bean.StatusUser;
import by.hoitan.rent.bean.User;
import by.hoitan.rent.dao.UserDAO;
import by.hoitan.rent.dao.exception.DAOException;
import by.hoitan.rent.pool.ConnectionManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class SQLUserDAO implements UserDAO {

    private static final Logger LOGGER = LogManager.getLogger(SQLUserDAO.class);

    public static final SQLUserDAO INSTANCE = new SQLUserDAO();

    private static final String SAVE_SQL = """
            INSERT INTO users (first_name, last_name,
            emeil_login, password, phone_user)
            VALUES (?, ?, ?, ?, ?);
            """;


    private SQLUserDAO() {
    }

    public static SQLUserDAO getInstance() {
        return INSTANCE;
    }


//    @Override
//    public void singIn(String user, String password) throws DAOException {
//
//    }

    @Override
    public boolean registration(User user) throws DAOException {

        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE_SQL, RETURN_GENERATED_KEYS)) {
            preparedStatement.setObject(1, user.getFirstName());
            preparedStatement.setObject(2, user.getLastName());
            preparedStatement.setObject(3, user.getEmailLogin());
            preparedStatement.setObject(4, user.getPassword());
//            preparedStatement.setObject(5, user.getRoleUser().ordinal() + 1);
//            preparedStatement.setObject(6, user.getStatusUser().ordinal() + 1);
            preparedStatement.setObject(5, user.getPhoneNumber());

            var executeUpdate = preparedStatement.executeUpdate();

            var generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                user.setId(generatedKeys.getInt(1));
            }
            return executeUpdate > 0;

        } catch (SQLException e) {
            LOGGER.error("Exception while creating User - [{}]", user, e);
            throw new DAOException("Exception while creating User - [{}]", e);
        }

    }

    @Override
    public User singIn(String email, String password) throws DAOException {
        User user = null;
        try (var connection = ConnectionManager.getConnection();
             var preparedStatement = connection.prepareStatement(QueryDAO.FIND_BY_EMAIL_AND_PASSWORD)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            final var resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = User.builder()
                        .id(resultSet.getInt("id"))
                        .firstName(resultSet.getString("first_name"))
                        .lastName(resultSet.getString("last_name"))
                        .emailLogin(resultSet.getString("emeil_login"))
                        .password(resultSet.getString("password"))
                        .roleUser(RoleUser.findRole(resultSet.getInt("role_user")))
                        .statusUser(StatusUser.findStatus(resultSet.getInt("status_user")))
                        .phoneNumber(resultSet.getString("phone_user"))
                        .build();
            }
        } catch (SQLException e) {
            LOGGER.error("Exception while find by email User - [{}]", email, e);
            throw new DAOException("Exception while find by email User - [{}]", e);
        }
        return user;
    }

    @Override
    public List<User> findAll() throws DAOException {
        List<User> userList = new ArrayList<>();
        try (var connection = ConnectionManager.getConnection();
             var preparedStatement = connection.prepareStatement(QueryDAO.FIND_ALL_USERS)) {
            var resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                userList.add(new User.UserBuilder()
                        .id(resultSet.getInt("id"))
                        .firstName(resultSet.getString("first_name"))
                        .lastName(resultSet.getString("last_name"))
                        .roleUser(RoleUser.findRole(resultSet.getInt("role_user")))
                        .statusUser(StatusUser.findStatus(resultSet.getInt("status_user")))
                        .emailLogin(resultSet.getString("emeil_login"))
                        .password(resultSet.getString("password"))
                        .phoneNumber(resultSet.getString("phone_user"))
                        .build());
            }
        } catch (SQLException e) {
            LOGGER.error("Exception while find all User - [{}]", userList);
            throw new DAOException("Exception while find all User - [{}]", e);
        }

        return userList;
    }

    @Override
    public User findById(int id) {
        User user = null;
        try (var connection = ConnectionManager.getConnection();
             var preparedStatement = connection.prepareStatement(QueryDAO.FIND_BY_ID_USER)) {
            preparedStatement.setInt(1, id);
            var resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = User.builder()
                        .id(resultSet.getInt("id"))
                        .firstName(resultSet.getString("first_name"))
                        .lastName(resultSet.getString("last_name"))
                        .emailLogin(resultSet.getString("emeil_login"))
                        .password(resultSet.getString("password"))
                        .roleUser(RoleUser.findRole(resultSet.getInt("role_user")))
                        .statusUser(StatusUser.findStatus(resultSet.getInt("status_user")))
                        .phoneNumber(resultSet.getString("phone_user"))
                        .build();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public boolean changeRole(int id, RoleUser role) {
        try (var connection = ConnectionManager.getConnection();
             var preparedStatement = connection.prepareStatement(QueryDAO.UPDATE_USER_ROLE)) {
            preparedStatement.setInt(1, role.ordinal() + 1);
            preparedStatement.setInt(2, id);
            var update = preparedStatement.executeUpdate();
            return update > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean changeStatus(int id, StatusUser status) {
        try (var connection = ConnectionManager.getConnection();
             var preparedStatement = connection.prepareStatement(QueryDAO.UPDATE_USER_STATUS)) {
            preparedStatement.setInt(1, status.ordinal() + 1);
            preparedStatement.setInt(2, id);
            var update = preparedStatement.executeUpdate();
            return update > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteUser(User user) throws DAOException {
        try (var connection = ConnectionManager.getConnection();
             var preparedStatement = connection.prepareStatement(QueryDAO.DELETE_USER)) {
            preparedStatement.setInt(1, user.getId());
            var executeUpdate = preparedStatement.executeUpdate();
            return executeUpdate>0;

        } catch (SQLException e) {
            LOGGER.error("Exception while deleting User " + user);
            throw new DAOException("Exception while deleting User " + e);
        }
    }
}
