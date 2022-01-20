DROP TABLE IF EXISTS tarea;
CREATE TABLE tarea(
    identificador bigint PRIMARY KEY,
    descripcion character varying,
    fecha_creacion date,
    vigente boolean
);
--Dat de prueba de la tabla TAREA
insert into tarea values (1, 'Tarea 1', '2022/02/01', true);
insert into tarea values (2, 'Tarea 2', '2022/02/01', true);
insert into tarea values (3, 'Tarea 3', '2022/02/01', true);
insert into tarea values (4, 'Tarea 4', '2022/02/01', true);
insert into tarea values (5, 'Tarea 5', '2022/02/01', true);
insert into tarea values (6, 'Tarea 6', '2022/02/01', true);
insert into tarea values (7, 'Tarea 7', '2022/02/01', true);
insert into tarea values (8, 'Tarea 8', '2022/02/01', true);
insert into tarea values (9, 'Tarea 9', '2022/02/01', true);
insert into tarea values (10, 'Tarea 10', '2022/02/01', true);