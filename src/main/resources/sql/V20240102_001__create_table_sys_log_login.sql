CREATE TABLE `sys_log_login` (
    `id` INT AUTO_INCREMENT PRIMARY KEY COMMENT '序号',
    `username` VARCHAR(255) NOT NULL COMMENT '登录用户名',
    `login_ip` VARCHAR(45) NOT NULL COMMENT '登录IP',
    `operator` VARCHAR(255) COMMENT '运营商',
    `continent` VARCHAR(100) COMMENT '大洲',
    `country` VARCHAR(100) COMMENT '国家',
    `province` VARCHAR(100) COMMENT '省份',
    `city` VARCHAR(100) COMMENT '城市',
    `district` VARCHAR(100) COMMENT '县区',
    `longitude` DECIMAL(9, 6) COMMENT '经度',
    `latitude` DECIMAL(9, 6) COMMENT '纬度',
    `login_type` VARCHAR(50) COMMENT '登录类型',
    `os` VARCHAR(100) COMMENT '操作系统',
    `browser` VARCHAR(100) COMMENT '浏览器名',
    `user_agent` VARCHAR(255) COMMENT 'Agent信息',
    `department` VARCHAR(255) COMMENT '所属部门',
    `remark` TEXT COMMENT '备注',
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'
) COMMENT='系统登录日志表';