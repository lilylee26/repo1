--TABLA LIBRO PARA MI SERVICIO WEB DE LIBRO 

create table libros(
    id_libro number generated as identity,
    titulo NVARCHAR2(100),
    autor NVARCHAR2(100),
    genero NVARCHAR2(100),
    a_publicacion int,
    isbn NVARCHAR2(100) unique, 
    editorial NVARCHAR2(100),
    paginas int,
    precio int
    
);
drop table libros;

insert into libros(titulo, autor, genero, a_publicacion, isbn,editorial, paginas, precio)
values ('100 años de soledad', 'gabriel garcia marquez', 'realismo magico', 1967,'978843704947', 'sudamericana', 471, 199);

commit;

select *from libros;



INSERT INTO libros (titulo, autor, genero, a_publicacion, isbn, editorial, paginas, precio) VALUES
('1984', 'George Orwell', 'Distopía', 1949, '9780451524935', 'Secker y Warburg', 328, 1550);
INSERT INTO libros (titulo, autor, genero, a_publicacion, isbn, editorial, paginas, precio) VALUES
('El principito', 'Antoine de Saint-Exupéry', 'Literatura infantil', 1943, '9780156012195', 'Reynal y Hitchcock', 96, 1275);

INSERT INTO libros (titulo, autor, genero, a_publicacion, isbn, editorial, paginas, precio) VALUES
('Don Quijote de la Mancha', 'Miguel de Cervantes', 'Novela clásica', 1605, '9788420739235', 'Francisco de Robles', 1056, 2999);
INSERT INTO libros (titulo, autor, genero, a_publicacion, isbn, editorial, paginas, precio) VALUES
('Orgullo y prejuicio', 'Jane Austen', 'Novela romántica', 1813, '9780141439518', 'T. Egerton', 432, 1425);
INSERT INTO libros (titulo, autor, genero, a_publicacion, isbn, editorial, paginas, precio) VALUES
('Crimen y castigo', 'Fiódor Dostoyevski', 'Novela psicológica', 1866, '9788420664209', 'El Mensajero Ruso', 671, 1850);
INSERT INTO libros (titulo, autor, genero, a_publicacion, isbn, editorial, paginas, precio) VALUES
('Harry Potter y la piedra filosofal', 'J.K. Rowling', 'Fantasía', 1997, '9788478884452', 'Bloomsbury', 309, 1699);
INSERT INTO libros (titulo, autor, genero, a_publicacion, isbn, editorial, paginas, precio) VALUES
('La sombra del viento', 'Carlos Ruiz Zafón', 'Misterio', 2001, '9788408161477', 'Planeta', 575, 2045);
INSERT INTO libros (titulo, autor, genero, a_publicacion, isbn, editorial, paginas, precio) VALUES
('El nombre del viento', 'Patrick Rothfuss', 'Fantasía épica', 2007, '9788401337208', 'DAW Books', 722, 2299);
INSERT INTO libros (titulo, autor, genero, a_publicacion, isbn, editorial, paginas, precio) VALUES
('El alquimista', 'Paulo Coelho', 'Novela filosófica', 1988, '9780061122413', 'HarperCollins', 208, 1399);






---ejemplo de llave primaria incremental
--usando triggers before

--crear secuencia 
create sequence libro_p_k
start  with 1
increment by 1
minvalue 1
maxvalue  999999999
nocycle;
/

--trigger before (actua antes de la opereacion)
create or replace trigger libro_pk
before insert on libros
for each row
begin
    if :new.id_libro is null then
        :new.id_libro := libro_p_k.nextval;
    end if;
end;

drop trigger libro_pk;


