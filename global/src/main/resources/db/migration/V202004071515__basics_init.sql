CREATE TABLE `member` (
    `id` int(11) not null AUTO_INCREMENT,
    `name` varchar(100) not null comment '姓名',
    `phone` varchar(20) not null comment '手机号',
    `birthday` varchar(100) comment '生日',
    `address` varchar(255) comment '住址',
    `amount_total` varchar(100) comment '消费总金额',
    `create_id` varchar(100) DEFAULT NULL COMMENT '创建人',
    `created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8  COMMENT='会员管理表';

CREATE TABLE `consumption` (
    `id` int(11) not null AUTO_INCREMENT,
    `trade_id` int(11) not null comment '商品名称, 库存获取',
    `member_id` int(11) comment '消费会员',
    `number` int(11) comment '销售数量',
    `staff_id` int(11) not null comment '售卖员工',
    `amount` varchar(100) comment '单价',
    `created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8  COMMENT='商品销售表';

CREATE TABLE `stock` (
    `id` int(11) not null AUTO_INCREMENT,
    `brand` int(11) not null comment '品牌',
    `type` int(11) not null comment '1-镜架，2-镜片，3-隐形，4-药水，5-太阳镜，5-老花镜',
    `model` varchar(100) not null comment '型号',
    `number` int(11) not null comment '数量',
    `created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8  COMMENT='库存表';

CREATE TABLE `brand` (
    `id` int(11) not null AUTO_INCREMENT,
    `name` int(11) not null comment '品牌名称',
    `created_at` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8  COMMENT='库存品牌表';

CREATE TABLE `role` (
    `id` int(11) not null AUTO_INCREMENT,
    `name` varchar(100) not null comment '角色名称',
    `permission` varchar(100) not null comment '权限',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8  COMMENT='职位管理表';

INSERT into role (id, name, permission) values (1, '管理员', 'ADMIN'), (2, '库管', 'WAREHOUSE'), (3, '销售' ,'SALE')

