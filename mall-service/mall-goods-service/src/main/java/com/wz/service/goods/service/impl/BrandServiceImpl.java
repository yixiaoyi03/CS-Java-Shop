package com.wz.service.goods.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wz.api.goods.model.Brand;
import com.wz.service.goods.mapper.BrandMapper;
import com.wz.service.goods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper,Brand> implements BrandService {

    @Autowired
    private BrandMapper brandMapper;
    /**
     * 条件查询
     * @param brand
     * @return
     */
    @Override
    public List<Brand> queryList(Brand brand) {
        QueryWrapper<Brand> queryWrapper = new QueryWrapper<>();
        //根据name查询品牌
        queryWrapper.like("name",brand.getName());
        //根据initial查询
        queryWrapper.eq("initial",brand.getInitial());
        return brandMapper.selectList(queryWrapper);
    }

    /**
     * 分页查询
     * @param brand
     * @return
     */
    @Override
    public Page<Brand> queryPage(Brand brand,Long currentPage,Long size) {
        QueryWrapper<Brand> queryWrapper = new QueryWrapper<>();
        //根据name查询品牌
        queryWrapper.like("name",brand.getName());

        return brandMapper.selectPage(new Page<Brand>(currentPage,size),queryWrapper);
    }


}
