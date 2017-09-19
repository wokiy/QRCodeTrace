
alter table t_comment
drop
foreign key FK_6xd3ec04csqnot2guhbykunj0


alter table t_product
drop
foreign key FK_ibivi9824d434wr7ospoivby3

alter table t_product
drop
foreign key FK_n7hsms861b7k07u0qmg7dc8iv

alter table t_product
drop
foreign key FK_qqa6gn9u9xgsei4deabftpbu0

alter table t_product
drop
foreign key FK_qa0tyyyr494ii27v9xtb2is3m

drop table if exists t_comment

drop table if exists t_company

drop table if exists t_material

drop table if exists t_news

drop table if exists t_process

drop table if exists t_product

drop table if exists t_sell

drop table if exists t_transport

drop table if exists t_user

create table t_comment (
id integer not null auto_increment,
content varchar(255),
date datetime,
product_id varchar(255),
primary key (id)
)

create table t_company (
id integer not null auto_increment,
address varchar(255),
email varchar(255),
fax varchar(255),
introduction varchar(255),
name varchar(255),
phone varchar(255),
primary key (id)
)

create table t_material (
id integer not null auto_increment,
animalcule varchar(255),
company_name varchar(255),
fertilization varchar(255),
heavy_metal varchar(255),
medicine varchar(255),
nitrate varchar(255),
pesticide varchar(255),
qulity varchar(255),
primary key (id)
)

create table t_news (
id integer not null auto_increment,
content varchar(255),
date datetime,
title varchar(255),
primary key (id)
)

create table t_process (
id integer not null auto_increment,
animalcule varchar(255),
company_name varchar(255),
method varchar(255),
packing varchar(255),
refrigerator_temperature float not null,
storage_time datetime,
workshop_temperature float not null,
primary key (id)
)

create table t_product (
id varchar(255) not null,
name varchar(255),
pic varchar(255),
material_id integer,
process_id integer,
sell_id integer,
transport_id integer,
primary key (id)
)

create table t_sell (
id integer not null auto_increment,
allergy varchar(255),
company_name varchar(255),
disinfection varchar(255),
exam_person varchar(255),
examination varchar(255),
humidity float not null,
in_charge_person varchar(255),
in_charge_phone varchar(255),
license varchar(255),
logal_person varchar(255),
nutrition varchar(255),
purchase_count integer not null,
purchase_date datetime,
stock_person varchar(255),
stock_phone varchar(255),
temperature float not null,
primary key (id)
)

create table t_transport (
id integer not null auto_increment,
arrival_time datetime,
car_type varchar(255),
company_name varchar(255),
departure_time datetime,
disinfection varchar(255),
goods_count integer not null,
goods_type varchar(255),
humidity float not null,
legal_person varchar(255),
person_in_charge varchar(255),
phone varchar(255),
place_from varchar(255),
place_to varchar(255),
temperature float not null,
primary key (id)
)

create table t_user (
user_name varchar(255) not null,
address varchar(255),
password varchar(255) not null,
phone varchar(255),
real_name varchar(255),
role integer not null,
primary key (user_name)
)

alter table t_comment
add constraint FK_6xd3ec04csqnot2guhbykunj0
foreign key (product_id)
references t_product (id)

alter table t_product
add constraint FK_ibivi9824d434wr7ospoivby3
foreign key (material_id)
references t_material (id)

alter table t_product
add constraint FK_n7hsms861b7k07u0qmg7dc8iv
foreign key (process_id)
references t_process (id)

alter table t_product
add constraint FK_qqa6gn9u9xgsei4deabftpbu0
foreign key (sell_id)
references t_sell (id)

alter table t_product
add constraint FK_qa0tyyyr494ii27v9xtb2is3m
foreign key (transport_id)
references t_transport (id)