CREATE TABLE permissions(
    id serial PRIMARY KEY,
    role VARCHAR(50)
);

INSERT INTO permissions (role) values ('ROLE_ADMIN');
INSERT INTO permissions (role) values ('ROLE_MODERATOR');
INSERT INTO permissions (role) values ('ROLE_USER');

