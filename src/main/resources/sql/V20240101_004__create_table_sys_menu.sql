CREATE TABLE sys_menu (
    menu_id INT AUTO_INCREMENT PRIMARY KEY COMMENT '主键 ID',
    menu_parent_id INT DEFAULT 0 COMMENT '父菜单 ID，顶级菜单为 0',
    menu_name VARCHAR(255) NOT NULL COMMENT '菜单名称',
    menu_path VARCHAR(255) COMMENT '菜单路径，前端路由用',
    menu_icon VARCHAR(255) COMMENT '菜单图标，前端显示用',
    menu_order INT DEFAULT 0 COMMENT '排序，数字越小越靠前',
    is_visible TINYINT(1) DEFAULT 1 COMMENT '是否可见：1-可见，0-不可见',
    is_enabled TINYINT(1) DEFAULT 1 COMMENT '是否启用：1-启用，0-禁用',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    remark VARCHAR(500) COMMENT '备注信息'
) COMMENT='系统菜单表';