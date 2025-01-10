package com.anonymous.base.common.web.service.impl;

import com.anonymous.base.common.web.model.convertor.SysDepartmentConvertor;
import com.anonymous.base.common.web.model.dto.SysDepartmentDTO;
import com.anonymous.base.common.web.model.entity.SysDepartmentEntity;
import com.anonymous.base.common.web.model.vo.SysDepartmentVO;
import com.anonymous.base.common.web.service.ISysDepartmentService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.anonymous.base.common.web.mapper.SysDepartmentMapper;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author Anonymous
 * @since 2025-01-10 14:40:41
 */
@Service
public class SysDepartmentServiceImpl extends ServiceImpl<SysDepartmentMapper, SysDepartmentEntity> implements ISysDepartmentService {

    @Autowired
    SysDepartmentMapper mapper;

   /**
    * 保存
    *
    * @param dto 参数
    * @return 保存结果
    */
    @Override
    public int insert(SysDepartmentDTO dto) {
        return mapper.insert(SysDepartmentConvertor.INSTANCE.toEntity(dto));
    }

   /**
    * 根据主键查询VO
    *
    * @param pk 主键
    * @return VO
    */
    @Override
    public SysDepartmentVO selectByPk(String pk) {
        SysDepartmentEntity domain = this.getById(pk);
        return SysDepartmentConvertor.INSTANCE.toVO(domain);
    }

   /**
    * 根据主键删除
    *
    * @param pk 主键
    * @return 删除结果
    */
    @Override
    public Boolean deleteByPk(String pk) {
        return this.removeById(pk);
    }

   /**
    * 支持分页的dto条件查询
    *
    * @param dto 查询参数
    * @return IPage
    */
    @Override
    public IPage<SysDepartmentVO> selectByPage(SysDepartmentDTO dto) {
        // 构造参数
        QueryWrapper<SysDepartmentEntity> queryWrapper = Wrappers.query();
        // 构造分页
        Page<SysDepartmentEntity> page = new Page<>(dto.getPageNum(), dto.getPageSize());
        // 查询结果
        IPage<SysDepartmentEntity> iPage = mapper.selectPage(page, queryWrapper);
        return iPage.convert(SysDepartmentConvertor.INSTANCE::toVO);
    }
}
