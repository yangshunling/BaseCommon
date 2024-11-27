package com.anonymous.base.common.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 脚本执行信息
 * </p>
 *
 * @author Anonymous
 * @since 2024-06-24 15:35:04
 */
@Getter
@Setter
@TableName("cbb_script_exec_info")
public class CbbScriptExecInfo {

    /**
     * 模块名称
     */
    @TableId("module_name")
    private String moduleName;

    /**
     * 版本
     */
    @TableField("version")
    private String version;

    /**
     * 文件id
     */
    @TableField("file_id")
    private String fileId;

    /**
     * 执行状态
     */
    @TableField("exec_status")
    private Integer execStatus;

    /**
     * 日志内容
     */
    @TableField("log_content")
    private String logContent;

    /**
     * 异常日志
     */
    @TableField("error_log")
    private String errorLog;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField("modify_time")
    private Date modifyTime;
}
