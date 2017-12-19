drop database contrader;
create database contrader;

create table contrader.users(
  username varchar(50)  NOT NULL,
  password varchar(50),
  firstname varchar(50),
  lastname varchar(50),
  dateofbirth varchar(50),
  fiscalcode varchar(50),
  businessname varchar(50),
  vat varchar(50),
  municipality varchar(50),
  post varchar(10),
  city varchar(30),
  address varchar(50),
  telephone varchar(20),
  role varchar(20),
  PRIMARY KEY (username)
);

create table contrader.gomme(
  id_gomme int(20) NOT NULL AUTO_INCREMENT,
  model varchar(50),
  manufacturer varchar(50),
  price float,
  width float,
  height float,
  diameter float,
  weight float,
  speed varchar(3),
  season varchar(50),
  type_vehicle varchar(50),
  quantity varchar(10),
  PRIMARY KEY (id_gomme)
);

create table contrader.vehicle(
  id_vehicle int(20) NOT NULL AUTO_INCREMENT,
  brand varchar(50),
  model varchar(50),
  fuel varchar(20),
  version varchar(50),
  capacity varchar(50),
  PRIMARY KEY (id_vehicle)
);

create table contrader.compatibility(
	id_vehicle int(20),
	id_gomme int(20),
	foreign key (id_vehicle) references contrader.vehicle(id_vehicle),
	foreign key (id_gomme) references contrader.gomme(id_gomme)
);


insert into contrader.users (username, password, firstname, lastname, dateofbirth, fiscalcode, businessname, vat, municipality, post, city, address, telephone, role)
values ('user','user','Lello','Rossi','08/12/1978','123','Contrader','666','Vallo','111','Salerno','via Roma','123456','user');
insert into contrader.users (username, password, firstname, lastname, dateofbirth, fiscalcode, businessname, vat, municipality, post, city, address, telephone, role)
values ('admin', 'admin','Mario','Saponara','05/08/1985','123456','Adecco','222','Roccadaspide','84050','Salerno','via Fonte','0828943076','admin');

insert into contrader.gomme (model, manufacturer, price, width, height, diameter, weight, speed, season, type_vehicle, quantity)
values ('Trelleborg-B50','Trelleborg',200.50,20,20,20,20,'M','Invernali','moto',20);
insert into contrader.gomme (model, manufacturer, price, width, height, diameter, weight, speed, season, type_vehicle, quantity)
values ('Trelleborg-B60','Trelleborg',100.50,30,30,30,30,'M','Estivi','auto',30);
insert into contrader.gomme (model, manufacturer, price, width, height, diameter, weight, speed, season, type_vehicle, quantity)
values ('Trelleborg-B70','Trelleborg',300.50,50,50,50,50,'W','Quattro Stagioni','commerciale',40);
insert into contrader.gomme (model, manufacturer, price, width, height, diameter, weight, speed, season, type_vehicle, quantity)
values ('Pirelli Hard','Pirelli',50.50,60,60,60,60,'W','Invernali','commerciale',50);
insert into contrader.gomme (model, manufacturer, price, width, height, diameter, weight, speed, season, type_vehicle, quantity)
values ('Pirelli Soft','Pirelli',150.50,30,30,30,30,'W','Invernali','moto',60);
insert into contrader.gomme (model, manufacturer, price, width, height, diameter, weight, speed, season, type_vehicle, quantity)
values ('Pirelli Ultra-Soft','Pirelli',134.50,50,50,50,50,'M','Estivi','auto',70);

insert into contrader.vehicle (brand, model, fuel, version, capacity) 
values ('Fiat','Punto','Diesel','Punto Evo','1.3 JTD');
insert into contrader.vehicle (brand, model, fuel, version, capacity) 
values ('Bugatti','EB 110','Benzina','EB 110','3.5 360');
insert into contrader.vehicle (brand, model, fuel, version, capacity) 
values ('Ferrari','California','Benzina','California','4.3 V8 460');
insert into contrader.vehicle (brand, model, fuel, version, capacity) 
values ('Mercedes','Classe A','Diesel','A 160 CDI','1.6 CDI 160');
insert into contrader.vehicle (brand, model, fuel, version, capacity) 
values ('Honda','Logo','Benzina','Logo','1.3 83');

insert into contrader.compatibility (id_vehicle, id_gomme)
values (1,2);
insert into contrader.compatibility (id_vehicle, id_gomme)
values (1,6);
insert into contrader.compatibility (id_vehicle, id_gomme)
values (2,6);
insert into contrader.compatibility (id_vehicle, id_gomme)
values (3,2);
insert into contrader.compatibility (id_vehicle, id_gomme)
values (4,6);
insert into contrader.compatibility (id_vehicle, id_gomme)
values (4,2);