--TABLA LIBRO PARA MI SERVICIO WEB DE LIBRO 

CREATE TABLE automovil(
    id_auto NUMBER GENERATED AS IDENTITY,
    marca NVARCHAR2(100),
    modelo NVARCHAR2(100),
    anio NUMBER,
    color NVARCHAR2(50),
    n_Serie NVARCHAR2(50) UNIQUE,   -- VIN o número único del auto
    tipo NVARCHAR2(50),
    precio NUMBER
);

DROP TABLE automovil;


INSERT INTO automovil(marca, modelo, anio, color, n_Serie, tipo, precio)
VALUES ('Toyota', 'Corolla', 2020, 'Blanco', 'JTDBR32E202300001', 'Sedán', 280000);

INSERT INTO automovil(marca, modelo, anio, color, n_Serie, tipo, precio)
VALUES ('Nissan', 'Versa', 2019, 'Gris', '3N1CN7AP9KL000002', 'Sedán', 240000);

INSERT INTO automovil(marca, modelo, anio, color, n_Serie, tipo, precio)
VALUES ('Honda', 'Civic', 2021, 'Negro', '2HGFC2F69MH000003', 'Sedán', 320000);

INSERT INTO automovil(marca, modelo, anio, color, n_Serie, tipo, precio)
VALUES ('Ford', 'Mustang', 2022, 'Rojo', '1FA6P8TH9N000004', 'Deportivo', 680000);

INSERT INTO automovil(marca, modelo, anio, color, n_Serie, tipo, precio)
VALUES ('Chevrolet', 'Aveo', 2018, 'Azul', '3G1BE6SM2J8000005', 'Sedán', 190000);

INSERT INTO automovil(marca, modelo, anio, color, n_Serie, tipo, precio)
VALUES ('Volkswagen', 'Jetta', 2020, 'Plata', '3VW2K7AJ0LM000006', 'Sedán', 295000);

INSERT INTO automovil(marca, modelo, anio, color, n_Serie, tipo, precio)
VALUES ('Mazda', 'Mazda 3', 2021, 'Rojo', 'JM1BPABL4M000007', 'Sedán', 310000);

INSERT INTO automovil(marca, modelo, anio, color, n_Serie, tipo, precio)
VALUES ('Kia', 'Rio', 2019, 'Blanco', 'KNADM4A36K000008', 'Sedán', 210000);

INSERT INTO automovil(marca, modelo, anio, color, n_Serie, tipo, precio)
VALUES ('Hyundai', 'Elantra', 2020, 'Gris oscuro', 'KMHD84LF2LU000009', 'Sedán', 260000);

INSERT INTO automovil(marca, modelo, anio, color, n_Serie, tipo, precio)
VALUES ('Toyota', 'Hilux', 2021, 'Blanco', 'MR0HA3CD1M000010', 'Pickup', 450000);

INSERT INTO automovil(marca, modelo, anio, color, n_Serie, tipo, precio)
VALUES ('Ford', 'Ranger', 2020, 'Negro', '6FPAAAJGSW000011', 'Pickup', 420000);

INSERT INTO automovil(marca, modelo, anio, color, n_Serie, tipo, precio)
VALUES ('Chevrolet', 'Onix', 2022, 'Gris', '9BGKS48G0NC000012', 'Hatchback', 235000);

INSERT INTO automovil(marca, modelo, anio, color, n_Serie, tipo, precio)
VALUES ('Nissan', 'March', 2018, 'Verde', '3N1CK3CP5JL000013', 'Hatchback', 175000);

INSERT INTO automovil(marca, modelo, anio, color, n_Serie, tipo, precio)
VALUES ('Honda', 'CR-V', 2021, 'Plata', '5J6RW2H52M000014', 'SUV', 480000);

INSERT INTO automovil(marca, modelo, anio, color, n_Serie, tipo, precio)
VALUES ('Toyota', 'RAV4', 2022, 'Azul', 'JTMRFREV5N000015', 'SUV', 520000);

commit;


select *from automovil;