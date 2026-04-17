CREATE TABLE users (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(255),
                       password VARCHAR(255)
);

CREATE TABLE wishes (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        title VARCHAR(255),
                        description TEXT,
                        link TEXT,
                        icon VARCHAR(255),
                        user_id INT,
                        FOREIGN KEY (user_id) REFERENCES users(id)
);