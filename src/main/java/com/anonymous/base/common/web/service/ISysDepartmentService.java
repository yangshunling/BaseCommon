package com.anonymous.base.common.web.service;

import com.anonymous.base.common.web.model.dto.SysDepartmentDTO;
import com.anonymous.base.common.web.model.entity.SysDepartmentEntity;
import com.anonymous.base.common.web.model.vo.SysDepartmentVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 部门表 服务类
 * </p>
 *
 * @author Anonymous
 * @since 2025-01-10 13:56:13
 */
public interface ISysDepartmentService extends IService<SysDepartmentEntity> {

   /**
    * 保存
    *
    * @param dto 参数
    * @return 保存结果
    */
   int insert(SysDepartmentDTO dto);

   /**
    * 根据主键查询VO
    *
    * @param pk 主键
    * @return VO
    */
    SysDepartmentVO selectByPk(String pk);

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
    * @param dto 查询参数
    * @return IPage
    */
    IPage<SysDepartmentVO> selectByPage(SysDepartmentDTO dto);
}
