CREATE DATABASE IF NOT EXISTS tastego;

USE tastego;



CREATE TABLE users(
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(15),
    password VARCHAR(255),
    address TEXT,
    otp VARCHAR(5),
    otp_verified BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);



CREATE TABLE admin(
    admin_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE,
    password VARCHAR(255)
);

INSERT INTO admin(username,password)
VALUES('admin','admin123');


CREATE TABLE restaurants(
    restaurant_id INT PRIMARY KEY AUTO_INCREMENT,
    restaurant_name VARCHAR(100),
    category VARCHAR(50),
    address VARCHAR(255),
    image VARCHAR(255),
    rating DOUBLE,
    delivery_time VARCHAR(20)
);



CREATE TABLE categories(
    category_id INT PRIMARY KEY AUTO_INCREMENT,
    category_name VARCHAR(50),
    image VARCHAR(255)
);

INSERT INTO categories(category_name,image) VALUES
('Pizza','pizza.png'),
('Burger','burger.png'),
('Biryani','biryani.png'),
('Chinese','chinese.png'),
('South Indian','south.png'),
('Desserts','dessert.png'),
('Drinks','drinks.png');



CREATE TABLE food_items(
    food_id INT PRIMARY KEY AUTO_INCREMENT,
    restaurant_id INT,
    category_id INT,
    food_name VARCHAR(100),
    description TEXT,
    price DOUBLE,
    image VARCHAR(255),
    available BOOLEAN DEFAULT TRUE,

    FOREIGN KEY (restaurant_id)
    REFERENCES restaurants(restaurant_id)
    ON DELETE CASCADE,

    FOREIGN KEY (category_id)
    REFERENCES categories(category_id)
    ON DELETE CASCADE
);



CREATE TABLE cart(
    cart_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    food_id INT,
    quantity INT DEFAULT 1,

    FOREIGN KEY(user_id)
    REFERENCES users(user_id)
    ON DELETE CASCADE,

    FOREIGN KEY(food_id)
    REFERENCES food_items(food_id)
    ON DELETE CASCADE
);



CREATE TABLE orders(
    order_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    total_amount DOUBLE,
    payment_method VARCHAR(30),
    order_status VARCHAR(30),
    delivery_address TEXT,
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY(user_id)
    REFERENCES users(user_id)
    ON DELETE CASCADE
);



CREATE TABLE order_items(
    order_item_id INT PRIMARY KEY AUTO_INCREMENT,
    order_id INT,
    food_id INT,
    quantity INT,
    price DOUBLE,

    FOREIGN KEY(order_id)
    REFERENCES orders(order_id)
    ON DELETE CASCADE,

    FOREIGN KEY(food_id)
    REFERENCES food_items(food_id)
    ON DELETE CASCADE
);


CREATE TABLE otp_logs(
    otp_id INT PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(100),
    otp VARCHAR(5),
    generated_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


INSERT INTO restaurants
(restaurant_name,category,address,image,rating,delivery_time)
VALUES

('Paradise Biryani',
'Biryani',
'Bangalore',
'paradise.jpg',
4.7,
'30 mins'),

('Pizza Hut',
'Pizza',
'Whitefield',
'pizzahut.jpg',
4.5,
'25 mins'),

('Dominos',
'Pizza',
'Marathahalli',
'dominos.jpg',
4.6,
'28 mins'),

('Burger King',
'Burger',
'Indiranagar',
'burgerking.jpg',
4.4,
'22 mins'),

('Meghana Foods',
'Biryani',
'HSR Layout',
'meghana.jpg',
4.8,
'35 mins');


INSERT INTO food_items
(restaurant_id,category_id,food_name,description,price,image)
VALUES

(1,3,'Chicken Dum Biryani',
'Hyderabadi Style',
299,
'biryani1.jpg'),

(1,3,'Mutton Biryani',
'Spicy Mutton',
349,
'biryani2.jpg'),

(2,1,'Veg Pizza',
'Cheese Loaded',
249,
'pizza1.jpg'),

(2,1,'Farmhouse Pizza',
'Fresh Veggies',
329,
'pizza2.jpg'),

(3,1,'Pepperoni Pizza',
'Classic Pizza',
399,
'pizza3.jpg'),

(4,2,'Whopper Burger',
'Double Patty',
219,
'burger1.jpg'),

(4,2,'Veg Burger',
'Crispy Veg',
149,
'burger2.jpg'),

(5,3,'Special Chicken Biryani',
'Signature Dish',
329,
'biryani3.jpg');



INSERT INTO users
(full_name,email,phone,password,address,otp_verified)
VALUES
('Test User',
'test@tastego.com',
'9876543210',
'123456',
'Bangalore',
TRUE);


INSERT INTO orders
(user_id,total_amount,payment_method,order_status,delivery_address)
VALUES
(
1,
548,
'UPI',
'Delivered',
'Bangalore'
);

INSERT INTO order_items
(order_id,food_id,quantity,price)
VALUES
(1,1,1,299),
(1,3,1,249);

