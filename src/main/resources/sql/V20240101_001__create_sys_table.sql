-- 系统用户表
CREATE TABLE sys_user
(
    user_id       INT AUTO_INCREMENT PRIMARY KEY COMMENT '用户ID',
    user_name     VARCHAR(50)  NOT NULL COMMENT '用户名',
    password      VARCHAR(255) NOT NULL COMMENT '用户密码',
    mobile        VARCHAR(11)  NOT NULL COMMENT '手机号码',
    email         VARCHAR(100) NOT NULL COMMENT '邮箱',
    department_id INT          NOT NULL COMMENT '部门ID',
    user_status   INT       DEFAULT 1 COMMENT '账户状态',
    created_time  TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '账户创建时间',
    updated_time  TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '账户更新时间'
) COMMENT ='用户表';

-- 系统部门表
CREATE TABLE sys_department
(
    department_id   INT AUTO_INCREMENT PRIMARY KEY COMMENT '部门ID',
    department_name VARCHAR(128) NOT NULL COMMENT '部门名称',
    parent_id       INT          NOT NULL DEFAULT 0 COMMENT '父部门ID，0表示根部门',
    description     VARCHAR(255) COMMENT '角色描述',
    create_time     TIMESTAMP             DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time     TIMESTAMP             DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT ='部门表';

-- 系统角色表
CREATE TABLE sys_role
(
    role_id     INT AUTO_INCREMENT PRIMARY KEY COMMENT '角色ID',
    role_name   VARCHAR(128) NOT NULL COMMENT '角色名称',
    description VARCHAR(128) COMMENT '角色描述',
    role_status TINYINT   DEFAULT 1 COMMENT '角色状态，1表示启用，0表示禁用',
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT ='角色表';

-- 系统菜单表
CREATE TABLE sys_menu
(
    menu_id        INT AUTO_INCREMENT PRIMARY KEY COMMENT '主键 ID',
    menu_name      VARCHAR(128) NOT NULL COMMENT '菜单名称',
    menu_parent_id INT        DEFAULT 0 COMMENT '父菜单 ID，顶级菜单为 0',
    menu_path      VARCHAR(255) COMMENT '菜单路径，前端路由用',
    menu_icon      VARCHAR(255) COMMENT '菜单图标，前端显示用',
    menu_order     INT        DEFAULT 0 COMMENT '排序，数字越小越靠前',
    is_enabled     TINYINT(1) DEFAULT 1 COMMENT '是否启用：1-启用，0-禁用',
    create_time    DATETIME   DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time    DATETIME   DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT ='系统菜单表';

-- 系统权限表
CREATE TABLE sys_permissions
(
    permissions_id    INT AUTO_INCREMENT PRIMARY KEY COMMENT '权限ID',
    permissions_name  VARCHAR(128) NOT NULL COMMENT '权限名称',
    permissions_value VARCHAR(128) NOT NULL COMMENT '权限值',
    menu_id           INT          NOT NULL COMMENT '关联的菜单ID',
    description       VARCHAR(255) COMMENT '权限描述',
    create_time       TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time       TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT ='系统权限表';

-- 用户角色表
CREATE TABLE sys_user_roles
(
    user_id INT COMMENT '用户ID',
    role_id INT COMMENT '角色ID'
) COMMENT ='用户角色表';

-- 角色权限表
CREATE TABLE sys_role_permissions
(
    role_id       INT COMMENT '角色ID',
    permission_id INT COMMENT '权限ID'
) COMMENT ='角色权限表';

-- 登录日志表
CREATE TABLE sys_log_login
(
    login_id    INT AUTO_INCREMENT PRIMARY KEY COMMENT '序号',
    username    VARCHAR(255) NOT NULL COMMENT '登录用户名',
    login_ip    VARCHAR(45)  NOT NULL COMMENT '登录IP',
    operator    VARCHAR(255) COMMENT '运营商',
    continent   VARCHAR(100) COMMENT '大洲',
    country     VARCHAR(100) COMMENT '国家',
    province    VARCHAR(100) COMMENT '省份',
    city        VARCHAR(100) COMMENT '城市',
    district    VARCHAR(100) COMMENT '县区',
    longitude   DECIMAL(9, 6) COMMENT '经度',
    latitude    DECIMAL(9, 6) COMMENT '纬度',
    login_type  VARCHAR(50) COMMENT '登录类型',
    os          VARCHAR(100) COMMENT '操作系统',
    browser     VARCHAR(100) COMMENT '浏览器名',
    user_agent  VARCHAR(255) COMMENT 'Agent信息',
    department  VARCHAR(255) COMMENT '所属部门',
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'
) COMMENT ='系统登录日志表';

-- 操作日志表
CREATE TABLE sys_log_operate
(
    operate_id            INT AUTO_INCREMENT PRIMARY KEY COMMENT '序号',
    module_name           VARCHAR(255) NOT NULL COMMENT '请求模块',
    request_url           VARCHAR(255) NOT NULL COMMENT '请求地址',
    request_params        TEXT COMMENT '请求参数',
    request_method        VARCHAR(10)  NOT NULL COMMENT '请求方法 (GET, POST, etc.)',
    operation_description VARCHAR(255) COMMENT '操作说明',
    ip_address            VARCHAR(45)  NOT NULL COMMENT 'IP地址',
    user_agent            VARCHAR(255) COMMENT '请求浏览器',
    response_code         INT COMMENT '响应码',
    os                    VARCHAR(100) COMMENT '操作系统',
    response_message      TEXT COMMENT '返回信息',
    operator              VARCHAR(255) COMMENT '操作人',
    create_time           TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'
) COMMENT ='系统操作日志表';