create table Marca(
    Codigo int not null primary key,
    Nombre varchar2(20)
    )
    
create table Ventas2017(
    Codigo int not null primary key,
    Marca int not null,
    FechaVenta Date,
    Precio decimal(10,2)
    )
    
create table Ventas2018(
    Codigo int not null primary key,
    Marca int not null,
    FechaVenta Date,
    Precio decimal(10,2)
    )
    
Alter table Ventas2017
    ADD (FOREIGN KEY (Marca) REFERENCES Marca (Codigo));

Alter table Ventas2018
    ADD (FOREIGN KEY (Marca) REFERENCES Marca (Codigo));
    
insert into Marca values ('1','Apple');
insert into Marca values ('2','Samsung');
insert into Marca values ('3','Microsoft');
insert into Marca values ('4','Philips');
insert into Marca values ('5','Sony');
insert into Marca values ('6','LG');
insert into Marca values ('7','Sharp');
insert into Marca values ('8','Panasonic');


insert into Ventas2017 values ('1','1','01/05/2017','200');
insert into Ventas2018 values ('1','1','01/06/2018','300');
insert into Ventas2017 values ('2','2','01/05/2017','150');
insert into Ventas2018 values ('2','2','01/07/2018','200');
insert into Ventas2017 values ('3','3','01/05/2017','100');
insert into Ventas2018 values ('3','3','01/05/2018','300');
insert into Ventas2017 values ('4','4','01/05/2017','150');
insert into Ventas2018 values ('4','4','01/05/2018','250');
insert into Ventas2017 values ('5','5','01/05/2017','150');
insert into Ventas2018 values ('5','5','01/05/2018','100');
insert into Ventas2017 values ('6','6','01/05/2017','130');
insert into Ventas2018 values ('7','6','01/05/2018','160');
insert into Ventas2017 values ('7','7','01/05/2017','210');
insert into Ventas2018 values ('7','7','01/05/2018','250');
insert into Ventas2017 values ('8','8','01/05/2017','230');
insert into Ventas2018 values ('8','8','01/05/2018','200');

CREATE or replace VIEW VISTA AS
SELECT 
MARCA.NOMBRE ,
TO_CHAR(VENTAS2017.FECHAVENTA,'DD/MM/YYYY') AS "FECHA2017",
VENTAS2017.PRECIO AS "PRECIO2017",
TO_CHAR(VENTAS2018.FECHAVENTA,'DD/MM/YYYY') AS "FECHA2018",
VENTAS2018.PRECIO AS "PRECIO2018" 
FROM MARCA INNER JOIN VENTAS2017 ON MARCA.CODIGO = VENTAS2017.MARCA INNER JOIN VENTAS2018 ON MARCA.CODIGO = VENTAS2018.MARCA;
