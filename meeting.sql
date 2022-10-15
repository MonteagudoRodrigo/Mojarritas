
drop
database if exists meeting;


create
database 
meeting;


use meeting;





drop
table if exists usuario;


CREATE
TABLE 
usuario(


                     id
int auto_increment 
primary key,


                     nombre
varchar(50),


                     apellido
varchar(50),


                     username
varchar(50),


                     email
varchar(50),


                     nacimiento
DATE,


                     sexo
INT,


                     pass
varchar(50),


                     token
varchar(255) default
'',


                     imagen
varchar(50)


);





drop
table if exists publicacion;


CREATE
TABLE 
publicacion(


                    id
int auto_increment 
primary key,


                    usuario_id
int,


                    lugarId
int,


                    titulo
varchar(50),


                    fecha
varchar(50),


                    descripcion
varchar(50),


                    cantParticipantes
int,


                    cupo
int


);





insert into usuario(nombre, apellido, username, email, pass)
values ('nombre_test','appelido_test',
'username_test','test@test','12345');


insert into publicacion(usuario, lugarId, titulo, fecha, descripcion, cantParticipantes, cupo)
values (1,1,'Fiesta','2022-01-01
 00:00','Publicacion de una fiesta',5,10);

