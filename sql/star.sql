/*
Navicat MySQL Data Transfer

Source Server         : localhost_root
Source Server Version : 50556
Source Host           : localhost:3306
Source Database       : star

Target Server Type    : MYSQL
Target Server Version : 50556
File Encoding         : 65001

Date: 2018-04-25 08:38:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bill
-- ----------------------------
DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `wechat_number` varchar(64) DEFAULT NULL COMMENT '微信号',
  `wechat_name` varchar(64) DEFAULT NULL COMMENT '微信名',
  `people_number` int(11) DEFAULT NULL,
  `money_sum` double DEFAULT NULL,
  `create_user` int(11) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `customer_source` varchar(32) DEFAULT NULL COMMENT '客户来源',
  `billing_status` varchar(32) DEFAULT NULL COMMENT '账单状态',
  `img_path` varchar(128) DEFAULT NULL,
  `if_see` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='账单表';

-- ----------------------------
-- Records of bill
-- ----------------------------
INSERT INTO `bill` VALUES ('1', 'wechat_number_test1', 'wechat_name_test1', '1', '0.5', '1', '2018-04-04 21:53:45', 'dd', 'wdk', 'img_1_987cf8b4-945c-40f0-a2aa-d2eebd62f35b.jpg', '1');
INSERT INTO `bill` VALUES ('2', 'wechat_number_test2', 'wechat_name_test2', '5', '555', '2', '2018-04-05 00:38:19', 'dd', 'ydk', 'img_1_987cf8b4-945c-40f0-a2aa-d2eebd62f35b.jpg', '1');
INSERT INTO `bill` VALUES ('3', 'wechat_number_test3', 'wechat_name_test3', '5', '1000', '2', '2018-04-05 09:49:55', 'tg', 'ydk', 'img_1_987cf8b4-945c-40f0-a2aa-d2eebd62f35b.jpg', '1');
INSERT INTO `bill` VALUES ('5', 'wechat_number_test5', 'wechat_name_test5', '5', '10000', '1', '2018-04-05 09:52:32', 'dd', 'ydk', 'img_1_987cf8b4-945c-40f0-a2aa-d2eebd62f35b.jpg', '1');
INSERT INTO `bill` VALUES ('8', 'wechat_number_test8', 'wechat_name_test8', '5', '100', '1', '2018-04-06 09:52:59', 'dd', 'ydk', 'img_1_987cf8b4-945c-40f0-a2aa-d2eebd62f35b.jpg', '1');
INSERT INTO `bill` VALUES ('9', 'wechat_number_test9', 'wechat_name_test9', '5', '100', '39', '2018-04-06 09:52:59', 'dd', 'ydk', 'img_1_987cf8b4-945c-40f0-a2aa-d2eebd62f35b.jpg', '1');
INSERT INTO `bill` VALUES ('10', 'wechat_number_test10', 'wechat_name_test10', '5', '100', '39', '2018-04-06 09:52:59', 'dd', 'wdk', 'img_1_987cf8b4-945c-40f0-a2aa-d2eebd62f35b.jpg', '1');
INSERT INTO `bill` VALUES ('11', 'wechat_number_test11', 'wechat_name_test11', '1', '100', '39', '2018-04-06 09:52:59', 'dd', 'wdk', 'img_1_987cf8b4-945c-40f0-a2aa-d2eebd62f35b.jpg', '1');
INSERT INTO `bill` VALUES ('12', 'wechat_number_test12', 'wechat_name_test12', '1', '100', '39', '2018-04-06 09:52:59', 'dd', 'wdk', 'img_1_987cf8b4-945c-40f0-a2aa-d2eebd62f35b.jpg', '1');
INSERT INTO `bill` VALUES ('13', 'wechat_number_test13', 'wechat_name_test13', '1', '100', '1', '2018-04-06 09:52:59', 'dd', 'ydk', 'img_1_987cf8b4-945c-40f0-a2aa-d2eebd62f35b.jpg', '1');
INSERT INTO `bill` VALUES ('14', 'wechat_number_test14', 'wechat_name_test14', '1', '250', '1', '2018-04-06 09:52:59', 'dd', 'ydk', 'img_1_987cf8b4-945c-40f0-a2aa-d2eebd62f35b.jpg', '1');
INSERT INTO `bill` VALUES ('15', 'wechat_number_test15', 'wechat_name_test15', '3', '200', '1', '2018-04-06 09:52:59', 'dd', 'ydk', 'img_1_987cf8b4-945c-40f0-a2aa-d2eebd62f35b.jpg', '1');
INSERT INTO `bill` VALUES ('16', 'wechat_number_test16', 'wechat_name_test16', '3', '200', '1', '2018-04-05 00:00:00', 'dd', 'ydk', 'img_1_987cf8b4-945c-40f0-a2aa-d2eebd62f35b.jpg', '1');
INSERT INTO `bill` VALUES ('17', 'wechat_number_test17', 'wechat_name_test17', '3', '200', '2', '2018-04-07 00:00:00', 'dd', 'ydk', 'img_1_987cf8b4-945c-40f0-a2aa-d2eebd62f35b.jpg', '1');
INSERT INTO `bill` VALUES ('18', 'wechat_number_test18', 'wechat_name_test18', '3', '200', '2', '2018-04-07 00:00:00', 'dd', 'wdk', 'img_1_987cf8b4-945c-40f0-a2aa-d2eebd62f35b.jpg', '1');
INSERT INTO `bill` VALUES ('19', 'wechat_number_test19', 'wechat_name_test19', '3', '200', '2', '2018-04-07 00:00:00', 'dd', 'wdk', 'img_1_987cf8b4-945c-40f0-a2aa-d2eebd62f35b.jpg', '1');
INSERT INTO `bill` VALUES ('20', 'wechat_number_test20', 'wechat_name_test20', '3', '250', '2', '2018-04-07 00:00:00', 'dd', 'wdk', 'img_1_987cf8b4-945c-40f0-a2aa-d2eebd62f35b.jpg', '1');
INSERT INTO `bill` VALUES ('21', 'wechat_number_test21', 'wechat_name_test21', '3', '250', '2', '2018-04-07 00:00:00', 'dd', 'wdk', 'img_1_987cf8b4-945c-40f0-a2aa-d2eebd62f35b.jpg', '1');
INSERT INTO `bill` VALUES ('22', 'wechat_number_test22', 'wechat_name_test22', '3', '250', '2', '2018-04-07 00:00:00', 'tg', 'wdk', 'img_1_987cf8b4-945c-40f0-a2aa-d2eebd62f35b.jpg', '1');
INSERT INTO `bill` VALUES ('23', 'wechat_number_test23', 'wechat_name_test23', '3', '250', '2', '2018-04-07 00:00:00', 'tg', 'wdk', 'img_1_987cf8b4-945c-40f0-a2aa-d2eebd62f35b.jpg', '1');
INSERT INTO `bill` VALUES ('24', 'wechat_number_test24', 'wechat_name_test24', '3', '250', '1', '2018-04-07 00:00:00', 'tg', 'ydk', 'img_1_987cf8b4-945c-40f0-a2aa-d2eebd62f35b.jpg', '1');
INSERT INTO `bill` VALUES ('25', 'wechat_number_test25', 'wechat_name_test25', '3', '250', '1', '2018-04-05 00:00:00', 'tg', 'ydk', 'img_1_987cf8b4-945c-40f0-a2aa-d2eebd62f35b.jpg', '1');
INSERT INTO `bill` VALUES ('26', 'wechat_number_test26', 'wechat_name_test26', '1', '200', '39', '2018-04-05 00:00:00', 'tg', 'ydk', 'img_1_987cf8b4-945c-40f0-a2aa-d2eebd62f35b.jpg', '1');
INSERT INTO `bill` VALUES ('27', 'wechat_number_test27', 'wechat_name_test27', '1', '200', '39', '2018-04-05 00:00:00', 'tg', 'ydk', 'img_1_987cf8b4-945c-40f0-a2aa-d2eebd62f35b.jpg', '1');
INSERT INTO `bill` VALUES ('28', 'wechat_number_test28', 'wechat_name_test28', '1', '200', '39', '2018-04-05 00:00:00', 'dd', 'wdk', 'img_1_987cf8b4-945c-40f0-a2aa-d2eebd62f35b.jpg', '1');
INSERT INTO `bill` VALUES ('29', 'wechat_number_test29', 'wechat_name_test29', '1', '200', '39', '2018-03-20 00:00:00', 'dd', 'wdk', 'img_1_987cf8b4-945c-40f0-a2aa-d2eebd62f35b.jpg', '1');
INSERT INTO `bill` VALUES ('30', '22', '22', '5', '200', '39', '2018-03-20 00:00:00', 'dd', 'wdk', 'img_1_987cf8b4-945c-40f0-a2aa-d2eebd62f35b.jpg', '1');
INSERT INTO `bill` VALUES ('31', 'wechat_number_test31', 'wechat_name_test31', '5', '200', '1', '2018-03-20 00:00:00', 'dd', 'wdk', 'img_1_987cf8b4-945c-40f0-a2aa-d2eebd62f35b.jpg', '1');
INSERT INTO `bill` VALUES ('32', 'wechat_number_test32', 'wechat_name_test32', '5', '200', '2', '2018-03-20 00:00:00', 'dd', 'ydk', 'img_1_987cf8b4-945c-40f0-a2aa-d2eebd62f35b.jpg', '1');
INSERT INTO `bill` VALUES ('33', 'wechat_number_test33', 'wechat_name_test33', '5', '200', '2', '2018-03-20 00:00:00', 'dd', 'ydk', 'img_1_987cf8b4-945c-40f0-a2aa-d2eebd62f35b.jpg', '1');
INSERT INTO `bill` VALUES ('34', 'wechat_number_test34', 'wechat_name_test34', '5', '200', '2', '2018-04-05 00:00:00', 'dd', 'ydk', 'img_1_987cf8b4-945c-40f0-a2aa-d2eebd62f35b.jpg', '1');
INSERT INTO `bill` VALUES ('35', 'wechat_number_test35', 'wechat_name_test35', '5', '200', '2', '2018-04-05 00:00:00', 'dd', 'ydk', 'img_1_987cf8b4-945c-40f0-a2aa-d2eebd62f35b.jpg', '1');
INSERT INTO `bill` VALUES ('36', 'wechat_number_test36', 'wechat_name_test36', '5', '200', '39', '2018-04-06 01:49:06', 'tg', 'ydk', 'img_39_9a387877-dad3-467f-a231-59e2aed129b7.jpg', '1');
INSERT INTO `bill` VALUES ('37', '9999900110', '9999900110', '50', '1000', '2', '2018-04-06 13:26:37', 'tg', 'ydk', 'img_2_1a41077d-f437-4087-b9b1-74090d288429.jpg', '1');
INSERT INTO `bill` VALUES ('38', '123', '123', '1', '1', '1', '2018-04-06 14:28:37', 'tg', 'ydk', null, '1');
INSERT INTO `bill` VALUES ('39', '12333', '666666', '321', '10', '1', '2018-04-06 14:29:45', 'tg', 'ydk', null, '1');
INSERT INTO `bill` VALUES ('40', '123456', '123456', '123456', '123456', '42', '2018-04-08 16:14:13', 'tg', 'wdk', null, '0');

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `qq_number` varchar(32) DEFAULT NULL COMMENT 'QQ号',
  `qq_name` varchar(64) DEFAULT NULL COMMENT 'QQ名',
  `wechat_number` varchar(64) DEFAULT NULL COMMENT '微信号',
  `wechat_name` varchar(64) DEFAULT NULL COMMENT '微信名',
  `create_user` int(11) DEFAULT NULL COMMENT '创建人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `customer_source` varchar(32) DEFAULT NULL COMMENT '客户来源',
  `customer_type` varchar(32) DEFAULT NULL COMMENT '客户类型',
  `if_see` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8 COMMENT='客户表';

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('53', '99999999921', 'qq_name_test20', 'wechat_number_test80', 'wechat_name_test21', '1', '2018-04-12 22:28:18', 'tg', 'th', '0');
INSERT INTO `customer` VALUES ('54', '99999999920', 'qq_name_test20', 'wechat_number_test20', 'wechat_name_test20', '1', '2018-04-12 22:28:18', 'zmt', 'th', '0');
INSERT INTO `customer` VALUES ('55', '99999999919', 'qq_name_test19', 'wechat_number_test19', 'wechat_name_test19', '1', '2018-04-12 22:28:18', 'zmt', 'yhf', '0');
INSERT INTO `customer` VALUES ('56', '99999999918', 'qq_name_test18', 'wechat_number_test18', 'wechat_name_test18', '1', '2018-04-12 22:28:18', 'zmt', 'yhf', '0');
INSERT INTO `customer` VALUES ('57', '99999999917', 'qq_name_test17', 'wechat_number_test17', 'wechat_name_test17', '1', '2018-04-12 22:28:18', 'tg', 'yhf', '0');
INSERT INTO `customer` VALUES ('58', '99999999916', 'qq_name_test16', 'wechat_number_test16', 'wechat_name_test16', '1', '2018-04-12 22:28:18', 'tg', 'th', '0');
INSERT INTO `customer` VALUES ('59', '99999999915', 'qq_name_test15', 'wechat_number_test15', 'wechat_name_test15', '1', '2018-04-12 22:28:18', 'tg', 'th', '0');
INSERT INTO `customer` VALUES ('60', '123456', '123456', '123456', '123456', '1', '2018-04-12 22:28:18', 'zmt', 'whf', '0');
INSERT INTO `customer` VALUES ('61', '555555', '55', 'dd', '55', '1', '2018-04-12 22:28:18', 'zmt', 'th', '0');
INSERT INTO `customer` VALUES ('62', '9999900110', '9999900110', '9999900110', '9999900110', '1', '2018-04-12 22:28:18', 'zmt', 'yhf', '0');
INSERT INTO `customer` VALUES ('63', '99999999938', 'qq_name_test38', 'wechat_number_test38', 'wechat_name_test38', '1', '2018-04-12 22:28:18', 'tg', 'whf', '0');
INSERT INTO `customer` VALUES ('64', '99999999937', 'qq_name_test37', 'wechat_number_test37', 'wechat_name_test37', '1', '2018-04-12 22:28:18', 'tg', 'yhf', '0');
INSERT INTO `customer` VALUES ('65', '99999999927', 'qq_name_test27', 'wechat_number_test27', 'wechat_name_test27', '1', '2018-04-12 22:28:18', 'dd', 'whf', '0');
INSERT INTO `customer` VALUES ('66', '99999999936', 'qq_name_test36', 'wechat_number_test36', 'wechat_name_test36', '1', '2018-04-12 22:28:18', 'dd', 'th', '0');
INSERT INTO `customer` VALUES ('67', '99999999935', 'qq_name_test35', 'wechat_number_test35', 'wechat_name_test35', '1', '2018-04-12 22:28:18', 'tg', 'th', '0');
INSERT INTO `customer` VALUES ('68', '99999999923', 'qq_name_test23', 'wechat_number_test23', 'wechat_name_test23', '1', '2018-04-12 22:28:18', 'tg', 'th', '0');
INSERT INTO `customer` VALUES ('69', '99999999924', 'qq_name_test24', 'wechat_number_test24', 'wechat_name_test24', '1', '2018-04-12 22:28:18', 'tg', 'th', '1');
INSERT INTO `customer` VALUES ('70', '99999999934', 'qq_name_test34', 'wechat_number_test34', 'wechat_name_test34', '1', '2018-04-12 22:28:18', 'tg', 'th', '1');
INSERT INTO `customer` VALUES ('71', '99999999926', 'qq_name_test26', 'wechat_number_test26', 'wechat_name_test26', '1', '2018-04-12 22:28:18', 'dd', 'whf', '1');
INSERT INTO `customer` VALUES ('72', '99999999925', 'qq_name_test25', 'wechat_number_test25', 'wechat_name_test25', '1', '2018-04-12 22:28:18', 'dd', 'whf', '1');
INSERT INTO `customer` VALUES ('73', '99999999922', 'qq_name_test22', 'wechat_number_test22', 'wechat_name_test22', '1', '2018-04-12 22:28:18', 'tg', 'th', '1');
INSERT INTO `customer` VALUES ('74', '99999999914', 'qq_name_test14', 'wechat_number_test14', 'wechat_name_test14', '1', '2018-04-12 22:28:18', 'tg', 'yhf', '1');
INSERT INTO `customer` VALUES ('75', '9999999998', 'qq_name_test8', 'wechat_number_test8', 'wechat_name_test8', '1', '2018-04-12 22:28:18', 'dd', 'th', '1');
INSERT INTO `customer` VALUES ('76', '9999999999', 'qq_name_test9', 'wechat_number_test9', 'wechat_name_test9', '1', '2018-04-12 22:28:18', 'dd', 'th', '1');
INSERT INTO `customer` VALUES ('77', '99999999910', 'qq_name_test10', 'wechat_number_test10', 'wechat_name_test10', '1', '2018-04-12 22:28:18', 'tg', 'th', '1');
INSERT INTO `customer` VALUES ('78', '99999999911', 'qq_name_test11', 'wechat_number_test11', 'wechat_name_test11', '1', '2018-04-12 22:28:18', 'tg', 'th', '0');
INSERT INTO `customer` VALUES ('79', '99999999912', 'qq_name_test12', 'wechat_number_test12', 'wechat_name_test12', '1', '2018-04-12 22:28:18', 'dd', 'yhf', '0');
INSERT INTO `customer` VALUES ('80', '99999999913', 'qq_name_test13', 'wechat_number_test13', 'wechat_name_test13', '1', '2018-04-12 22:28:18', 'dd', 'yhf', '0');
INSERT INTO `customer` VALUES ('81', '9999999997', 'qq_name_test7', 'wechat_number_test7', 'wechat_name_test7', '1', '2018-04-12 22:28:18', 'dd', 'th', '0');
INSERT INTO `customer` VALUES ('82', '9999999995', 'qq_name_test5', 'wechat_number_test5', 'wechat_name_test5', '1', '2018-04-12 22:28:19', 'tg', 'yhf', '1');
INSERT INTO `customer` VALUES ('83', '9999999994', 'qq_name_test4', 'wechat_number_test4', 'wechat_name_test4', '1', '2018-04-12 22:28:19', 'tg', 'yhf', '1');
INSERT INTO `customer` VALUES ('84', '9999999993', 'qq_name_test3', 'wechat_number_test3', 'wechat_name_test3', '1', '2018-04-12 22:28:19', 'zmt', 'whf', '1');
INSERT INTO `customer` VALUES ('85', '9999999992', 'qq_name_test2', 'wechat_number_test2', 'wechat_name_test2', '1', '2018-04-12 22:28:19', 'tg', 'whf', '1');
INSERT INTO `customer` VALUES ('86', '9999999991', 'qq_name_test1', 'wechat_number_test1', 'wechat_name_test1', '1', '2018-04-12 22:28:19', 'zmt', 'th', '1');
INSERT INTO `customer` VALUES ('87', '99999999933', 'qq_name_test33', 'wechat_number_test33', 'wechat_name_test33', '1', '2018-04-12 22:28:19', 'dd', 'th', '1');
INSERT INTO `customer` VALUES ('88', '99999999931', 'qq_name_test31', 'wechat_number_test31', 'wechat_name_test31', '1', '2018-04-12 22:28:19', 'zmt', 'th', '1');
INSERT INTO `customer` VALUES ('89', '99999999930', 'qq_name_test30', 'wechat_number_test30', 'wechat_name_test30', '1', '2018-04-12 22:28:19', 'zmt', 'whf', '1');
INSERT INTO `customer` VALUES ('90', '99999999929', 'qq_name_test29', 'wechat_number_test29', 'wechat_name_test29', '1', '2018-04-12 22:28:19', 'zmt', 'whf', '1');
INSERT INTO `customer` VALUES ('93', '99999999932', 'qq_name_test32', 'wechat_number_test32', 'wechat_name_test32', '1', '2018-04-12 22:30:07', 'dd', 'th', '1');
INSERT INTO `customer` VALUES ('94', '99999999928', 'qq_name_test28', 'wechat_number_test28', 'wechat_name_test28', '1', '2018-04-12 22:30:07', 'dd', 'whf', '1');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(32) NOT NULL COMMENT '真实姓名',
  `username` varchar(32) NOT NULL COMMENT '用户名',
  `password` varchar(128) NOT NULL COMMENT '密码',
  `role` varchar(32) NOT NULL COMMENT '用户角色',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='用户信息表';

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', '管理员', 'admin', '$2a$04$xcTX1RMpJLpSE1hvS/mVkO4hDlU3MxEi95rAG./GnfgAAzYU7u4O.', 'ADMIN', '2018-04-01 09:41:08');
INSERT INTO `user_info` VALUES ('2', '普通用户', 'user', '$2a$04$EnlqwzILueuclg5gDN/XzeGnQzWu8lAU.o2sgELU5N.S78q7pFBdC', 'ADMIN', '2018-04-01 09:41:13');
INSERT INTO `user_info` VALUES ('39', '测试用户2', 'test', '$2a$04$0rm8SjJ84gFANYSUQCN4LejzYeV0Dh8aCzQhP7keb1cC8xDPY6DAq', 'USER', '2018-04-04 09:49:54');
INSERT INTO `user_info` VALUES ('40', '测试用户', 'test2', '$2a$04$Mzlaa2XAhLIQhxwgkP30deZfOAiplZB3HBFgFDbf6zFnfDxo6zC.y', 'USER', '2018-04-06 13:01:02');
INSERT INTO `user_info` VALUES ('41', 'dddddd', 'dddddd', '$2a$04$3FUi/w4VFFW2GC7m2QrgyOyg9JrV9qbv2yBJP7FPYvTIFPhWmal/y', 'USER', '2018-04-08 16:04:12');
INSERT INTO `user_info` VALUES ('42', '123456', '123456', '$2a$04$JW4wFhJapxbznrNE9My8eOXHNGBpw.Sx2amx64uvUB1rC7cBz7OlW', 'USER', '2018-04-08 16:13:51');
