/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : glasses

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 14/04/2020 16:01:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for brand
-- ----------------------------
DROP TABLE IF EXISTS `brand`;
CREATE TABLE `brand` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL COMMENT '品牌名称',
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `brand_name_uindex` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='库存品牌表';

-- ----------------------------
-- Table structure for consumption
-- ----------------------------
DROP TABLE IF EXISTS `consumption`;
CREATE TABLE `consumption` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `trade_id` int(11) NOT NULL COMMENT '商品名称, 库存获取',
  `member_id` int(11) DEFAULT NULL COMMENT '消费会员',
  `number` int(11) DEFAULT NULL COMMENT '销售数量',
  `staff_id` int(11) NOT NULL COMMENT '售卖员工',
  `amount` varchar(100) DEFAULT NULL COMMENT '单价',
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品销售表';

-- ----------------------------
-- Table structure for flyway_schema_history
-- ----------------------------
DROP TABLE IF EXISTS `flyway_schema_history`;
CREATE TABLE `flyway_schema_history` (
  `installed_rank` int(11) NOT NULL,
  `version` varchar(50) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `type` varchar(20) NOT NULL,
  `script` varchar(1000) NOT NULL,
  `checksum` int(11) DEFAULT NULL,
  `installed_by` varchar(100) NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `execution_time` int(11) NOT NULL,
  `success` tinyint(1) NOT NULL,
  PRIMARY KEY (`installed_rank`),
  KEY `flyway_schema_history_s_idx` (`success`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL COMMENT '姓名',
  `phone` varchar(20) NOT NULL COMMENT '手机号',
  `birthday` varchar(100) DEFAULT NULL COMMENT '生日',
  `address` varchar(255) DEFAULT NULL COMMENT '住址',
  `amount_total` varchar(100) DEFAULT NULL COMMENT '消费总金额',
  `create_id` varchar(100) DEFAULT NULL COMMENT '创建人',
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员管理表';

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL COMMENT '角色名称',
  `permission` varchar(100) NOT NULL COMMENT '权限',
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_name_uindex` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='职位管理表';

-- ----------------------------
-- Records of role
-- ----------------------------
BEGIN;
INSERT INTO `role` VALUES (1, '管理员', 'ADMIN');
INSERT INTO `role` VALUES (2, '库管', 'WAREHOUSE');
INSERT INTO `role` VALUES (3, '销售', 'SALE');
COMMIT;

-- ----------------------------
-- Table structure for stock
-- ----------------------------
DROP TABLE IF EXISTS `stock`;
CREATE TABLE `stock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `brand` int(11) NOT NULL COMMENT '品牌',
  `type` int(11) NOT NULL COMMENT '1-镜架，2-镜片，3-隐形，4-药水，5-太阳镜，6-老花镜, 7-其他',
  `model` varchar(100) NOT NULL COMMENT '型号',
  `number` int(11) NOT NULL COMMENT '数量',
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `stock_brand` (`brand`),
  KEY `stock_type` (`type`),
  KEY `stock_model` (`model`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='库存表';

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '姓名.',
  `sex` tinyint(2) unsigned DEFAULT NULL COMMENT '性别.',
  `phone` varchar(20) NOT NULL COMMENT '电话.',
  `role_id` int(11) NOT NULL COMMENT '用户角色',
  `remarks` varchar(1000) DEFAULT NULL COMMENT '描述',
  `password_encrypted` varchar(255) DEFAULT NULL COMMENT '加密后的密码.',
  `current_token` varchar(1000) DEFAULT NULL COMMENT '当前的认证令牌',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, '管理员', 1, '18888888888', 1, NULL, '9d21b40b0149659559c1e93dc62f52ceb1cc298df5c18283467e1ed97f6957c1', NULL, '2020-04-02 09:35:11', '2020-04-02 09:35:11');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
