package com.anonymous.base.common.plugin.generator;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author Anonymous
 * @since 2025-01-09 19:30:42
 */
public interface ISysUserService extends IService<SysUserEntity> {

   /**
    * 保存
    *
    * @param dto 参数
    * @return 保存结果
    */
    boolean saveOne(SysUserDTO dto);

   /**
    * 根据主键查询VO
    *
    * @param pk 主键
    * @return VO
    */
    SysUserVO getByPk(String pk);

   /**
    * 根据主键删除
    *
    * @param pk 主键
    * @return 删除结果
    */
    Boolean deleteByPk(String pk);

   /**
    * 支持分页的dto条件查询
    *
    * @param page  分页组件
    * @param param 查询参数
    * @return IPage
    */
    IPage<SysUserVO> selectPageByDto(IPage<SysUserEntity> page, SysUserDTO param);
}
