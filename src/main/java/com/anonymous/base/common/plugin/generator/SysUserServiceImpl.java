package com.anonymous.base.common.plugin.generator;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import java.util.Optional;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Anonymous
 * @since 2025-01-09 19:30:42
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUserEntity> implements ISysUserService {

   /**
    * 保存
    *
    * @param dto 参数
    * @return 保存结果
    */
    @Override
    public boolean saveOne(SysUserDTO dto) {
        return this.save(SysUserConvertor.INSTANCE.toEntity(dto));
    }

   /**
    * 根据主键查询VO
    *
    * @param pk 主键
    * @return VO
    */
    @Override
    public SysUserVO getByPk(String pk) {
        SysUserEntity domain = this.getById(pk);
        return SysUserConvertor.INSTANCE.toVO(domain);
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
    * @param page  分页组件
    * @param dto 查询参数
    * @return IPage
    */
    @Override
    public IPage<SysUserVO> selectPageByDto(IPage<SysUserEntity> page, SysUserDTO dto) {
        QueryWrapper<SysUserEntity> queryWrapper = Wrappers.query();
        IPage<SysUserEntity> iPage = this.getBaseMapper().selectPage(page, queryWrapper);
        return iPage.convert(SysUserConvertor.INSTANCE::toVO);
    }
}
