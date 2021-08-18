CREATE DATABASE IF NOT EXISTS portfolioManager;
use portfolioManager;

Drop table `conygre`.`accounts`;

CREATE TABLE `conygre`.`accounts` (
`id` INT NOT NULL AUTO_INCREMENT,
`type` VARCHAR(20) NOT NULL,
`ticker` VARCHAR(20) NOT NULL,
`quantity` INT,
`price_purchase` DOUBLE,
`time_purchase` DATETIME,
`price_current` DOUBLE,
PRIMARY KEY (`id`));


insert into `conygre`.`accounts` values(1,'Investment','MSFT',33,254.71,'2021-04-12T00:00:00.000',298.11);
insert into `conygre`.`accounts` values(2,'Investment','NFLX',45,512.64,'2021-08-13T00:00:00.000',0.00);
insert into `conygre`.`accounts` values(3,'Investment','AAPL',71,146.51,'2021-08-02T00:00:00.000',135.11);
insert into `conygre`.`accounts` values(4,'Investment','GOOG',5,2071.51,'2021-03-07T00:00:00.000',325.11);
insert into `conygre`.`accounts` values(5,'Investment','AMZN',2,3319.51,'2021-05-07T00:00:00.000',755.11);
insert into `conygre`.`accounts` values(6,'Investment','TSLA',10,891.38,'2021-01-26T00:00:00.000',55.11);
insert into `conygre`.`accounts` values(7,'Investment','C',71,79.08,'2021-06-008T00:00:00.000',135.11);
insert into `conygre`.`accounts` values(8,'Investment','CL=F',5,74.10,'2021-06-12T00:00:00.000',325.11);
insert into `conygre`.`accounts` values(9,'Investment','BTC-USD',2,63314.78,'2021-01-15T00:00:00.000',755.11);
insert into `conygre`.`accounts` values(10,'Investment','HD',10,314.12,'2021-05-10T00:00:00.000',55.11);
insert into `conygre`.`accounts` values(11,'Cash','RBC-Cheque',0,0.0,NULL,23135.91);
insert into `conygre`.`accounts` values(12,'Cash','RBC-Save',0,0.0,NULL,38477.27);
insert into `conygre`.`accounts` values(13,'Cash','BMO-Cheque',0,0.0,NULL,32412.43);




