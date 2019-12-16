SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '姓名.',
  `code` varchar(255) NOT NULL COMMENT '用户工号.',
  `sex` tinyint(2) UNSIGNED COMMENT '性别.',
  `phone` varchar(20) NOT NULL COMMENT '电话.',
  `role_id` int(11) NOT null COMMENT '用户角色',
  `remarks` varchar(1000) DEFAULT NULL COMMENT '描述',
  `password_encrypted` varchar(255) COMMENT '加密后的密码.',
  `current_token` VARCHAR(1000) NULL COMMENT '当前的认证令牌',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

SET FOREIGN_KEY_CHECKS=1;