create table aprendiz (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 apellido varchar(100) not null,
 tipodoc varchar(100) not null,
 documento varchar(100) not null,
 eps varchar(100) not null,
 categoria varchar(100) not null,
 valorcurso  double not null,
 abono  double not null,
 adicional  double,
 primary key (id)
);

create table instructor (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 apellido varchar(100) not null,
 tipodoc varchar(100) not null,
 documento varchar(100) not null,
 codigo varchar(10) not null,
 primary key (id)
);

create table clase (
 id int(11) not null auto_increment,
 descripcion varchar(100) not null,
 primary key (id)
);

create table programacion (
 id int(11) not null auto_increment,
 clase int(11) not null,
 aprendiz int(11) not null,
 instructor int(11) not null,
 fecha DATE not null,
 hora varchar(45) not null,
 asistencia varchar(3),
 primary key (id)
);

INSERT INTO clase VALUES(1, 'Teoria');
INSERT INTO clase VALUES(2, 'Practica');
INSERT INTO clase VALUES(3, 'Refuerzo');
