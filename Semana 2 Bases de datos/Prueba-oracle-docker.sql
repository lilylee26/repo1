select 5+5 from dual;

select *from cliente;

CREATE TABLE CLIENTE(
    ID_CLIENTE NUMBER GENERATED ALWAYS AS IDENTITY,
    NOMBRE NVARCHAR2(100),
    EMAIL NVARCHAR2(100),
    TELEFONO NUMBER,
    DIRECCION NVARCHAR2(100),
    TIENDA_ID NUMBER
);

DROP TABLE CLIENTE;

insert into cliente(nombre, email, telefono, direccion)
values('gerardo', 'gerado@gmail.com', 2342345431, 'napola 103');

commit;