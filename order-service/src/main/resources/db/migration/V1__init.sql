create table t_order
(
    orderId bigint(20) NOT NULL AUTO_INCREMENT,
    orderNumber varchar(255),
    productCode varchar(255),
    productPrice decimal,
    orderQuantity int(11),
    primary key (orderId)
)