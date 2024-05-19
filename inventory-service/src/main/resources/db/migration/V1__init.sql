create table t_inventory
(
    inventoryId bigint(20) NOT NULL AUTO_INCREMENT,
    productCode varchar(255) NOT NULL,
    stock int(11) NOT NULL,
    primary key (inventoryId)
)