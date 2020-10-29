DROP TABLE IF EXISTS `t_order`;

CREATE TABLE `t_order` (
  `order_id` bigint(20) unsigned NOT NULL COMMENT '订单id',
  `user_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '用户id',
  `total_price` bigint(20) NOT NULL DEFAULT '0' COMMENT '总价',
  `address` varchar(1024) NOT NULL  DEFAULT '' COMMENT '订单收货地址',
  `status` tinyint(4) NOT NULL  DEFAULT '0' COMMENT '订单状态',
  `deleted` tinyint(4) NOT NULL  DEFAULT '0' COMMENT '是否被删除',
  `add_time` datetime NOT NULL  DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `mod_time` datetime NOT NULL  DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `version` int(11) NOT NULL COMMENT '数据版本',
  PRIMARY KEY (`order_id`),
  KEY `idx_uid` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';


DROP TABLE IF EXISTS `t_order_item`;
CREATE TABLE `t_order_item` (
  `item_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '订单项目id',
  `order_id` bigint(20) unsigned NOT NULL COMMENT '订单id',
  `goods` varchar(1024) NOT NULL  DEFAULT '' COMMENT '商品详情',
  `count` int(8) NOT NULL  DEFAULT '0' COMMENT '商品数量',
  `deleted` tinyint(4) NOT NULL  DEFAULT '0' COMMENT '是否被删除',
  `add_time` datetime NOT NULL  DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `mod_time` datetime NOT NULL  DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `version` int(11) NOT NULL COMMENT '数据版本',
  PRIMARY KEY (`item_id`),
  KEY `idx_order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单项目表';