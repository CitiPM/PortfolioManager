CREATE DATABASE IF NOT EXISTS portfolioManager;
use portfolioManager;

CREATE TABLE stocks (
`id` INT NOT NULL AUTO_INCREMENT,
`ticker_name` VARCHAR(20) NOT NULL,
`share_num` INT NOT NULL,
`price_purchase` DOUBLE NOT NULL,
`time_purchase` DATETIME NOT NULL,
`price_sell` DOUBLE,
`time_sell` DATETIME,
PRIMARY KEY (`id`));


insert into stocks values(1,'MSFT',50, 280.01, );