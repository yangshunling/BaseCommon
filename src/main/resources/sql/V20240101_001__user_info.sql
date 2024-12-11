DROP TABLE IF EXISTS sys_user_info;
CREATE TABLE `sys_user_info` (
    `user_id` VARCHAR(64) PRIMARY KEY COMMENT '用户ID',
    `user_name` VARCHAR(50) NOT NULL COMMENT '用户名',
    `password` VARCHAR(255) NOT NULL COMMENT '密码',
    `email` VARCHAR(100) COMMENT '邮箱',
    `status` INT DEFAULT 1 COMMENT '账户状态',
    `created_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '账户创建时间',
    `updated_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '账户更新时间',
    INDEX `idx_username` (`user_name`) COMMENT '用户名索引'
) COMMENT='用户信息表';