DROP table sys_user_info;
CREATE TABLE `sys_user_info` (
    `user_id` INT UNSIGNED AUTO_INCREMENT PRIMARY KEY COMMENT '用户ID',
    `username` VARCHAR(50) NOT NULL COMMENT '用户名',
    `password` VARCHAR(255) NOT NULL COMMENT '密码',
    `email` VARCHAR(100) COMMENT '邮箱',
    `status` INT DEFAULT 1 COMMENT '账户状态',
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '账户创建时间',
    `updated_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '账户更新时间',
    INDEX `idx_username` (`username`) COMMENT '用户名索引'
) COMMENT='用户信息表';