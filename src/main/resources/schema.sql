CREATE TABLE IF NOT EXISTS `prices`
(
    `id`                            BIGINT NOT NULL AUTO_INCREMENT COMMENT 'Autoincrement ID',
    `brand_id`                      BIGINT NOT NULL COMMENT 'Brand ID',
    `start_date`                    TIMESTAMP NOT NULL COMMENT 'Start date',
    `end_date`                      TIMESTAMP NOT NULL COMMENT 'End date',
    `price_list`                    BIGINT NOT NULL COMMENT 'Price list ID',
    `product_id`                    BIGINT NOT NULL COMMENT 'Product ID',
    `priority`                      INT NOT NULL COMMENT 'Priority',
    `price`                         DECIMAL(10, 2) NOT NULL COMMENT 'Price',
    `currency`                      CHAR(3) NOT NULL COMMENT 'Currency',

    PRIMARY KEY (`id`)
);