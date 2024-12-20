CREATE TABLE `sys_log_operate` (
    `id` INT AUTO_INCREMENT PRIMARY KEY COMMENT '序号',
    `module_name` VARCHAR(255) NOT NULL COMMENT '请求模块',
    `request_url` VARCHAR(255) NOT NULL COMMENT '请求地址',
    `request_params` TEXT COMMENT '请求参数',
    `request_method` VARCHAR(10) NOT NULL COMMENT '请求方法 (GET, POST, etc.)',
    `operation_description` VARCHAR(255) COMMENT '操作说明',
    `ip_address` VARCHAR(45) NOT NULL COMMENT 'IP地址',
    `user_agent` VARCHAR(255) COMMENT '请求浏览器',
    `response_code` INT COMMENT '响应码',
    `os` VARCHAR(100) COMMENT '操作系统',
    `response_message` TEXT COMMENT '返回信息',
    `operator` VARCHAR(255) COMMENT '操作人',
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'
) COMMENT='系统操作日志表';