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
 nombreins varchar(100) not null,
 apellido varchar(100) not null,
 tipodoc varchar(100) not null,
 documento varchar(100) not null,
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

ALTER TABLE programacion
ADD CONSTRAINT clase_fk
  FOREIGN KEY (clase)
  REFERENCES clase (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE programacion
ADD CONSTRAINT aprendiz_fk
  FOREIGN KEY (aprendiz)
  REFERENCES aprendiz (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE programacion
ADD CONSTRAINT instructor_fk
  FOREIGN KEY (instructor)
  REFERENCES instructor (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


INSERT INTO clase VALUES(1, 'Teoria');
INSERT INTO clase VALUES(2, 'Practica');
INSERT INTO clase VALUES(3, 'Refuerzo');

INSERT INTO instructor VALUES(1, 'Manuel', 'Quintero', 'CC', '1032548963');
INSERT INTO instructor VALUES(2, 'Diego', 'Santana', 'CC', '1032666963');
INSERT INTO instructor VALUES(3, 'Daniel', 'Rojas', 'CC', '102248963');
INSERT INTO instructor VALUES(4, 'Catalina', 'Montero', 'CC', '1032548925');
INSERT INTO instructor VALUES(5, 'Santiago', 'Casas', 'CC', '103254854');

