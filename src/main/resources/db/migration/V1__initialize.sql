DROP TABLE IF EXISTS users;
CREATE TABLE users
(
    id       smallserial,
    password VARCHAR(80),
    email    VARCHAR(30) UNIQUE,
    login    VARCHAR(20),
    token    VARCHAR(80) DEFAULT null,
    enabled  boolean     DEFAULT false,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS roles;
CREATE TABLE roles
(
    id   smallserial,
    name VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS users_roles;
CREATE TABLE users_roles
(
    user_id INT NOT NULL,
    role_id INT NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id)
        REFERENCES users (id),
    FOREIGN KEY (role_id)
        REFERENCES roles (id)
);

INSERT INTO roles (name)
VALUES ('ROLE_USER'),
       ('ROLE_ADMIN');

INSERT INTO users (password, login, email)
VALUES ('$2a$10$fr2vT3zNqKM.1RPhgRM3keihfzrdUavz1xa1KBo/4V1UiVumNXZ4G', 'admin', 'admin@gmail.com'),
       ('$2a$10$K43vbVPlEa2DfVUMTw3eaeO.T6Kvt3Dy6HfiRUgXjg4SFcRj9sl.W', 'user', 'user@gmail.com');

INSERT INTO users_roles (user_id, role_id)
VALUES (1, 1),
       (1, 2),
       (2, 1);

DROP TABLE IF EXISTS files;
CREATE TABLE files
(
    id    serial,
    title VARCHAR(255),
    link  VARCHAR(255),
    type  VARCHAR(255),
    PRIMARY KEY (id)
);

INSERT INTO files (title, link, type)
VALUES ('1', 'https://cloud.mail.ru/public/4BFQ/dHEaywaB9', '.txt'),
       ('2', 'https://cloud.mail.ru/public/8YhG/4HS7E5MqR', '.txt'),
       ('Берег', 'https://cloud.mail.ru/public/2oDf/5f8R3tdV2', 'jpg'),
       ('Полет', 'https://cloud.mail.ru/public/4dLK/2Q213AhrW', '.mp4');

