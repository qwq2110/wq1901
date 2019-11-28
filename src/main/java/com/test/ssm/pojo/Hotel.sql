-- auto Generated on 2019-11-26 14:07:27 
-- DROP TABLE IF EXISTS `hotel`; 
CREATE TABLE `hotel`(
    `id` INT (11) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `name` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'name',
    `address` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'address',
    `price` INT (11) NOT NULL DEFAULT -1 COMMENT 'price',
    `lat` DECIMAL (16,7) NOT NULL DEFAULT -1.0 COMMENT 'lat',
    `lng` DECIMAL (16,7) NOT NULL DEFAULT -1.0 COMMENT 'lng',
    `image` VARCHAR (100) NOT NULL DEFAULT '' COMMENT 'image',
    `info` TEXT NOT NULL COMMENT 'info',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`hotel`';
