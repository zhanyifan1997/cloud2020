CREATE DATABASE seata_order;

CREATE DATABASE seata_storage;

CREATE DATABASE seata_account;

CREATE TABLE `seata_order`.`t_order`  (
  `id` bigint(11) NOT NULL,
  `user_id` bigint(11) NULL DEFAULT NULL COMMENT '用户id',
  `product_id` bigint(11) NULL DEFAULT NULL COMMENT '产品id',
  `count` int(11) NULL DEFAULT NULL COMMENT '数量',
  `money` int(11) NULL DEFAULT NULL COMMENT '金额',
  `status` int(1) NULL DEFAULT NULL COMMENT '订单状态0创建中1已完结',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

CREATE TABLE `seata_storage`.t_storage`  (
  `id` bigint(11) NOT NULL,
  `product_id` bigint(11) NULL DEFAULT NULL COMMENT '产品id',
  `total` int(11) NULL DEFAULT NULL COMMENT '总库存',
  `used` int(11) NULL DEFAULT NULL COMMENT '已用库存',
  `residue` int(11) NULL DEFAULT NULL COMMENT '剩余库存',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

INSERT INTO `seata_storage`.`t_storage` VALUES (1, 1, 100, 0, 100)

CREATE TABLE `seata_account`.`t_account`  (
  `id` bigint(11) NOT NULL,
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `total` decimal(10, 0) NULL DEFAULT NULL COMMENT '总额度',
  `used` decimal(10, 0) NULL DEFAULT NULL COMMENT '已用额度',
  `residue` decimal(10, 0) NULL DEFAULT NULL COMMENT '剩余可用额度',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

INSERT INTO `seata_account`.`t_account` VALUES (1, 1, 1000, 0, 1000);

# undo_log
CREATE TABLE `undo_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `branch_id` bigint(20) NOT NULL,
  `xid` varchar(100) NOT NULL,
  `context` varchar(128) NOT NULL,
  `rollback_info` longblob NOT NULL,
  `log_status` int(11) NOT NULL,
  `log_created` datetime NOT NULL,
  `log_modified` datetime NOT NULL,
  `ext` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;



