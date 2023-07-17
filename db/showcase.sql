drop table IF EXISTS downloadable;
drop table IF EXISTS hosted;
drop table IF EXISTS video;
drop table IF EXISTS screen_shot;
drop table IF EXISTS category;
drop table IF EXISTS project;

Create table project (
code Int NOT NULL AUTO_INCREMENT,
title Char(50) NOT NULL,
category_code Int NOT NULL,
domain Char(50) NOT NULL,
synopsis Varchar(2000) NOT NULL,
technologies Char(200) NOT NULL,
UNIQUE (title),
Primary Key (code)) ENGINE = InnoDB;

Create table category (
code Int NOT NULL AUTO_INCREMENT,
title Char(50) NOT NULL,
UNIQUE (title),
Primary Key (code)) ENGINE = InnoDB;

Create table screen_shot (
code Int NOT NULL AUTO_INCREMENT,
project_code Int NOT NULL,
serial_number Int NOT NULL,
title Char(100) NOT NULL,
file Char(100) NOT NULL,
note Varchar(300) NOT NULL,
UNIQUE (file),
Primary Key (code)) ENGINE = InnoDB;

Create table video (
code Int NOT NULL AUTO_INCREMENT,
project_code Int NOT NULL,
serial_number Int NOT NULL,
title Char(100) NOT NULL,
file Char(100) NOT NULL,
note Varchar(20) NOT NULL,
duration Int NOT NULL,
Primary Key (code)) ENGINE = InnoDB;

Create table hosted (
project_code Int NOT NULL,
url Char(100) NOT NULL,
Primary Key (project_code)) ENGINE = InnoDB;

Create table downloadable (
code Int NOT NULL AUTO_INCREMENT,
project_code Int,
download_type Char(1) NOT NULL,
url Char(100) NOT NULL,
Primary Key (code)) ENGINE = InnoDB;

Alter table screen_shot add Foreign Key (project_code) references project (code) on delete restrict on update restrict;
Alter table video add Foreign Key (project_code) references project (code) on delete restrict on update restrict;
Alter table hosted add Foreign Key (project_code) references project (code) on delete restrict on update restrict;
Alter table downloadable add Foreign Key (project_code) references project (code) on delete restrict on update restrict;
Alter table project add Foreign Key (category_code) references category (code) on delete restrict on update restrict;