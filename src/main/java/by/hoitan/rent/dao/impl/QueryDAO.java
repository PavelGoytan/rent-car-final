package by.hoitan.rent.dao.impl;

public class QueryDAO {
    protected static final String FIND_ALL_CARS = """
            SELECT cars.id,
            registration_number,
            cost,
            model,
            car_status
             FROM rent_car.cars
             JOIN status_car ON cars.car_status = status_car.id;
            """;

    protected static final String FIND_BY_LIMIT = """
            SELECT cars.id,
            registration_number,
            cost,
            model,
            car_status
            FROM cars
            JOIN status_car sc on cars.car_status = sc.id
            LIMIT ?,?;
            """;
    protected static final String FIND_ALL_USERS = """
            SELECT users.id,
            first_name,
            last_name,
            emeil_login,
            password,
            role_user,
            status_user,
            phone_user
             FROM rent_car.users
             JOIN status_users ON users.status_user = status_users.id
             JOIN role_users ON users.role_user = role_users.id;
            """;

    protected static final String FIND_BY_ID_USER = """
            SELECT users.id,
            first_name,
            last_name,
            emeil_login,
            password,
            role_user,
            status_user,
            phone_user
             FROM rent_car.users
             JOIN status_users ON users.status_user = status_users.id
             JOIN role_users ON users.role_user = role_users.id
             WHERE users.id = ?;
            """;

    protected static final String FIND_BY_EMAIL_AND_PASSWORD = """
            SELECT users.id,
            first_name,
            last_name,
            emeil_login,
            password,
            role_user,
            status_user,
            phone_user
            FROM users
            WHERE emeil_login = ? AND password = ?;
                        
            """;
    protected static final String UPDATE_USER_ROLE = """
            UPDATE users
            SET role_user = ?
            WHERE id = ?;
            """;
    protected static final String UPDATE_USER_STATUS = """
            UPDATE users
            SET status_user = ?
            WHERE id = ?;
            """;

    protected static final String DELETE_USER = """
            DELETE 
            FROM users
            WHERE id = ?;
            """;

    protected static final String CREATE_CAR = """
            INSERT INTO cars(registration_number, cost, model, car_status) VALUES (?, ?, ?, ?);
                        
            """;

    protected static final String UPDATE_CAR = """
            UPDATE rent_car.cars
            SET registration_number = ?,
            cost = ?,
            model = ?,
            car_status = ?
            WHERE id = ?;
            """;

    protected static final String FIND_BY_ID_CAR = """
            SELECT cars.id,
            registration_number,
            cost,
            model,
            car_status
            FROM cars
            WHERE id=?;
                      
            """;
    protected static final String DELETE_CAR = """
            DELETE
            FROM cars
            WHERE id = ?;
            """;


    protected static final String FIND_BY_MODEL = """
            SELECT cars.id,
            registration_number,
            cost,
            model,
            car_status
             FROM rent_car.cars
             JOIN status_car ON cars.car_status = status_car.id
            WHERE model = ?;
            """;

    protected static final String FIND_ALL_ORDERS = """
            SELECT orders.id,
            price,
            rent_date,
            return_date,
            car_id,
            user_id,
            status_id
            FROM rent_car.orders
            JOIN cars c on c.id = orders.car_id;
          
                 """;
    protected static final String FIND_ALL_ORDERS_BY_CAR_ID = """
            SELECT orders.id,
            price,
            rent_date,
            return_date,
            car_id,
            user_id,
            status_id
            FROM rent_car.orders
            WHERE car_id = ?;
                 """;
    protected static final String UPDATE_ORDER = """
            UPDATE rent_car.orders
            SET price = ?,
            rent_date = ?,
            return_date = ?,
            status_id = ?
            WHERE id = ?;
            """;

    protected static final String FIND_ORDER_BY_ID = """
            SELECT rent_car.orders.id,
            price,
            rent_date,
            return_date,
            car_id,
            user_id,
            status_id
            FROM orders
            WHERE id = ?;
          
            """;
    protected static final String FIND_ORDER_BY_USER_ID = """
            SELECT rent_car.orders.id,
            price,
            rent_date,
            return_date,
            car_id,
            user_id,
            status_id
            FROM orders
            WHERE user_id = ?;
          
            """;

}
