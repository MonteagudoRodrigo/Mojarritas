drop database if exists meeting;
create database meeting;
use meeting;

drop table if exists usuario;
CREATE TABLE usuario(
                     id int auto_increment primary key,
                     nombre varchar(50),
                     apellido varchar(50),
                     username varchar(50),
                     email varchar(50),
                     nacimiento DATE,
                     sexo INT,
                     pass varchar(50),
                     token varchar(255) default '',
                     imagen varchar(50)
);

insert into usuario(nombre, apellido, username, email, pass) values ('nombre_test','appelido_test', 'username_test','test@test','12345');
