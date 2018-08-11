/*
Navicat MySQL Data Transfer

Source Server         : localhost_root
Source Server Version : 50556
Source Host           : localhost:3306
Source Database       : teacher_evaluation

Target Server Type    : MYSQL
Target Server Version : 50556
File Encoding         : 65001

Date: 2018-08-11 10:02:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for star_sys_config
-- ----------------------------
DROP TABLE IF EXISTS `star_sys_config`;
CREATE TABLE `star_sys_config` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(64) NOT NULL COMMENT '配置项名称',
  `text` varchar(128) DEFAULT NULL COMMENT '配置项描述',
  `value` varchar(64) NOT NULL COMMENT '配置项值',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user` int(11) DEFAULT NULL COMMENT '更新人',
  `enable` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='系统通用配置的数据表';

-- ----------------------------
-- Records of star_sys_config
-- ----------------------------
INSERT INTO `star_sys_config` VALUES ('1', 'SYSTEM_NAME', '系统名称', 'Star 快速开发平台', '2018-05-04 00:00:00', '1', '1');
INSERT INTO `star_sys_config` VALUES ('2', 'PASSWORD_UPDATE_DAYS', '密码定期更新天数, 0为不限制', '30', '2018-05-04 00:00:00', '1', '1');
INSERT INTO `star_sys_config` VALUES ('3', 'PASSWORD_LENGTH_MIN', '密码长度最小, 0为不限制', '6', '2018-05-04 00:00:00', '1', '1');
INSERT INTO `star_sys_config` VALUES ('4', 'PASSWORD_LENGTH_MAX', '密码长度最大, 0为不限制', '15', '2018-05-04 00:00:00', '1', '1');
INSERT INTO `star_sys_config` VALUES ('5', 'PASSWORD_COMPLEXITY', '密码复杂度要求, 0为不限制', '2', '2018-05-04 00:00:00', '1', '1');
INSERT INTO `star_sys_config` VALUES ('6', 'PASSWORD_COMPLEXITY_VALUE', '密码复杂度要求正则, PASSWORD_COMPLEXITY为4时启用', '', '2018-05-04 00:00:00', '1', '1');
INSERT INTO `star_sys_config` VALUES ('7', 'PASSWORD_FAILS_COUNT', '错误密码次数, 0为不限制', '3', '2018-05-04 00:00:00', '1', '1');
INSERT INTO `star_sys_config` VALUES ('8', 'SYSTEM_LOGO_BAR', '系统导航栏logo，路径', '/assets/avatars/logo.png', '2018-05-04 00:00:00', '1', '1');
INSERT INTO `star_sys_config` VALUES ('10', 'SYSTEM_LOG_ENABLE', '是否启用系统日志', 'true', '2018-05-04 00:00:00', '1', '1');
INSERT INTO `star_sys_config` VALUES ('11', 'SYSTEM_EMAIL', '联系人邮箱', 'admin@loverqi.cn', '2018-05-04 00:00:00', '1', '1');

-- ----------------------------
-- Table structure for star_sys_department
-- ----------------------------
DROP TABLE IF EXISTS `star_sys_department`;
CREATE TABLE `star_sys_department` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(64) NOT NULL COMMENT '部门名称',
  `enable` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='部门表';

-- ----------------------------
-- Records of star_sys_department
-- ----------------------------

-- ----------------------------
-- Table structure for star_sys_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `star_sys_dictionary`;
CREATE TABLE `star_sys_dictionary` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(64) NOT NULL COMMENT '字典名',
  `text` varchar(128) DEFAULT NULL COMMENT '字典注释',
  `value` varchar(64) NOT NULL COMMENT '字典值',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user` int(11) DEFAULT NULL COMMENT '更新人',
  `enable` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典表';

-- ----------------------------
-- Records of star_sys_dictionary
-- ----------------------------

-- ----------------------------
-- Table structure for star_sys_log
-- ----------------------------
DROP TABLE IF EXISTS `star_sys_log`;
CREATE TABLE `star_sys_log` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `path` varchar(255) NOT NULL COMMENT '访问路径',
  `text` varchar(64) DEFAULT NULL COMMENT '功能权限名',
  `local_path` varchar(64) NOT NULL COMMENT '访问地址',
  `remote_addr` varchar(64) NOT NULL COMMENT '客户ip地址',
  `access_time` datetime NOT NULL COMMENT '访问时间',
  `access_user` int(11) DEFAULT NULL COMMENT '访问用户',
  `access_user_name` varchar(32) DEFAULT NULL,
  `enable` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1548 DEFAULT CHARSET=utf8 COMMENT='日志表';

-- ----------------------------
-- Records of star_sys_log
-- ----------------------------
INSERT INTO `star_sys_log` VALUES ('1', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-05 14:36:23', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('2', '/132131.html', '刷新参数', '127.0.0.1:80', '127.0.0.1', '2018-05-05 14:36:40', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('3', '/132132.html', '参数设置', '127.0.0.1:80', '127.0.0.1', '2018-05-05 14:36:41', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('4', '/132231.html', '添加报表', '127.0.0.1:80', '127.0.0.1', '2018-05-05 14:36:43', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('5', '/132232.html', '查看报表', '127.0.0.1:80', '127.0.0.1', '2018-05-05 14:36:44', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('6', '/132331.html', '添加角色', '127.0.0.1:80', '127.0.0.1', '2018-05-05 14:36:45', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('7', '/132332.html', '查看角色', '127.0.0.1:80', '127.0.0.1', '2018-05-05 14:36:46', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('11', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-05 14:38:41', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('12', '/1221.html', '添加用户', '127.0.0.1:80', '127.0.0.1', '2018-05-05 14:38:43', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('13', '/1222.html', '查看用户', '127.0.0.1:80', '127.0.0.1', '2018-05-05 14:38:45', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('14', '/132131.html', '刷新参数', '127.0.0.1:80', '127.0.0.1', '2018-05-05 14:38:46', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('15', '/132132.html', '参数设置', '127.0.0.1:80', '127.0.0.1', '2018-05-05 14:38:47', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('16', '/132231.html', '添加报表', '127.0.0.1:80', '127.0.0.1', '2018-05-05 14:38:49', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('17', '/132232.html', '查看报表', '127.0.0.1:80', '127.0.0.1', '2018-05-05 14:38:50', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('18', '/132331.html', '添加角色', '127.0.0.1:80', '127.0.0.1', '2018-05-05 14:38:50', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('19', '/132332.html', '查看角色', '127.0.0.1:80', '127.0.0.1', '2018-05-05 14:38:51', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('20', '/132431.html', '添加菜单', '127.0.0.1:80', '127.0.0.1', '2018-05-05 14:38:52', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('21', '/132432.html', '查看菜单', '127.0.0.1:80', '127.0.0.1', '2018-05-05 14:38:53', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('22', '/132431.html', '添加菜单', '127.0.0.1:80', '127.0.0.1', '2018-05-05 14:39:07', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('23', '/132131.html', '刷新参数', '127.0.0.1:80', '127.0.0.1', '2018-05-05 14:39:08', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('24', '/132231.html', '添加报表', '127.0.0.1:80', '127.0.0.1', '2018-05-05 14:39:10', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('25', '/132331.html', '添加角色', '127.0.0.1:80', '127.0.0.1', '2018-05-05 14:39:12', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('26', '/132431.html', '添加菜单', '127.0.0.1:80', '127.0.0.1', '2018-05-05 14:39:13', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('27', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-05 14:48:57', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('28', '/11.html', '开发样例', '127.0.0.1:80', '127.0.0.1', '2018-05-05 14:49:00', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('29', '/1326.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-05-05 14:49:04', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('30', '/11.html', '开发样例', '127.0.0.1:80', '127.0.0.1', '2018-05-05 15:09:29', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('31', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-05 15:09:31', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('32', '/1221.html', '添加用户', '127.0.0.1:80', '127.0.0.1', '2018-05-05 15:09:33', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('33', '/1222.html', '查看用户', '127.0.0.1:80', '127.0.0.1', '2018-05-05 15:17:12', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('34', '/12.html', '用户管理', '127.0.0.1:80', '127.0.0.1', '2018-05-05 15:17:54', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('35', '/1221.html', '添加用户', '127.0.0.1:80', '127.0.0.1', '2018-05-05 15:17:55', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('36', '/1222.html', '查看用户', '127.0.0.1:80', '127.0.0.1', '2018-05-05 15:18:34', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('37', '/1221.html', '添加用户', '127.0.0.1:80', '127.0.0.1', '2018-05-05 15:18:42', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('38', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-05 23:00:06', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('39', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-06 02:18:17', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('40', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-06 09:02:02', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('41', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-06 10:08:02', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('42', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-06 10:08:38', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('44', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-06 10:08:43', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('45', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-06 10:08:45', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('46', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-06 10:09:09', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('47', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-06 10:09:14', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('48', '/11.html', '开发样例', '127.0.0.1:80', '127.0.0.1', '2018-05-06 10:09:16', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('49', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-06 10:09:18', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('50', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-06 10:09:26', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('51', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-06 10:12:03', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('52', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-06 10:12:15', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('54', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-06 10:34:48', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('55', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-06 10:51:18', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('56', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-06 22:51:12', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('57', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-06 23:00:01', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('58', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-06 23:01:36', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('59', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-06 23:02:12', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('60', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-06 23:02:22', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('61', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-06 23:07:36', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('62', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-06 23:08:07', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('63', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-06 23:09:25', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('64', '/11.html', '开发样例', '127.0.0.1:80', '127.0.0.1', '2018-05-06 23:09:30', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('65', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-06 23:09:31', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('66', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-06 23:12:34', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('67', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-06 23:28:21', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('68', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-06 23:28:30', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('69', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-06 23:29:03', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('70', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-06 23:29:14', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('71', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-06 23:32:38', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('73', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-06 23:35:17', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('75', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-06 23:45:27', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('77', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-07 00:08:25', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('79', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-07 00:08:49', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('81', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-07 00:08:59', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('82', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-07 00:11:34', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('83', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-07 00:11:40', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('85', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-07 00:11:43', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('87', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-07 00:11:50', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('88', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-07 00:12:20', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('89', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-07 00:12:21', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('90', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-07 00:12:23', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('91', '/11.html', '开发样例', '127.0.0.1:80', '127.0.0.1', '2018-05-07 00:12:24', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('92', '/1221.html', '添加用户', '127.0.0.1:80', '127.0.0.1', '2018-05-07 00:12:27', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('93', '/1221.html', '添加用户', '127.0.0.1:80', '127.0.0.1', '2018-05-07 00:12:29', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('94', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-07 00:20:34', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('95', '/', '系统首页', '127.0.0.1:80', '192.168.1.101', '2018-05-07 00:21:26', '2', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('96', '/1221.html', '添加用户', '127.0.0.1:80', '192.168.1.101', '2018-05-07 00:21:31', '2', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('97', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-07 22:32:17', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('98', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-07 23:00:14', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('99', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-07 23:19:53', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('100', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-07 23:20:25', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('101', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-07 23:23:54', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('102', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-07 23:24:05', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('103', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-08 08:34:46', '2', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('104', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-08 08:35:02', '2', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('105', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-08 09:02:24', '2', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('106', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-08 09:04:20', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('107', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-08 09:04:33', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('108', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-08 09:12:23', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('109', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-08 09:12:25', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('110', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-08 09:12:31', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('111', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-08 09:12:33', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('112', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-08 09:22:00', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('113', '/index.html', '系统首页', '127.0.0.1:70', '127.0.0.1', '2018-05-08 09:22:04', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('114', '/11.html', '开发样例', '127.0.0.1:70', '127.0.0.1', '2018-05-08 09:22:07', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('115', '/index.html', '系统首页', '127.0.0.1:70', '127.0.0.1', '2018-05-08 09:22:08', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('116', '/1222.html', '查看用户', '127.0.0.1:70', '127.0.0.1', '2018-05-08 09:22:09', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('117', '/132331.html', '添加角色', '127.0.0.1:70', '127.0.0.1', '2018-05-08 09:22:12', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('118', '/1221.html', '添加用户', '127.0.0.1:80', '127.0.0.1', '2018-05-08 09:22:14', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('119', '/1222.html', '查看用户', '127.0.0.1:80', '127.0.0.1', '2018-05-08 09:22:15', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('120', '/132331.html', '添加角色', '127.0.0.1:80', '127.0.0.1', '2018-05-08 09:22:17', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('121', '/', '系统首页', '127.0.0.1:8080', '127.0.0.1', '2018-05-08 09:24:40', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('122', '/1221.html', '添加用户', '127.0.0.1:8080', '127.0.0.1', '2018-05-08 09:25:35', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('123', '/132331.html', '添加角色', '127.0.0.1:80', '127.0.0.1', '2018-05-08 09:30:34', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('124', '/132331.html', '添加角色', '127.0.0.1:80', '127.0.0.1', '2018-05-08 09:30:43', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('125', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-11 01:26:59', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('126', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-11 01:27:26', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('127', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-11 01:27:35', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('128', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-11 01:27:44', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('136', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-11 17:01:12', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('138', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-11 17:01:18', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('140', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-11 17:01:37', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('158', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-11 20:45:28', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('159', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-11 20:45:34', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('160', '/customer/view_customer.html', '查询客户', '127.0.0.1:80', '127.0.0.1', '2018-05-11 20:45:41', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('161', '/customer/view_customer.html', '查询客户', '127.0.0.1:80', '127.0.0.1', '2018-05-11 20:45:44', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('163', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-11 20:46:56', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('166', '/customer/view_customer.html', '查询客户', '127.0.0.1:80', '127.0.0.1', '2018-05-11 20:46:58', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('169', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-11 22:41:51', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('170', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-11 22:42:59', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('171', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-11 22:44:46', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('172', '/customer/view_customer.html', '查询客户', '127.0.0.1:80', '127.0.0.1', '2018-05-11 22:46:16', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('173', '/132131.html', '刷新参数', '127.0.0.1:80', '127.0.0.1', '2018-05-11 22:46:52', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('174', '/customer/view_customer.html', '查询客户', '127.0.0.1:80', '127.0.0.1', '2018-05-11 23:04:48', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('175', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-11 23:22:59', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('176', '/', '系统首页', '127.0.0.1:70', '127.0.0.1', '2018-05-12 00:55:29', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('177', '/customer/view_customer.html', '查询客户', '127.0.0.1:70', '127.0.0.1', '2018-05-12 00:55:32', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('178', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-30 08:34:48', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('179', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-30 09:03:12', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('180', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-30 09:03:31', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('181', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-30 09:06:16', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('183', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-30 09:47:57', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('242', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-30 10:05:56', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('270', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-30 10:25:39', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('273', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-30 10:25:57', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('336', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-30 10:55:20', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('337', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-30 11:00:34', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('341', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-30 11:08:35', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('345', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-30 11:09:38', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('351', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-31 23:01:43', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('352', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-31 23:01:45', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('353', '/customer/view_customer.html', '查询客户', '127.0.0.1:80', '127.0.0.1', '2018-05-31 23:01:53', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('354', '/customer/view_customer.html', '查询客户', '127.0.0.1:70', '127.0.0.1', '2018-05-31 23:02:04', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('358', '/customer/view_customer.html', '查询客户', '127.0.0.1:70', '127.0.0.1', '2018-05-31 23:02:49', '2', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('359', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-05-31 23:02:57', '2', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('362', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-06-01 09:28:59', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('363', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-06-01 09:29:02', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('364', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-06-01 09:29:30', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('365', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-06-01 09:29:32', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('367', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-06-01 09:29:55', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('368', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-06-01 09:31:06', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('369', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-06-01 09:40:26', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('370', '/customer/view_customer.html', '查询客户', '127.0.0.1:80', '127.0.0.1', '2018-06-01 09:40:31', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('372', '/customer/view_customer.html', '查询客户', '127.0.0.1:80', '127.0.0.1', '2018-06-01 12:26:39', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('375', '/customer/view_customer.html', '查询客户', '127.0.0.1:80', '127.0.0.1', '2018-06-01 12:49:11', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('377', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-06-03 14:54:43', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('380', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-06-04 08:08:47', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('381', '/customer/view_customer.html', '查询客户', '127.0.0.1:80', '127.0.0.1', '2018-06-04 08:08:51', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('388', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-06-04 09:55:28', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('390', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-06-04 09:56:49', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('392', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-06-04 10:00:53', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('394', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-06-04 10:01:52', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('399', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-06-04 10:03:42', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('401', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-06-04 10:03:55', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('403', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-06-04 10:05:17', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('404', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-06-04 10:05:30', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('406', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-06-04 10:06:54', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('409', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-06-04 10:07:15', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('410', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-06-04 10:07:26', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('411', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-06-04 10:07:46', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('412', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-06-04 10:09:17', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('417', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-06-04 20:02:16', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('421', '/11.html', '开发样例', '127.0.0.1:80', '127.0.0.1', '2018-06-04 20:49:55', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('422', '/customer/view_customer.html', '查询客户', '127.0.0.1:80', '127.0.0.1', '2018-06-04 20:49:59', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('423', '/customer/view_customer.html', '查询客户', '127.0.0.1:80', '127.0.0.1', '2018-06-04 20:50:02', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('424', '/11.html', '开发样例', '127.0.0.1:80', '127.0.0.1', '2018-06-04 20:51:08', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('427', '/11.html', '开发样例', '127.0.0.1:80', '127.0.0.1', '2018-06-04 20:51:29', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('430', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-06-04 20:51:46', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('432', '/11.html', '开发样例', '127.0.0.1:80', '127.0.0.1', '2018-06-04 20:51:50', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('433', '/customer/view_customer.html', '查询客户', '127.0.0.1:80', '127.0.0.1', '2018-06-04 20:51:50', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('435', '/11.html', '开发样例', '127.0.0.1:80', '127.0.0.1', '2018-06-04 20:51:54', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('437', '/customer/view_customer.html', '查询客户', '127.0.0.1:80', '127.0.0.1', '2018-06-04 21:20:12', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('438', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-04 21:22:12', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('440', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-04 21:22:23', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('441', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-04 21:22:56', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('444', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-04 21:27:44', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('447', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-04 22:34:26', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('448', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-04 22:34:50', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('449', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-04 22:35:58', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('450', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-04 22:36:04', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('451', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-04 22:36:49', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('452', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-04 22:36:50', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('453', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-04 22:37:39', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('454', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-04 22:37:40', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('455', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-04 22:37:50', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('456', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-04 22:38:15', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('457', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-04 22:45:15', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('458', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-04 22:46:01', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('459', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-04 22:46:02', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('460', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-04 22:46:55', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('461', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-04 22:47:22', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('462', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-04 22:47:36', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('463', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-04 22:47:37', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('464', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-04 22:54:57', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('465', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-04 23:02:34', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('466', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-04 23:03:31', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('471', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-04 23:10:25', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('472', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-04 23:14:19', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('473', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-04 23:14:36', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('474', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-04 23:14:54', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('475', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-04 23:15:07', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('476', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-04 23:20:50', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('477', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-04 23:34:02', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('478', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-04 23:56:25', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('479', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 00:01:57', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('480', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 00:03:46', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('481', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 00:04:07', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('482', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 00:04:33', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('483', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 00:06:58', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('484', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 00:07:03', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('485', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 00:07:17', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('486', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 00:08:32', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('487', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 00:09:18', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('488', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 00:11:23', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('489', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 00:14:23', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('490', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 00:14:45', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('491', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 00:20:27', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('492', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 00:39:08', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('493', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 00:39:21', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('494', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 00:40:16', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('495', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 00:40:56', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('496', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 00:45:54', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('497', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 00:56:35', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('498', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 01:06:03', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('499', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 01:12:43', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('500', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 01:18:04', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('501', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 01:18:20', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('502', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 01:19:13', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('503', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 01:19:37', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('504', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 01:26:32', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('505', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 01:30:49', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('507', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 19:06:34', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('509', '/customer/view_customer.html', '查询客户', '127.0.0.1:80', '127.0.0.1', '2018-06-05 21:31:32', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('511', '/customer/view_customer.html', '查询客户', '127.0.0.1:80', '127.0.0.1', '2018-06-05 21:38:16', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('512', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 22:34:16', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('513', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 22:54:20', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('514', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 22:54:40', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('515', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 22:54:46', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('516', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 22:55:25', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('517', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 22:57:21', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('518', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 22:59:29', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('519', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 23:02:32', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('520', '/customer/view_customer.html', '查询客户', '127.0.0.1:80', '127.0.0.1', '2018-06-05 23:06:34', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('521', '/customer/view_customer.html', '查询客户', '127.0.0.1:80', '127.0.0.1', '2018-06-05 23:11:41', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('522', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 23:11:43', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('523', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 23:15:28', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('524', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 23:16:57', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('525', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 23:17:54', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('526', '/customer/view_customer.html', '查询客户', '127.0.0.1:80', '127.0.0.1', '2018-06-05 23:17:56', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('527', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 23:17:59', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('528', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 23:18:10', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('529', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 23:18:13', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('530', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 23:19:48', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('531', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 23:24:15', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('532', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 23:27:06', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('533', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 23:28:18', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('534', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 23:29:05', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('535', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 23:39:38', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('536', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 23:40:17', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('537', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 23:40:19', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('538', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 23:40:28', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('539', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 23:41:05', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('540', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 23:41:16', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('541', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 23:42:07', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('542', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 23:42:08', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('543', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 23:42:50', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('544', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 23:43:11', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('545', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 23:43:13', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('546', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 23:46:25', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('547', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-05 23:52:00', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('548', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-06 00:04:36', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('549', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-06 00:08:24', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('550', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-06 00:08:47', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('551', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-06 00:12:32', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('552', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-06 00:14:54', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('553', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-06 00:21:59', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('554', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-06 00:22:20', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('555', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-06 00:24:24', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('556', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-06 00:24:30', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('557', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-06 00:24:32', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('558', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-06 00:25:07', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('559', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-06 00:31:28', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('560', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-06 00:32:00', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('561', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-06 00:33:19', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('562', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-06 00:33:22', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('563', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-06 00:33:23', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('564', '/customer/view_customer.html', '查询客户', '127.0.0.1:80', '127.0.0.1', '2018-06-06 00:33:24', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('565', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-06 00:33:26', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('566', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-06 00:35:17', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('567', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-06 00:35:44', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('568', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-06 00:35:45', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('569', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-06 00:36:50', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('570', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-06 00:38:14', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('571', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-06 00:38:48', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('572', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-06 00:38:51', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('573', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-06 00:42:29', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('574', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-06 00:42:50', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('575', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-06 00:43:09', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('576', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-06 00:43:19', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('577', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-06 00:43:21', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('578', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-06 00:43:34', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('579', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-06 00:44:21', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('580', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-06 00:45:38', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('581', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-06 00:47:29', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('582', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-06 00:47:52', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('583', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-06 00:48:57', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('584', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-06 00:49:10', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('585', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-06 00:49:34', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('586', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-06 00:49:45', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('587', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-06 00:50:26', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('588', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-06 00:50:40', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('589', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-06 00:51:21', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('590', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-06 00:54:18', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('591', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-06 00:54:56', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('592', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-06 00:55:31', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('593', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-06 16:17:05', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('594', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-06 22:47:42', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('595', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-06 22:52:13', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('596', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-06 22:52:17', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('597', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-06 22:54:13', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('598', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-06 22:55:20', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('599', '/customer/view_customer.html', '查询客户', '127.0.0.1:80', '127.0.0.1', '2018-06-06 22:55:22', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('600', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-06 22:55:25', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('601', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-06 22:56:46', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('602', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-06 22:57:00', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('603', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-06 22:57:08', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('604', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-06 23:05:59', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('605', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-06 23:36:13', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('606', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-06 23:36:32', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('607', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-06 23:37:21', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('608', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 01:06:39', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('609', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 01:07:31', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('610', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 01:22:46', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('611', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 01:23:44', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('612', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 01:23:56', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('613', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 01:24:11', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('614', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 01:29:21', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('615', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 01:29:39', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('616', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 01:34:37', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('617', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 01:37:20', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('618', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 01:37:33', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('619', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 01:40:06', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('620', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 01:42:21', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('621', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 01:42:28', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('622', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 01:42:44', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('623', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 01:42:56', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('624', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 01:46:28', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('625', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 01:46:43', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('626', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 01:47:34', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('627', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 01:48:30', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('628', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 01:48:38', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('629', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 01:50:12', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('630', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 01:51:27', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('631', '/customer/view_customer.html', '查询客户', '127.0.0.1:80', '127.0.0.1', '2018-06-07 02:04:46', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('632', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 02:17:59', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('633', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 02:27:33', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('634', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 02:28:23', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('635', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 02:29:19', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('636', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 02:37:34', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('637', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 02:38:15', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('638', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 02:38:47', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('639', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 02:40:08', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('640', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 02:44:17', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('642', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 02:46:31', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('643', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 02:46:34', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('644', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 02:46:35', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('645', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 02:47:33', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('646', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 02:49:48', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('647', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 02:49:51', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('648', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 02:49:58', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('649', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 02:50:03', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('650', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 02:50:05', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('651', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 02:50:08', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('652', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 02:56:09', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('653', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 02:56:12', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('654', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 02:56:14', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('655', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 02:57:42', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('656', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 02:58:48', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('657', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 02:58:52', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('658', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 02:58:53', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('659', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 02:58:55', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('660', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 02:58:56', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('661', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 02:58:58', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('662', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 02:59:00', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('663', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 02:59:01', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('664', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 02:59:03', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('665', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 02:59:05', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('666', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 02:59:07', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('667', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 02:59:08', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('668', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 02:59:10', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('669', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 02:59:11', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('670', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 02:59:13', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('671', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 02:59:15', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('672', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 02:59:18', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('673', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 09:26:01', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('674', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 09:26:47', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('675', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 09:26:55', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('676', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 09:28:36', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('677', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 09:29:05', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('678', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 09:29:10', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('679', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 09:35:53', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('680', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 09:35:55', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('681', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 09:35:55', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('682', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 09:35:56', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('683', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 09:36:06', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('684', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 09:36:08', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('685', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 09:36:09', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('686', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 09:36:10', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('687', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 09:36:12', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('688', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 09:36:13', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('689', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 09:36:14', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('690', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 09:39:48', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('691', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 11:22:07', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('692', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 11:22:52', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('693', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 11:25:53', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('694', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 11:29:26', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('695', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 11:30:10', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('696', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 12:06:05', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('697', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 12:06:36', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('698', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 12:07:18', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('699', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 12:07:45', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('700', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 12:11:07', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('701', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 12:11:20', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('702', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 12:14:03', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('703', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 12:14:48', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('704', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 12:15:41', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('705', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 12:15:49', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('706', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 12:16:06', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('707', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 12:17:49', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('708', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 12:17:56', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('709', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 12:18:05', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('710', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 12:19:09', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('711', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 12:19:24', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('712', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 12:19:34', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('713', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 12:19:46', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('714', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 16:05:00', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('715', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 16:06:52', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('716', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 16:08:06', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('717', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 16:40:09', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('718', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 16:41:27', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('719', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 16:41:29', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('720', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 16:41:31', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('721', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 16:41:33', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('722', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 16:41:34', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('723', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 16:41:36', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('724', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 16:41:38', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('725', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 16:41:41', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('726', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 16:41:42', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('727', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 16:41:44', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('728', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 16:41:45', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('729', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 16:41:47', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('730', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 16:41:49', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('731', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 16:43:48', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('732', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 16:45:11', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('733', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 16:46:57', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('734', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 16:47:15', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('735', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 17:11:17', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('736', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 17:21:17', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('737', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 17:22:50', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('739', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 17:23:22', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('741', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 17:23:31', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('744', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 17:24:27', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('747', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 17:24:52', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('748', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 17:25:06', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('749', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 17:25:25', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('750', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 17:25:31', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('751', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 17:25:32', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('752', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 17:25:36', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('753', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 17:26:30', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('757', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 17:26:49', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('760', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 17:28:35', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('761', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 17:29:15', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('762', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 17:32:50', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('767', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 17:35:10', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('769', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 17:35:26', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('770', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 17:35:50', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('771', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 17:36:54', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('774', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 17:48:45', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('775', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 17:49:24', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('776', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 17:49:56', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('777', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 17:50:38', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('778', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 17:51:01', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('781', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 17:52:17', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('782', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 17:52:33', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('783', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 17:53:36', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('784', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 17:54:40', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('785', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 17:55:54', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('786', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 17:57:16', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('787', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 17:59:07', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('788', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 17:59:09', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('789', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 17:59:14', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('790', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 18:01:59', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('791', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 18:02:11', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('793', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 18:03:21', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('794', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 18:04:54', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('795', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-07 18:05:36', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('798', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:02:16', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('799', '/customer/view_customer.html', '查询客户', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:02:20', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('800', '/11.html', '开发样例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:02:23', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('801', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:02:25', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('802', '/customer/view_customer.html', '查询客户', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:02:26', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('803', '/11.html', '开发样例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:02:30', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('804', '/customer/view_customer.html', '查询客户', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:02:31', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('805', '/11.html', '开发样例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:02:33', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('806', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:02:34', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('807', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:02:41', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('808', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:02:43', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('809', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:02:44', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('810', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:02:46', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('811', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:02:47', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('812', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:02:55', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('813', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:03:58', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('814', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:04:29', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('815', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:04:31', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('816', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:04:35', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('817', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:04:37', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('818', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:04:39', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('819', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:04:40', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('820', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:04:57', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('821', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:05:04', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('822', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:05:28', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('823', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:05:30', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('824', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:05:32', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('825', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:05:34', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('826', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:05:46', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('827', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:06:00', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('828', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:06:07', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('829', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:06:11', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('830', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:06:15', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('831', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:06:18', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('832', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:06:19', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('833', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:06:21', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('834', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:06:24', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('835', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:06:37', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('836', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:06:39', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('837', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:06:59', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('838', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:07:00', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('839', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:07:02', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('840', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:07:04', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('841', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:07:04', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('842', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:07:05', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('843', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:07:06', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('844', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:07:07', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('845', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:07:08', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('846', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:07:10', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('847', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:09:02', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('849', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:09:05', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('850', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:10:28', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('851', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:10:34', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('852', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:10:36', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('853', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:10:39', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('854', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:10:44', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('855', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:10:50', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('856', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:11:37', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('857', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:11:41', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('858', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:12:55', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('859', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:13:39', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('860', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:14:17', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('861', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:14:55', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('862', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:15:08', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('863', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:15:13', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('864', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:15:15', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('865', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:17:35', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('866', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:21:20', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('867', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:23:01', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('868', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:23:09', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('869', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:23:11', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('870', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:23:15', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('871', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:25:12', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('872', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:25:13', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('873', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:25:15', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('874', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:25:16', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('875', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:25:18', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('876', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:26:23', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('877', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:26:49', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('878', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:27:00', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('879', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:27:19', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('880', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:27:56', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('881', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:28:20', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('882', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:35:35', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('883', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:35:56', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('884', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:36:15', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('885', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:37:29', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('886', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 10:37:59', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('888', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 11:10:58', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('889', '/1221.html', '添加用户', '127.0.0.1:80', '127.0.0.1', '2018-06-08 11:12:38', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('890', '/1222.html', '查看用户', '127.0.0.1:80', '127.0.0.1', '2018-06-08 11:12:39', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('891', '/132131.html', '刷新参数', '127.0.0.1:80', '127.0.0.1', '2018-06-08 11:12:42', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('892', '/132132.html', '参数设置', '127.0.0.1:80', '127.0.0.1', '2018-06-08 11:12:43', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('893', '/132231.html', '添加报表', '127.0.0.1:80', '127.0.0.1', '2018-06-08 11:12:44', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('894', '/132232.html', '查看报表', '127.0.0.1:80', '127.0.0.1', '2018-06-08 11:12:45', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('895', '/132331.html', '添加角色', '127.0.0.1:80', '127.0.0.1', '2018-06-08 11:12:47', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('896', '/132332.html', '查看角色', '127.0.0.1:80', '127.0.0.1', '2018-06-08 11:12:47', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('897', '/132431.html', '添加菜单', '127.0.0.1:80', '127.0.0.1', '2018-06-08 11:12:49', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('898', '/132432.html', '查看菜单', '127.0.0.1:80', '127.0.0.1', '2018-06-08 11:12:49', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('899', '/1325.html', '权限管理', '127.0.0.1:80', '127.0.0.1', '2018-06-08 11:12:50', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('900', '/1326.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-08 11:12:51', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('901', '/1326.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-08 11:13:05', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('902', '/1325.html', '权限管理', '127.0.0.1:80', '127.0.0.1', '2018-06-08 11:13:11', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('903', '/1326.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-08 11:13:13', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('904', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 11:38:26', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('905', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 11:39:44', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('906', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 11:59:30', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('907', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 12:00:15', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('908', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 12:01:59', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('909', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 12:03:14', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('910', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 12:07:15', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('911', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 12:08:39', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('912', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 12:09:16', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('913', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 12:09:53', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('914', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 12:10:04', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('915', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 12:11:37', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('916', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 12:11:43', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('917', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 12:12:00', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('918', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 12:25:15', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('919', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 12:25:58', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('920', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 12:26:31', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('921', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 12:37:14', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('922', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 12:38:52', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('923', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 12:39:15', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('924', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 12:40:38', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('925', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 12:40:45', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('926', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 12:41:21', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('927', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 12:43:03', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('928', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 12:43:05', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('929', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 12:44:24', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('930', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 12:44:42', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('931', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 12:45:26', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('932', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 12:46:01', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('933', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 12:49:22', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('934', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 12:56:09', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('935', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 12:56:15', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('936', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 12:57:39', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('937', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 12:58:42', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('938', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 12:59:50', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('939', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 13:00:08', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('940', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 13:01:38', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('941', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 13:01:54', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('942', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 13:02:56', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('943', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 13:04:45', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('944', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 13:10:25', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('945', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 13:11:12', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('946', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 13:13:42', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('947', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 13:15:12', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('948', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 13:18:05', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('949', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 13:18:25', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('950', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 13:18:49', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('951', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 13:19:20', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('952', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 13:23:11', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('953', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 13:23:51', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('954', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 13:24:27', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('955', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 13:26:45', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('956', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 13:26:59', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('957', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 13:28:44', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('958', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 13:29:22', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('959', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 13:31:14', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('960', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 13:31:36', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('961', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 13:31:59', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('962', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 13:34:53', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('963', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 13:35:12', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('964', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 13:35:26', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('965', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 13:35:36', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('966', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 13:38:46', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('967', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 13:39:07', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('968', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 13:39:13', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('969', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 13:40:50', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('970', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 13:43:09', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('971', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 13:44:48', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('972', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 13:45:42', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('973', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 13:45:54', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('974', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 13:46:38', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('975', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 13:46:46', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('976', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 13:48:17', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('977', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 13:48:37', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('978', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 13:55:53', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('979', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 13:58:38', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('980', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 14:01:34', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('981', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 14:01:48', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('982', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 14:02:03', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('983', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 14:02:18', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('984', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 14:02:20', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('985', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 14:02:22', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('986', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 14:03:28', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('987', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 14:03:32', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('988', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 14:03:36', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('989', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 14:03:38', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('990', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 14:03:41', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('991', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 14:04:02', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('992', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 14:04:05', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('993', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 14:15:10', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('994', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 14:16:30', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('995', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 14:17:16', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('996', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 14:18:39', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('997', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 14:19:02', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('998', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 14:19:16', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('999', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 14:20:39', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1000', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 14:21:36', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1001', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 14:22:01', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1002', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 14:23:47', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1003', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 14:24:27', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1005', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 14:24:52', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1006', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 14:27:17', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1007', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 14:27:30', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1008', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 14:28:10', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1009', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 14:31:24', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1010', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 14:31:36', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1012', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 14:31:54', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1013', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 14:34:22', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1015', '/1221.html', '添加用户', '127.0.0.1:80', '127.0.0.1', '2018-06-08 16:10:06', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1016', '/132131.html', '刷新参数', '127.0.0.1:80', '127.0.0.1', '2018-06-08 16:10:08', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1017', '/132132.html', '参数设置', '127.0.0.1:80', '127.0.0.1', '2018-06-08 16:10:09', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1018', '/132231.html', '添加报表', '127.0.0.1:80', '127.0.0.1', '2018-06-08 16:10:11', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1019', '/132232.html', '查看报表', '127.0.0.1:80', '127.0.0.1', '2018-06-08 16:10:12', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1020', '/132331.html', '添加角色', '127.0.0.1:80', '127.0.0.1', '2018-06-08 16:10:13', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1021', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 16:10:16', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1022', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 16:12:45', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1023', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 16:13:59', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1024', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 16:14:11', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1025', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 16:14:40', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1026', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 16:14:52', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1027', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 16:15:19', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1028', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 16:21:01', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1029', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 16:21:31', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1030', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 16:21:47', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1031', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 16:23:46', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1032', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 16:24:18', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1033', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 16:24:38', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1034', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 16:24:40', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1035', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 16:24:44', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1036', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 16:27:50', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1037', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 16:32:13', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1038', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 16:34:32', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1039', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 16:34:52', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1040', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 16:36:12', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1041', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 16:36:41', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1042', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 16:38:18', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1043', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 16:39:25', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1044', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 16:39:55', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1045', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 16:41:07', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1046', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 16:43:17', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1048', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 18:12:20', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1049', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 18:12:40', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1050', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 18:29:25', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1051', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 18:29:39', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1052', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 18:30:45', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1053', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 18:30:57', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1054', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 18:31:30', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1055', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 18:31:42', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1056', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 18:32:22', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1057', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 18:32:44', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1058', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 18:51:58', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1060', '/report/customer_report.html', '报表示例', '192.168.1.110:80', '192.168.1.101', '2018-06-08 21:07:07', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1061', '/report/customer_report.html', '报表示例', '192.168.1.110:80', '192.168.1.101', '2018-06-08 21:07:11', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1062', '/report/customer_report.html', '报表示例', '192.168.1.110:80', '192.168.1.101', '2018-06-08 21:07:50', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1063', '/report/customer_report.html', '报表示例', '192.168.1.110:80', '192.168.1.101', '2018-06-08 21:08:05', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1065', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 21:09:34', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1066', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 21:09:44', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1067', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 21:09:46', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1068', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 21:09:49', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1069', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 21:09:54', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1070', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 21:09:59', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1071', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 21:10:04', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1080', '/report/customer_report.html', '报表示例', '192.168.1.110:80', '192.168.1.101', '2018-06-08 21:11:15', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1081', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 21:12:07', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1082', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 21:12:22', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1083', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 21:12:35', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1084', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 21:12:46', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1085', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 21:12:57', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1086', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 21:13:06', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1087', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 21:13:11', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1088', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 21:13:20', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1089', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 21:13:26', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1090', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 21:15:16', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1091', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 21:16:24', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1092', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 21:16:31', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1093', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 21:25:49', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1094', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 21:26:20', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1095', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 21:26:30', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1115', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 21:49:49', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1118', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 21:52:13', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1140', '/report/log_report.html', null, '127.0.0.1:80', '127.0.0.1', '2018-06-08 21:59:50', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1141', '/report/log_report.html', null, '127.0.0.1:80', '127.0.0.1', '2018-06-08 22:00:13', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1142', '/1326.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-08 22:00:34', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1143', '/getKaptchaImg.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-08 22:00:43', null, '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1144', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-06-08 22:00:51', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1145', '/report/log_report.html', null, '127.0.0.1:80', '127.0.0.1', '2018-06-08 22:00:53', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1146', '/report/log_report.html', null, '127.0.0.1:80', '127.0.0.1', '2018-06-08 22:01:21', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1147', '/report/log_report.html', null, '127.0.0.1:80', '127.0.0.1', '2018-06-08 22:01:28', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1148', '/report/log_report.html', null, '127.0.0.1:80', '127.0.0.1', '2018-06-08 22:01:30', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1149', '/report/log_report.html', null, '127.0.0.1:80', '127.0.0.1', '2018-06-08 22:01:31', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1150', '/report/log_report.html', null, '127.0.0.1:80', '127.0.0.1', '2018-06-08 22:01:32', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1151', '/report/log_report.html', null, '127.0.0.1:80', '127.0.0.1', '2018-06-08 22:01:33', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1152', '/report/log_report.html', null, '127.0.0.1:80', '127.0.0.1', '2018-06-08 22:01:34', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1153', '/report/log_report.html', null, '127.0.0.1:80', '127.0.0.1', '2018-06-08 22:01:35', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1154', '/report/log_report.html', null, '127.0.0.1:80', '127.0.0.1', '2018-06-08 22:01:36', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1155', '/report/log_report.html', null, '127.0.0.1:80', '127.0.0.1', '2018-06-08 22:01:37', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1156', '/report/log_report.html', null, '127.0.0.1:80', '127.0.0.1', '2018-06-08 22:01:39', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1157', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-08 22:06:52', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1158', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-08 22:08:07', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1159', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-08 22:08:10', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1160', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-08 22:08:11', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1161', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-08 22:08:13', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1162', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-08 22:08:14', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1163', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-08 22:08:58', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1164', '/user/edit_user.html', null, '127.0.0.1:80', '127.0.0.1', '2018-06-08 22:09:02', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1165', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-08 22:09:11', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1166', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-08 22:09:16', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1167', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-08 22:09:18', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1168', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-08 22:09:19', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1169', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-08 22:09:20', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1170', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-08 22:09:21', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1171', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-08 22:09:22', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1172', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-08 22:09:23', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1173', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-08 22:09:24', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1174', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 22:10:14', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1175', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 22:10:44', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1176', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 22:11:35', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1177', '/getKaptchaImg.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-08 22:42:56', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1178', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 22:43:02', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1179', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 23:05:57', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1180', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 23:08:27', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1181', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 23:08:29', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1182', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 23:10:20', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1183', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 23:11:19', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1184', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 23:11:57', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1185', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 23:12:52', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1186', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 23:13:08', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1187', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 23:13:52', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1188', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 23:15:57', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1189', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 23:16:05', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1190', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 23:16:07', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1191', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 23:18:12', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1192', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-08 23:19:31', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1193', '/report/customer_downloadFile.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 00:16:54', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1194', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-09 00:41:27', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1195', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-09 00:42:23', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1196', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-09 00:42:25', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1197', '/report/customer_downloadFile.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 00:55:59', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1198', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-09 01:12:42', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1199', '/report/customer_downloadFile.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 01:12:48', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1200', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-09 01:12:52', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1201', '/report/customer_downloadFile.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 01:12:54', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1202', '/customer/uploadFile.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 01:13:40', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1203', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-09 01:14:03', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1204', '/customer/uploadFile.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 01:14:46', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1205', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-09 01:15:38', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1206', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-09 01:19:12', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1207', '/report/customer_uploadFile.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 01:20:13', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1208', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-09 01:20:43', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1209', '/report/customer_uploadFile.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 01:21:56', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1210', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-09 01:22:00', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1211', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-09 01:22:02', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1212', '/report/customer_uploadFile.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 01:25:44', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1213', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-09 01:25:50', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1214', '/report/customer_uploadFile.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 01:27:23', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1215', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-09 01:27:28', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1216', '/report/customer_uploadFile.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 01:28:04', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1217', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-09 01:28:07', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1218', '/report/customer_uploadFile.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 01:29:04', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1219', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-09 01:29:06', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1220', '/report/customer_uploadFile.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 01:29:20', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1221', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-09 01:29:23', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1222', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-09 01:30:26', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1223', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-09 01:30:30', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1224', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-09 01:30:31', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1225', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-09 01:30:33', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1226', '/report/customer_downloadFile.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 01:31:50', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1227', '/report/customer_downloadFile.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 01:32:32', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1228', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-09 01:32:36', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1229', '/report/customer_downloadFile.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 01:32:57', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1230', '/getKaptchaImg.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 01:41:46', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1231', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-06-09 01:41:53', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1232', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-09 01:41:56', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1233', '/132131.html', '刷新参数', '127.0.0.1:80', '127.0.0.1', '2018-06-09 01:42:02', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1234', '/getKaptchaImg.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 02:15:12', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1235', '/132131.html', '刷新参数', '127.0.0.1:80', '127.0.0.1', '2018-06-09 02:15:19', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1236', '/132132.html', '参数设置', '127.0.0.1:80', '127.0.0.1', '2018-06-09 02:15:22', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1237', '/refresh.html', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 02:15:33', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1238', '/refresh.html', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 02:15:38', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1239', '/refresh.html', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 02:15:39', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1240', '/refresh.html', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 02:15:40', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1241', '/refresh.html', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 02:15:40', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1242', '/refresh.html', '刷新参数', '127.0.0.1:80', '127.0.0.1', '2018-06-09 02:16:25', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1243', '/refresh.html', '刷新参数', '127.0.0.1:80', '127.0.0.1', '2018-06-09 02:16:28', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1244', '/refresh/refresh.html', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 02:16:46', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1245', '/refresh/refresh.html', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 02:17:02', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1246', '/getKaptchaImg.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 02:17:06', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1247', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-06-09 02:17:12', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1248', '/refresh/refresh.html', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 02:17:22', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1249', '/refresh/refresh.html', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 02:20:08', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1250', '/refresh/refresh.html', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 02:21:25', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1251', '/refresh/refresh.html', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 02:24:23', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1252', '/refresh/refresh.html', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 02:24:35', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1253', '/refresh/refresh.html', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 02:25:01', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1254', '/refresh/refresh.html', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 02:25:26', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1255', '/refresh/refresh.html', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 02:26:05', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1256', '/refresh/refresh.html', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 02:26:06', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1257', '/refresh/refresh.html', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 02:27:18', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1258', '/refresh/refresh.html', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 02:27:35', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1259', '/refresh/refresh.html', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 02:28:16', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1260', '/refresh/refresh.html', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 02:28:54', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1261', '/getKaptchaImg.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 02:29:35', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1262', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-06-09 02:29:41', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1263', '/132132.html', '参数设置', '127.0.0.1:80', '127.0.0.1', '2018-06-09 02:29:44', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1264', '/refresh/refresh.html', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 02:29:45', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1265', '/refresh/refresh.html', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 02:30:54', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1266', '/refresh/refresh.html', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 02:32:43', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1267', '/refresh/refresh.html', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 02:33:17', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1268', '/refresh/refresh.html', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 02:33:38', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1269', '/refresh/refresh.html', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 02:34:11', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1270', '/refresh/refresh.html', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 02:34:21', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1271', '/refresh/refresh.html', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 02:35:14', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1272', '/refresh/refresh.html', '刷新参数', '127.0.0.1:80', '127.0.0.1', '2018-06-09 02:38:19', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1273', '/refresh/refresh.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 02:38:27', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1274', '/refresh/refresh.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 02:38:50', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1275', '/refresh/refresh.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 02:39:17', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1276', '/refresh/refresh.html', '刷新参数', '127.0.0.1:80', '127.0.0.1', '2018-06-09 02:39:23', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1277', '/refresh/refresh.html', '刷新参数', '127.0.0.1:80', '127.0.0.1', '2018-06-09 02:40:30', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1278', '/refresh/refresh.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 02:40:36', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1279', '/refresh/refresh.html', '刷新参数', '127.0.0.1:80', '127.0.0.1', '2018-06-09 02:40:37', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1280', '/refresh/refresh.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 02:40:52', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1281', '/refresh/refresh.html', '刷新参数', '127.0.0.1:80', '127.0.0.1', '2018-06-09 02:40:53', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1282', '/refresh/refresh.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 02:40:55', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1283', '/refresh/refresh.html', '刷新参数', '127.0.0.1:80', '127.0.0.1', '2018-06-09 02:40:55', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1284', '/132132.html', '参数设置', '127.0.0.1:80', '127.0.0.1', '2018-06-09 02:40:59', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1285', '/swagger-ui.html', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 08:37:57', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1286', '/swagger-resources/configuration/ui', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 08:37:59', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1287', '/swagger-resources', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 08:37:59', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1288', '/swagger-resources/configuration/security', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 08:38:00', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1289', '/getKaptchaImg.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 08:38:42', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1290', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-06-09 08:38:54', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1291', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-06-09 08:39:39', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1292', '/refresh/refresh.html', '刷新参数', '127.0.0.1:80', '127.0.0.1', '2018-06-09 08:39:52', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1293', '/132132.html', '参数设置', '127.0.0.1:80', '127.0.0.1', '2018-06-09 08:39:53', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1294', '/132231.html', '添加报表', '127.0.0.1:80', '127.0.0.1', '2018-06-09 08:39:56', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1295', '/132232.html', '查看报表', '127.0.0.1:80', '127.0.0.1', '2018-06-09 08:39:57', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1296', '/132331.html', '添加角色', '127.0.0.1:80', '127.0.0.1', '2018-06-09 08:39:59', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1297', '/132332.html', '查看角色', '127.0.0.1:80', '127.0.0.1', '2018-06-09 08:40:00', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1298', '/1221.html', '添加用户', '127.0.0.1:80', '127.0.0.1', '2018-06-09 08:40:11', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1299', '/1222.html', '查看用户', '127.0.0.1:80', '127.0.0.1', '2018-06-09 08:40:12', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1300', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-09 08:40:16', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1301', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-09 08:41:07', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1302', '/getKaptchaImg.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 13:13:27', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1303', '/swagger-resources/configuration/ui', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 13:13:47', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1304', '/swagger-resources', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 13:13:48', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1305', '/swagger-resources/configuration/security', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 13:13:48', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1306', '/getKaptchaImg.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 13:14:00', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1307', '/getKaptchaImg.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 13:38:02', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1308', '/getKaptchaImg.do', null, '127.0.0.1:70', '127.0.0.1', '2018-06-09 13:38:10', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1309', '/', '系统首页', '127.0.0.1:70', '127.0.0.1', '2018-06-09 13:38:19', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1310', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-06-09 13:38:24', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1311', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-06-09 13:38:30', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1312', '/getKaptchaImg.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 13:38:33', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1313', '/getKaptchaImg.do', null, '127.0.0.1:70', '127.0.0.1', '2018-06-09 13:38:36', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1314', '/getKaptchaImg.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 13:41:44', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1315', '/', '系统首页', '127.0.0.1:70', '127.0.0.1', '2018-06-09 13:41:51', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1316', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-06-09 13:41:59', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1317', '/getKaptchaImg.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-09 13:42:36', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1318', '/report/log_report.html', '系统日志', '127.0.0.1:70', '127.0.0.1', '2018-06-09 13:44:02', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1319', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-09 13:45:52', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1320', '/getKaptchaImg.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-11 13:28:18', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1321', '/getKaptchaImg.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-11 13:28:27', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1322', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-06-11 13:28:35', '2', '普通用户', '1');
INSERT INTO `star_sys_log` VALUES ('1323', '/getKaptchaImg.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-11 13:28:53', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1324', '/getKaptchaImg.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-11 13:29:01', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1325', '/getKaptchaImg.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-11 13:29:09', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1326', '/getKaptchaImg.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-11 13:29:18', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1327', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-06-11 13:29:20', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1328', '/getKaptchaImg.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-11 13:30:40', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1329', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-06-11 13:30:53', '2', '普通用户', '1');
INSERT INTO `star_sys_log` VALUES ('1330', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-06-11 13:30:56', '2', '普通用户', '1');
INSERT INTO `star_sys_log` VALUES ('1331', '/getKaptchaImg.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-11 13:36:08', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1332', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-06-11 13:36:17', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1333', '/getKaptchaImg.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-11 13:36:28', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1334', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-06-11 13:36:37', '2', '普通用户', '1');
INSERT INTO `star_sys_log` VALUES ('1335', '/getKaptchaImg.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-11 14:13:29', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1336', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-11 14:13:37', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1337', '/getKaptchaImg.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-11 14:15:52', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1338', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-06-11 14:31:31', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1339', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-06-11 14:33:12', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1340', '/getKaptchaImg.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-11 14:33:53', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1341', '/getKaptchaImg.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-11 14:49:36', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1342', '/getKaptchaImg.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-11 14:49:43', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1343', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-06-11 14:49:56', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1344', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-11 14:50:01', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1345', '/refresh/refresh.html', '刷新参数', '127.0.0.1:80', '127.0.0.1', '2018-06-11 14:50:04', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1346', '/getKaptchaImg.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-11 14:50:19', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1347', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-06-11 14:50:26', '2', '普通用户', '1');
INSERT INTO `star_sys_log` VALUES ('1348', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-11 14:50:28', '2', '普通用户', '1');
INSERT INTO `star_sys_log` VALUES ('1349', '/getKaptchaImg.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-11 22:08:39', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1350', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-11 22:08:48', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1351', '/refresh/refresh.html', '刷新参数', '127.0.0.1:80', '127.0.0.1', '2018-06-11 22:10:04', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1352', '/refresh/refresh.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-11 22:10:06', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1353', '/refresh/refresh.html', '刷新参数', '127.0.0.1:80', '127.0.0.1', '2018-06-11 22:10:06', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1354', '/refresh/refresh.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-11 22:11:00', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1355', '/refresh/refresh.html', '刷新参数', '127.0.0.1:80', '127.0.0.1', '2018-06-11 22:11:00', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1356', '/getKaptchaImg.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-11 22:11:11', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1357', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-06-11 22:11:24', '2', '普通用户', '1');
INSERT INTO `star_sys_log` VALUES ('1358', '/refresh/refresh.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-11 22:11:35', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1359', '/refresh/refresh.html', '刷新参数', '127.0.0.1:80', '127.0.0.1', '2018-06-11 22:11:35', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1360', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-06-11 22:11:52', '2', '普通用户', '1');
INSERT INTO `star_sys_log` VALUES ('1361', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-06-11 22:11:54', '2', '普通用户', '1');
INSERT INTO `star_sys_log` VALUES ('1362', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-06-11 22:12:01', '2', '普通用户', '1');
INSERT INTO `star_sys_log` VALUES ('1363', '/getKaptchaImg.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-11 22:12:05', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1364', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-06-11 22:12:15', '2', '普通用户', '1');
INSERT INTO `star_sys_log` VALUES ('1365', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-06-11 22:12:17', '2', '普通用户', '1');
INSERT INTO `star_sys_log` VALUES ('1366', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-11 22:17:51', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1367', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-11 22:17:53', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1368', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-11 22:17:54', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1369', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-11 22:17:54', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1370', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-11 22:17:55', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1371', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-11 22:17:56', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1372', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-11 22:17:57', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1373', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-11 22:17:57', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1374', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-11 22:18:02', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1375', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-11 22:18:03', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1376', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-11 22:18:04', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1377', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-11 22:18:05', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1378', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-11 22:18:06', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1379', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-11 22:18:25', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1380', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-11 22:18:32', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1381', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-11 22:18:33', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1382', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-11 22:18:34', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1383', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-11 22:18:35', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1384', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-11 22:18:47', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1385', '/refresh/refresh.html', '刷新参数', '127.0.0.1:80', '127.0.0.1', '2018-06-11 22:51:37', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1386', '/refresh/refresh.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-11 22:51:41', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1387', '/refresh/refresh.html', '刷新参数', '127.0.0.1:80', '127.0.0.1', '2018-06-11 22:51:41', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1388', '/refresh/refresh.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-11 22:51:52', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1389', '/refresh/refresh.html', '刷新参数', '127.0.0.1:80', '127.0.0.1', '2018-06-11 22:51:52', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1390', '/refresh/refresh.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-11 22:52:24', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1391', '/refresh/refresh.html', '刷新参数', '127.0.0.1:80', '127.0.0.1', '2018-06-11 22:52:24', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1392', '/refresh/refresh.html', '刷新参数', '127.0.0.1:80', '127.0.0.1', '2018-06-11 22:53:06', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1393', '/getKaptchaImg.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-11 23:57:03', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1394', '/getKaptchaImg.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-11 23:57:17', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1395', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-11 23:57:24', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1396', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-11 23:57:28', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1397', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-11 23:57:31', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1398', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-12 00:02:47', '1', '管理员', '1');
INSERT INTO `star_sys_log` VALUES ('1399', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-12 00:07:38', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1400', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-12 00:08:13', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1401', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-12 00:08:26', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1402', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-12 00:08:39', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1403', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-12 00:09:50', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1404', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-12 00:11:18', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1405', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-12 00:12:33', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1406', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-12 00:15:03', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1407', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-12 00:15:08', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1408', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-12 00:15:10', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1409', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-12 00:15:21', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1410', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-12 00:15:31', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1411', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-12 00:15:32', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1412', '/refresh/refresh.html', '刷新参数', '127.0.0.1:80', '127.0.0.1', '2018-06-12 00:15:39', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1413', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-12 00:15:47', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1414', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-06-12 00:15:54', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1415', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-12 00:16:56', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1416', '/report/customer_downloadFile.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-12 00:17:00', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1417', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-12 00:17:04', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1418', '/1221.html', '添加用户', '127.0.0.1:80', '127.0.0.1', '2018-06-12 00:17:14', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1419', '/refresh/refresh.html', '刷新参数', '127.0.0.1:80', '127.0.0.1', '2018-06-12 00:17:17', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1420', '/refresh/refresh.html', '刷新参数', '127.0.0.1:80', '127.0.0.1', '2018-06-12 00:23:01', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1421', '/refresh/refresh.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-12 00:23:13', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1422', '/refresh/refresh.html', '刷新参数', '127.0.0.1:80', '127.0.0.1', '2018-06-12 00:23:13', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1423', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-12 00:34:08', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1424', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-12 00:34:34', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1425', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-12 00:36:19', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1426', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-12 00:38:10', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1427', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-12 00:41:03', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1428', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-12 00:51:21', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1429', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-12 00:51:25', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1430', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-12 00:51:27', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1431', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-12 00:51:28', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1432', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-12 00:51:32', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1433', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-12 00:51:34', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1434', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-12 00:51:36', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1435', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-12 00:51:36', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1436', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-12 00:51:37', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1437', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-12 00:51:39', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1438', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-12 00:51:42', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1439', '/getKaptchaImg.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-12 00:56:22', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1440', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-12 00:56:30', '2', null, '1');
INSERT INTO `star_sys_log` VALUES ('1441', '/getKaptchaImg.do', null, '127.0.0.1:80', '127.0.0.1', '2018-06-12 09:39:13', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1442', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-06-12 09:39:18', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1443', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-12 09:39:21', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1444', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-06-12 09:40:15', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1445', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-06-12 09:40:42', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1446', '/getKaptchaImg.do', null, '192.168.1.2:80', '192.168.1.2', '2018-06-14 23:19:37', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1447', '/getKaptchaImg.do', null, '127.0.0.1:80', '127.0.0.1', '2018-07-29 17:23:30', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1448', '/getKaptchaImg.do', null, '127.0.0.1:80', '127.0.0.1', '2018-07-29 17:23:37', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1449', '/getKaptchaImg.do', null, '127.0.0.1:80', '127.0.0.1', '2018-07-29 17:23:42', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1450', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-07-29 17:23:53', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1451', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-07-29 17:23:56', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1452', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-07-29 17:23:58', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1453', '/1221.html', '添加用户', '127.0.0.1:80', '127.0.0.1', '2018-07-29 17:24:00', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1454', '/1222.html', '查看用户', '127.0.0.1:80', '127.0.0.1', '2018-07-29 17:24:01', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1455', '/refresh/refresh.html', '刷新参数', '127.0.0.1:80', '127.0.0.1', '2018-07-29 17:24:03', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1456', '/132132.html', '参数设置', '127.0.0.1:80', '127.0.0.1', '2018-07-29 17:24:04', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1457', '/132231.html', '添加报表', '127.0.0.1:80', '127.0.0.1', '2018-07-29 17:24:06', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1458', '/132232.html', '查看报表', '127.0.0.1:80', '127.0.0.1', '2018-07-29 17:24:07', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1459', '/132331.html', '添加角色', '127.0.0.1:80', '127.0.0.1', '2018-07-29 17:24:08', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1460', '/132332.html', '查看角色', '127.0.0.1:80', '127.0.0.1', '2018-07-29 17:24:09', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1461', '/132431.html', '添加菜单', '127.0.0.1:80', '127.0.0.1', '2018-07-29 17:24:11', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1462', '/132432.html', '查看菜单', '127.0.0.1:80', '127.0.0.1', '2018-07-29 17:24:12', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1463', '/1325.html', '权限管理', '127.0.0.1:80', '127.0.0.1', '2018-07-29 17:24:13', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1464', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-07-29 17:24:14', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1465', '/getKaptchaImg.do', null, '127.0.0.1:80', '127.0.0.1', '2018-07-29 17:26:31', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1466', '/getKaptchaImg.do', null, '127.0.0.1:80', '127.0.0.1', '2018-07-29 18:46:56', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1467', '/getKaptchaImg.do', null, '127.0.0.1:80', '127.0.0.1', '2018-07-29 18:47:22', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1468', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-07-29 18:47:32', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1469', '/1221.html', '添加用户', '127.0.0.1:80', '127.0.0.1', '2018-07-29 18:47:37', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1470', '/1222.html', '查看用户', '127.0.0.1:80', '127.0.0.1', '2018-07-29 18:47:38', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1471', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-07-29 18:47:39', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1472', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-07-29 18:49:30', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1473', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-07-29 18:49:32', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1474', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-07-29 18:49:33', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1475', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-07-29 18:49:37', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1476', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-07-29 18:49:39', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1477', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-07-29 18:49:44', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1478', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-07-29 18:49:46', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1479', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-07-29 18:49:46', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1480', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-07-29 18:49:47', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1481', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-07-29 18:49:48', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1482', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-07-29 18:49:49', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1483', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-07-29 18:49:49', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1484', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-07-29 18:49:50', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1485', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-07-29 18:49:50', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1486', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-07-29 18:49:50', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1487', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-07-29 18:49:50', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1488', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-07-29 18:49:51', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1489', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-07-29 18:49:51', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1490', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-07-29 18:49:52', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1491', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-07-29 18:49:52', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1492', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-07-29 18:49:52', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1493', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-07-29 18:49:52', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1494', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-07-29 18:49:53', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1495', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-07-29 18:49:53', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1496', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-07-29 18:49:53', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1497', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-07-29 18:49:54', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1498', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-07-29 18:49:54', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1499', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-07-29 18:49:54', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1500', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-07-29 18:49:55', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1501', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-07-29 18:49:55', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1502', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-07-29 18:49:55', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1503', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-07-29 18:49:56', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1504', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-07-29 18:49:56', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1505', '/report/customer_report.html', '报表示例', '127.0.0.1:80', '127.0.0.1', '2018-07-29 18:50:58', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1506', '/refresh/refresh.html', '刷新参数', '127.0.0.1:80', '127.0.0.1', '2018-07-29 18:51:02', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1507', '/132132.html', '参数设置', '127.0.0.1:80', '127.0.0.1', '2018-07-29 18:51:03', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1508', '/132231.html', '添加报表', '127.0.0.1:80', '127.0.0.1', '2018-07-29 18:51:04', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1509', '/132232.html', '查看报表', '127.0.0.1:80', '127.0.0.1', '2018-07-29 18:51:05', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1510', '/132331.html', '添加角色', '127.0.0.1:80', '127.0.0.1', '2018-07-29 18:51:07', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1511', '/132332.html', '查看角色', '127.0.0.1:80', '127.0.0.1', '2018-07-29 18:51:07', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1512', '/132431.html', '添加菜单', '127.0.0.1:80', '127.0.0.1', '2018-07-29 18:51:08', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1513', '/132432.html', '查看菜单', '127.0.0.1:80', '127.0.0.1', '2018-07-29 18:51:09', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1514', '/1325.html', '权限管理', '127.0.0.1:80', '127.0.0.1', '2018-07-29 18:51:10', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1515', '/report/log_report.html', '系统日志', '127.0.0.1:80', '127.0.0.1', '2018-07-29 18:51:11', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1516', '/index.html', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-07-29 18:51:12', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1517', '/getKaptchaImg.do', null, '127.0.0.1:80', '127.0.0.1', '2018-07-29 18:51:29', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1518', '/getKaptchaImg.do', null, '127.0.0.1:80', '127.0.0.1', '2018-08-09 21:07:59', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1519', '/swagger-ui.html', null, '127.0.0.1:80', '127.0.0.1', '2018-08-09 21:08:15', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1520', '/swagger-resources/configuration/ui', null, '127.0.0.1:80', '127.0.0.1', '2018-08-09 21:08:16', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1521', '/swagger-resources', null, '127.0.0.1:80', '127.0.0.1', '2018-08-09 21:08:16', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1522', '/swagger-resources/configuration/security', null, '127.0.0.1:80', '127.0.0.1', '2018-08-09 21:08:16', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1523', '/swagger-ui.html', null, '127.0.0.1:80', '127.0.0.1', '2018-08-09 21:22:54', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1524', '/swagger-resources/configuration/ui', null, '127.0.0.1:80', '127.0.0.1', '2018-08-09 21:22:54', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1525', '/swagger-resources', null, '127.0.0.1:80', '127.0.0.1', '2018-08-09 21:22:54', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1526', '/swagger-resources/configuration/security', null, '127.0.0.1:80', '127.0.0.1', '2018-08-09 21:22:55', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1527', '/getKaptchaImg.do', null, '127.0.0.1:80', '127.0.0.1', '2018-08-09 21:23:19', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1528', '/getKaptchaImg.do', null, '127.0.0.1:80', '127.0.0.1', '2018-08-09 21:23:29', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1529', '/', '系统首页', '127.0.0.1:80', '127.0.0.1', '2018-08-09 21:23:32', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1530', '/customer/ListStarTeScoreRecord.do', null, '127.0.0.1:80', '127.0.0.1', '2018-08-09 21:23:37', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1531', '/customer/AddStarTeScoreRecord.do', null, '127.0.0.1:80', '127.0.0.1', '2018-08-09 21:24:35', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1532', '/customer/ListStarTeScoreRecord.do', null, '127.0.0.1:80', '127.0.0.1', '2018-08-09 21:24:40', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1533', '/getKaptchaImg.do', null, '127.0.0.1:80', '127.0.0.1', '2018-08-09 21:27:28', null, null, '1');
INSERT INTO `star_sys_log` VALUES ('1534', '/customer/AddStarTeScoreRecord.do', null, '127.0.0.1:80', '127.0.0.1', '2018-08-09 21:30:23', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1535', '/customer/AddStarTeScoreRecord.do', null, '127.0.0.1:80', '127.0.0.1', '2018-08-09 21:30:25', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1536', '/customer/AddStarTeScoreRecord.do', null, '127.0.0.1:80', '127.0.0.1', '2018-08-09 21:30:26', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1537', '/customer/AddStarTeScoreRecord.do', null, '127.0.0.1:80', '127.0.0.1', '2018-08-09 21:30:26', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1538', '/customer/AddStarTeScoreRecord.do', null, '127.0.0.1:80', '127.0.0.1', '2018-08-09 21:30:26', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1539', '/customer/AddStarTeScoreRecord.do', null, '127.0.0.1:80', '127.0.0.1', '2018-08-09 21:30:26', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1540', '/customer/AddStarTeScoreRecord.do', null, '127.0.0.1:80', '127.0.0.1', '2018-08-09 21:30:26', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1541', '/customer/AddStarTeScoreRecord.do', null, '127.0.0.1:80', '127.0.0.1', '2018-08-09 21:30:26', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1542', '/customer/AddStarTeScoreRecord.do', null, '127.0.0.1:80', '127.0.0.1', '2018-08-09 21:30:27', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1543', '/customer/AddStarTeScoreRecord.do', null, '127.0.0.1:80', '127.0.0.1', '2018-08-09 21:30:27', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1544', '/customer/ListStarTeScoreRecord.do', null, '127.0.0.1:80', '127.0.0.1', '2018-08-09 21:30:30', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1545', '/customer/AddStarTeScoreRecord.do', null, '127.0.0.1:80', '127.0.0.1', '2018-08-09 21:31:17', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1546', '/customer/AddStarTeStudentScore.do', null, '127.0.0.1:80', '127.0.0.1', '2018-08-09 21:35:35', '1', null, '1');
INSERT INTO `star_sys_log` VALUES ('1547', '/customer/ListStarTeStudentScore.do', null, '127.0.0.1:80', '127.0.0.1', '2018-08-09 21:35:40', '1', null, '1');

-- ----------------------------
-- Table structure for star_sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `star_sys_menu`;
CREATE TABLE `star_sys_menu` (
  `id` varchar(64) NOT NULL COMMENT '菜单编号',
  `func_name` varchar(64) DEFAULT NULL COMMENT '权限英文名',
  `path` varchar(64) DEFAULT NULL COMMENT '路径',
  `parent` varchar(64) DEFAULT NULL COMMENT '父目录',
  `text` varchar(64) DEFAULT NULL COMMENT '菜单名',
  `icon` varchar(64) DEFAULT NULL COMMENT '图标',
  `is_leaf` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否末级菜单',
  `is_juris` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否启用权限管理',
  `enable` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单权限表';

-- ----------------------------
-- Records of star_sys_menu
-- ----------------------------
INSERT INTO `star_sys_menu` VALUES ('0', null, '/', '#', '系统首页', null, '1', '0', '1');
INSERT INTO `star_sys_menu` VALUES ('00', null, '/index.html', '#', '系统首页', 'fa-home', '0', '0', '1');
INSERT INTO `star_sys_menu` VALUES ('11', null, '/11.html', '#', '开发样例', 'fa-lightbulb-o', '0', '0', '1');
INSERT INTO `star_sys_menu` VALUES ('1121', null, '/customer/view_customer.html', '11', '查询客户', 'fa-eye green', '0', '0', '0');
INSERT INTO `star_sys_menu` VALUES ('1122', 'ReportExample', '/report/customer_report.html', '11', '报表示例', 'fa-eye green', '0', '0', '1');
INSERT INTO `star_sys_menu` VALUES ('12', 'UserManagement', '/12.html', '#', '用户管理', 'fa-user', '0', '1', '1');
INSERT INTO `star_sys_menu` VALUES ('1221', 'AddUsers', '/1221.html', '12', '添加用户', 'icon-plus-sign', '0', '1', '1');
INSERT INTO `star_sys_menu` VALUES ('1222', 'ViewUser', '/1222.html', '12', '查看用户', 'fa-eye', '0', '1', '1');
INSERT INTO `star_sys_menu` VALUES ('13', 'SystemSetup', '/13.html', '#', '系统设置', 'icon-cog', '0', '1', '1');
INSERT INTO `star_sys_menu` VALUES ('1321', 'SystemParameter', '/1321.html', '13', '系统参数', 'icon-wrench', '0', '1', '1');
INSERT INTO `star_sys_menu` VALUES ('132131', 'RefreshParameter', '/refresh/refresh.html', '1321', '刷新参数', 'icon-repeat purple', '0', '1', '1');
INSERT INTO `star_sys_menu` VALUES ('132132', 'ParameterSetting', '/132132.html', '1321', '参数设置', 'icon-cogs  green', '0', '1', '1');
INSERT INTO `star_sys_menu` VALUES ('1322', 'ReportManagement', '/1322.html', '13', '报表管理', 'fa-bar-chart-o ', '0', '1', '1');
INSERT INTO `star_sys_menu` VALUES ('132231', 'AddReports', '/132231.html', '1322', '添加报表', 'icon-plus-sign purple', '0', '1', '1');
INSERT INTO `star_sys_menu` VALUES ('132232', 'ViewReports', '/132232.html', '1322', '查看报表', 'fa-eye green', '0', '1', '1');
INSERT INTO `star_sys_menu` VALUES ('1323', 'RoleManagement', '/1323.html', '13', '角色管理', 'fa-users', '0', '1', '1');
INSERT INTO `star_sys_menu` VALUES ('132331', 'AddRoles', '/132331.html', '1323', '添加角色', 'icon-plus-sign purple', '0', '1', '1');
INSERT INTO `star_sys_menu` VALUES ('132332', 'ViewRoles', '/132332.html', '1323', '查看角色', 'fa-eye green', '0', '1', '1');
INSERT INTO `star_sys_menu` VALUES ('1324', 'MenuManagement', '/1324.html', '13', '菜单管理', 'icon-th-list', '0', '1', '1');
INSERT INTO `star_sys_menu` VALUES ('132431', 'AddMenu', '/132431.html', '1324', '添加菜单', 'icon-plus-sign purple', '0', '1', '1');
INSERT INTO `star_sys_menu` VALUES ('132432', 'ViewMenu', '/132432.html', '1324', '查看菜单', 'fa-eye green', '0', '1', '1');
INSERT INTO `star_sys_menu` VALUES ('1325', 'AuthorityManagement', '/1325.html', '13', '权限管理', 'icon-lock', '0', '1', '1');
INSERT INTO `star_sys_menu` VALUES ('1326', 'SystemLog', '/report/log_report.html', '13', '系统日志', 'icon-calendar', '0', '1', '1');

-- ----------------------------
-- Table structure for star_sys_priv
-- ----------------------------
DROP TABLE IF EXISTS `star_sys_priv`;
CREATE TABLE `star_sys_priv` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `role_id` int(11) unsigned NOT NULL COMMENT '角色id',
  `menu_id` varchar(64) NOT NULL COMMENT '菜单权限id',
  `enable` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='授权表';

-- ----------------------------
-- Records of star_sys_priv
-- ----------------------------
INSERT INTO `star_sys_priv` VALUES ('1', '1', '11', '1');
INSERT INTO `star_sys_priv` VALUES ('2', '1', '1121', '1');
INSERT INTO `star_sys_priv` VALUES ('3', '1', '1122', '1');
INSERT INTO `star_sys_priv` VALUES ('4', '1', '12', '1');
INSERT INTO `star_sys_priv` VALUES ('5', '1', '1221', '1');
INSERT INTO `star_sys_priv` VALUES ('6', '1', '1222', '1');
INSERT INTO `star_sys_priv` VALUES ('7', '1', '13', '1');
INSERT INTO `star_sys_priv` VALUES ('8', '1', '1321', '1');
INSERT INTO `star_sys_priv` VALUES ('9', '1', '132131', '1');
INSERT INTO `star_sys_priv` VALUES ('10', '1', '132132', '1');
INSERT INTO `star_sys_priv` VALUES ('11', '1', '1322', '1');
INSERT INTO `star_sys_priv` VALUES ('12', '1', '132231', '1');
INSERT INTO `star_sys_priv` VALUES ('13', '1', '132232', '1');
INSERT INTO `star_sys_priv` VALUES ('14', '1', '1323', '1');
INSERT INTO `star_sys_priv` VALUES ('15', '1', '132331', '1');
INSERT INTO `star_sys_priv` VALUES ('16', '1', '132332', '1');
INSERT INTO `star_sys_priv` VALUES ('17', '1', '1324', '1');
INSERT INTO `star_sys_priv` VALUES ('18', '1', '132431', '1');
INSERT INTO `star_sys_priv` VALUES ('19', '1', '132432', '1');
INSERT INTO `star_sys_priv` VALUES ('20', '1', '1325', '1');
INSERT INTO `star_sys_priv` VALUES ('21', '1', '1326', '1');

-- ----------------------------
-- Table structure for star_sys_report
-- ----------------------------
DROP TABLE IF EXISTS `star_sys_report`;
CREATE TABLE `star_sys_report` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(64) NOT NULL COMMENT '报表名称',
  `title` varchar(64) DEFAULT NULL COMMENT '报表标题',
  `namespace` varchar(255) DEFAULT NULL COMMENT '工作空间(用于指定js地址)',
  `bean_class` varchar(255) DEFAULT NULL COMMENT '数据源',
  `query_sql` varchar(2048) DEFAULT NULL COMMENT '查询sql，与beanClass不能同时为空',
  `page_size` int(11) DEFAULT NULL COMMENT '每页的页数',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `operation_upload` tinyint(1) NOT NULL DEFAULT '1' COMMENT '显示上传按钮',
  `operation_download` tinyint(1) NOT NULL DEFAULT '1' COMMENT '显示下载按钮',
  `operation_view_func` varchar(128) DEFAULT NULL COMMENT '查看操作JS方法',
  `operation_edit_func` varchar(128) DEFAULT NULL COMMENT '编辑操作JS方法',
  `operation_delete_func` varchar(128) DEFAULT NULL COMMENT '删除操作JS方法',
  `permissions_enable` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否启用权限',
  `enable` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否启用',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='报表';

-- ----------------------------
-- Records of star_sys_report
-- ----------------------------
INSERT INTO `star_sys_report` VALUES ('1', 'log', '系统日志', null, '', 'SELECT\r\n	tl.id,\r\n	tl.path,\r\n	tl.text,\r\n	tl.local_path,\r\n	tl.remote_addr,\r\n	tl.access_time,\r\n	ti.`name` AS `access_user`,\r\n	tl.`enable`\r\nFROM\r\n	star_sys_log AS tl,\r\n	star_sys_user_info AS ti\r\nWHERE\r\n	tl.`enable` = TRUE\r\nAND ti.id = tl.access_user', '15', '2018-06-08 21:28:26', '0', '0', null, null, null, '0', '1');
INSERT INTO `star_sys_report` VALUES ('2', 'customer', '客户报表', '/js/report.demo', 'cn.loverqi.star.domain.Customer', null, '10', '2018-06-03 14:12:35', '1', '1', 'view(${id}, ${wechat_number}, 1)', 'edit()', 'deleted()', '1', '1');

-- ----------------------------
-- Table structure for star_sys_report_data
-- ----------------------------
DROP TABLE IF EXISTS `star_sys_report_data`;
CREATE TABLE `star_sys_report_data` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `report_id` int(11) unsigned DEFAULT NULL COMMENT '报表id',
  `name` varchar(64) DEFAULT NULL COMMENT '字段名',
  `title` varchar(64) DEFAULT NULL COMMENT '字段标题',
  `type` int(2) unsigned DEFAULT NULL COMMENT '字段类型(包括字典值)',
  `default_value` varchar(128) DEFAULT NULL COMMENT '默认值',
  `format` varchar(64) DEFAULT NULL COMMENT '格式化显示',
  `enable` tinyint(1) DEFAULT '0' COMMENT '是否启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='报表显示数据配置表';

-- ----------------------------
-- Records of star_sys_report_data
-- ----------------------------
INSERT INTO `star_sys_report_data` VALUES ('1', '2', 'id', 'int测试列1', '2', '-', '5', '1');
INSERT INTO `star_sys_report_data` VALUES ('2', '2', 'create_user', 'double测试列2', '3', '-', '2,2', '1');
INSERT INTO `star_sys_report_data` VALUES ('3', '2', 'wechat_number', '字典测试列3', '6', '-', null, '1');
INSERT INTO `star_sys_report_data` VALUES ('4', '2', 'wechat_name', 'string测试列4', '1', '-', null, '1');
INSERT INTO `star_sys_report_data` VALUES ('5', '2', 'create_date', 'date测试列5', '5', '-', 'yyyy-MM-dd HH:mm:ss', '1');
INSERT INTO `star_sys_report_data` VALUES ('6', '2', 'customer_source', '其他测试列6', '8', '-', null, '1');
INSERT INTO `star_sys_report_data` VALUES ('7', '2', 'if_see', 'boolean测试列7', '4', '-', '是|否', '1');
INSERT INTO `star_sys_report_data` VALUES ('8', '1', 'id', '序号', '2', '-', '0', '0');
INSERT INTO `star_sys_report_data` VALUES ('9', '1', 'path', '请求路径', '1', '-', null, '1');
INSERT INTO `star_sys_report_data` VALUES ('10', '1', 'text', '访问模块', '1', '-', null, '1');
INSERT INTO `star_sys_report_data` VALUES ('11', '1', 'local_path', '访问ip', '1', '-', null, '1');
INSERT INTO `star_sys_report_data` VALUES ('12', '1', 'remote_addr', '客户ip地址', '1', '-', null, '1');
INSERT INTO `star_sys_report_data` VALUES ('13', '1', 'access_time', '访问时间', '5', '-', 'yyyy-MM-dd HH:mm:ss', '1');
INSERT INTO `star_sys_report_data` VALUES ('15', '1', 'access_user', '访问客户', '1', '-', null, '1');

-- ----------------------------
-- Table structure for star_sys_report_query
-- ----------------------------
DROP TABLE IF EXISTS `star_sys_report_query`;
CREATE TABLE `star_sys_report_query` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `report_id` int(11) unsigned DEFAULT NULL COMMENT '报表id',
  `name` varchar(64) DEFAULT NULL COMMENT '字段名',
  `title` varchar(64) DEFAULT NULL COMMENT '字段标题',
  `class_type` varchar(64) DEFAULT NULL COMMENT '字段数据类型',
  `type` int(2) DEFAULT NULL COMMENT '字段类型(包括字典值)',
  `default_value` varchar(128) DEFAULT NULL COMMENT '默认值',
  `condition` varchar(255) DEFAULT NULL COMMENT '对比条件',
  `enable` tinyint(1) DEFAULT '0' COMMENT '是否启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='报表查询条件配置表';

-- ----------------------------
-- Records of star_sys_report_query
-- ----------------------------
INSERT INTO `star_sys_report_query` VALUES ('1', '2', 'id', 'string_=', null, '1', '--', '=', '0');
INSERT INTO `star_sys_report_query` VALUES ('2', '2', 'wechat_number', 'string_like', null, '1', '--', 'like', '1');
INSERT INTO `star_sys_report_query` VALUES ('3', '2', 'create_date', 'date_>=', null, '2', '', '>=', '1');
INSERT INTO `star_sys_report_query` VALUES ('13', '2', 'create_user', 'list_in', null, '4', '1=test1,2=text2,43=test3,44=不知道,45=随便写的', 'in', '1');
INSERT INTO `star_sys_report_query` VALUES ('14', '2', 'if_see', '是否查看', null, '3', 'true=是,false=否', '=', '1');

-- ----------------------------
-- Table structure for star_sys_role
-- ----------------------------
DROP TABLE IF EXISTS `star_sys_role`;
CREATE TABLE `star_sys_role` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(64) NOT NULL COMMENT '角色名称',
  `department_id` int(11) unsigned DEFAULT NULL COMMENT '部门id',
  `enable` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of star_sys_role
-- ----------------------------
INSERT INTO `star_sys_role` VALUES ('1', 'test_role_1', null, '1');
INSERT INTO `star_sys_role` VALUES ('2', 'test_role_2', null, '1');
INSERT INTO `star_sys_role` VALUES ('3', 'test_role_3', null, '1');
INSERT INTO `star_sys_role` VALUES ('4', 'test_role_4', null, '1');
INSERT INTO `star_sys_role` VALUES ('5', 'test_role_5', null, '1');
INSERT INTO `star_sys_role` VALUES ('6', 'test_role_6', null, '1');

-- ----------------------------
-- Table structure for star_sys_user_info
-- ----------------------------
DROP TABLE IF EXISTS `star_sys_user_info`;
CREATE TABLE `star_sys_user_info` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(32) NOT NULL COMMENT '真实姓名',
  `username` varchar(32) NOT NULL COMMENT '用户名',
  `password` varchar(128) NOT NULL COMMENT '密码',
  `role_id` int(11) unsigned DEFAULT NULL COMMENT '用户角色',
  `contact` varchar(128) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_pwd_time` datetime DEFAULT NULL COMMENT '密码更新时间',
  `error_count` int(11) NOT NULL DEFAULT '0' COMMENT '密码尝试错误次数',
  `is_unlock` tinyint(1) DEFAULT '1' COMMENT '账号是否未锁定',
  `enable` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否启用',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='用户信息表';

-- ----------------------------
-- Records of star_sys_user_info
-- ----------------------------
INSERT INTO `star_sys_user_info` VALUES ('1', '管理员', 'admin', '$2a$04$xcTX1RMpJLpSE1hvS/mVkO4hDlU3MxEi95rAG./GnfgAAzYU7u4O.', '1', '测试地址', '2018-04-01 09:41:08', '2018-05-01 00:00:00', '0', '1', '1');
INSERT INTO `star_sys_user_info` VALUES ('2', '普通用户', 'user', '$2a$04$EnlqwzILueuclg5gDN/XzeGnQzWu8lAU.o2sgELU5N.S78q7pFBdC', '2', '测试地址', '2018-04-01 09:41:13', '2018-05-01 00:00:00', '0', '1', '1');
INSERT INTO `star_sys_user_info` VALUES ('39', '测试用户2', 'test', '$2a$04$0rm8SjJ84gFANYSUQCN4LejzYeV0Dh8aCzQhP7keb1cC8xDPY6DAq', '2', '测试地址', '2018-04-04 09:49:54', '2018-05-01 00:00:00', '0', '1', '1');
INSERT INTO `star_sys_user_info` VALUES ('40', '测试用户', 'test2', '$2a$04$Mzlaa2XAhLIQhxwgkP30deZfOAiplZB3HBFgFDbf6zFnfDxo6zC.y', '2', '测试地址', '2018-04-06 13:01:02', '2018-05-01 00:00:00', '0', '1', '1');
INSERT INTO `star_sys_user_info` VALUES ('41', 'dddddd', 'dddddd', '$2a$04$3FUi/w4VFFW2GC7m2QrgyOyg9JrV9qbv2yBJP7FPYvTIFPhWmal/y', '2', '测试地址', '2018-04-08 16:04:12', '2018-05-01 00:00:00', '0', '1', '1');
INSERT INTO `star_sys_user_info` VALUES ('42', '123456', '123456', '$2a$04$JW4wFhJapxbznrNE9My8eOXHNGBpw.Sx2amx64uvUB1rC7cBz7OlW', '2', '测试地址', '2018-04-08 16:13:51', '2018-05-01 00:00:00', '0', '1', '1');

-- ----------------------------
-- Table structure for star_te_evaluation_activity
-- ----------------------------
DROP TABLE IF EXISTS `star_te_evaluation_activity`;
CREATE TABLE `star_te_evaluation_activity` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '活动id',
  `template_id` int(11) unsigned NOT NULL COMMENT '模板d',
  `name` varchar(64) NOT NULL COMMENT '活动名称',
  `state` int(2) NOT NULL DEFAULT '0' COMMENT '活动状态',
  `group_ids` varchar(255) NOT NULL COMMENT '相关用户组，暂时不维护多对多的关系',
  `star_time` datetime NOT NULL COMMENT '活动开始时间',
  `end_time` datetime NOT NULL COMMENT '活动结束时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_date` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_date` timestamp NULL DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评分活动表';

-- ----------------------------
-- Records of star_te_evaluation_activity
-- ----------------------------

-- ----------------------------
-- Table structure for star_te_evaluation_template
-- ----------------------------
DROP TABLE IF EXISTS `star_te_evaluation_template`;
CREATE TABLE `star_te_evaluation_template` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '模板id',
  `name` varchar(64) DEFAULT NULL COMMENT '模板名称',
  `state` int(2) DEFAULT '0' COMMENT '模板状态',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评价模板表';

-- ----------------------------
-- Records of star_te_evaluation_template
-- ----------------------------

-- ----------------------------
-- Table structure for star_te_evaluation_template_item
-- ----------------------------
DROP TABLE IF EXISTS `star_te_evaluation_template_item`;
CREATE TABLE `star_te_evaluation_template_item` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '规则id',
  `template_id` int(11) unsigned NOT NULL COMMENT '模板d',
  `name` varchar(64) NOT NULL COMMENT '条目名称',
  `default_score` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '默认初始分值',
  `forward_score` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否正向计分；0为负向计分，1为正向计分',
  `score_upper_limit` decimal(10,2) NOT NULL DEFAULT '-1.00' COMMENT '该项分值上限',
  `score_lower_limit` decimal(10,2) NOT NULL DEFAULT '-1.00' COMMENT '一票否决分值下限',
  `rule_description` varchar(255) DEFAULT NULL COMMENT '评分规则说明',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评分模板项目配置表';

-- ----------------------------
-- Records of star_te_evaluation_template_item
-- ----------------------------

-- ----------------------------
-- Table structure for star_te_score_record
-- ----------------------------
DROP TABLE IF EXISTS `star_te_score_record`;
CREATE TABLE `star_te_score_record` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '分数id',
  `item_id` int(11) unsigned NOT NULL COMMENT '评分条目id',
  `activity_id` int(11) unsigned NOT NULL COMMENT '关联活动id',
  `score` decimal(10,2) NOT NULL COMMENT '分数',
  `forward_score` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否正向计分；0为负向计分，1为正向计分',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评分记录表';

-- ----------------------------
-- Records of star_te_score_record
-- ----------------------------

-- ----------------------------
-- Table structure for star_te_student_score
-- ----------------------------
DROP TABLE IF EXISTS `star_te_student_score`;
CREATE TABLE `star_te_student_score` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '分数id',
  `user_id` int(11) unsigned NOT NULL COMMENT '关联用户id',
  `activity_id` int(11) unsigned NOT NULL COMMENT '关联活动id',
  `score` decimal(10,2) NOT NULL COMMENT '分数',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生评价分数表';

-- ----------------------------
-- Records of star_te_student_score
-- ----------------------------

-- ----------------------------
-- Table structure for star_te_teacher_detail
-- ----------------------------
DROP TABLE IF EXISTS `star_te_teacher_detail`;
CREATE TABLE `star_te_teacher_detail` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '教师id',
  `user_id` int(11) unsigned NOT NULL COMMENT '关联用户id',
  `school` varchar(64) DEFAULT NULL COMMENT '学校',
  `college` varchar(64) DEFAULT NULL COMMENT '学院',
  `group` varchar(64) DEFAULT NULL COMMENT '组别nick(冗余）',
  `title` varchar(64) DEFAULT NULL COMMENT '职称',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='教师信息扩展表';

-- ----------------------------
-- Records of star_te_teacher_detail
-- ----------------------------

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `report_id` int(11) unsigned DEFAULT NULL COMMENT '报表id',
  `name` varchar(64) DEFAULT NULL COMMENT '字段名',
  `title` varchar(64) DEFAULT NULL COMMENT '字段标题',
  `type` int(2) DEFAULT NULL COMMENT '字段类型(包括字典值)',
  `default_value` varchar(128) DEFAULT NULL COMMENT '默认值',
  `condition` varchar(255) DEFAULT NULL COMMENT '对比条件',
  `enable` tinyint(1) DEFAULT '0' COMMENT '是否启用',
  `date` double DEFAULT NULL COMMENT '测试字段',
  `number` double(11,2) DEFAULT NULL COMMENT '测试字段',
  `number2` double(11,0) unsigned DEFAULT NULL COMMENT '测试字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='测试表';

-- ----------------------------
-- Records of test
-- ----------------------------
