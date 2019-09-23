
--=============
create DATABASE mav_auth;

drop table IF EXISTS users CASCADE;
drop TABLE IF EXISTS user_roles CASCADE;
drop SEQUENCE IF EXISTS user_roles_seq;

CREATE  TABLE users (
  username VARCHAR(45) NOT NULL,
  password VARCHAR(45) NOT NULL,
  enabled BOOLEAN NOT NULL DEFAULT TRUE,
  PRIMARY KEY (username)
);
CREATE SEQUENCE user_roles_seq;

CREATE TABLE user_roles (
  user_role_id int NOT NULL DEFAULT NEXTVAL ('user_roles_seq'),
  username varchar(45) NOT NULL,
  role varchar(45) NOT NULL,
  PRIMARY KEY (user_role_id),
  CONSTRAINT uni_username_role UNIQUE (role,username),
  CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username)
);
CREATE INDEX fk_username_idx ON user_roles (username);

INSERT INTO users(username,password,enabled)
  VALUES ('priya','priya', true);
INSERT INTO users(username,password,enabled)
  VALUES ('naveen','naveen', true);
INSERT INTO user_roles (username, role)
  VALUES ('priya', 'ROLE_USER');
INSERT INTO user_roles (username, role)
  VALUES ('priya', 'ROLE_ADMIN');
INSERT INTO user_roles (username, role)
  VALUES ('naveen', 'ROLE_USER');
