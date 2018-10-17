# RESTful-service-usingJersey
REST API built using Jersey for Advertisement Portal Website



# dataQueries 
create database advertisementProject;
use advertisementProject;


create table item(itemid int not null unique,name varchar(300),description varchar(500),picturereference varchar(500),
  price int,category varchar(500),subcategory varchar(500),addfield1 varchar(500),addfield2 varchar(500),sikey int not null auto_increment,
  sellerid int not null,advtitem boolean,primary key(sikey));

create table sellerinfo(sellerid int not null unique,sname varchar(100),saddress varchar(200),sskey int not null
    auto_increment,primary key(sskey));

create table linktable(sikey int not null,sskey int not null,foreign key(sikey) references item(sikey),
  foreign key(sskey) references sellerinfo(sskey));

  DELIMITER $$
  CREATE TRIGGER after_insert_item_table
    AFTER INSERT ON item
    FOR EACH ROW
  BEGIN
    DECLARE SSID INT;
    SELECT SSKEY INTO SSID FROM SELLERINFO WHERE SELLERID=NEW.SELLERID;
    INSERT INTO LINKTABLE values(new.sikey,ssid);
  END$$
  DELIMITER ;
