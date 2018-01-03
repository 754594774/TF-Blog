package com.linn.home.service.impl;

import com.linn.frame.util.MyBatisUtils;
import com.linn.home.dao.CategoryMapper;
import com.linn.home.entity.Category;
import com.linn.home.service.CategoryService;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    @Override
    public List<Category> findCategoryList() throws IOException {
        SqlSession session =  MyBatisUtils.getSqlSession();

        CategoryMapper mapper = session .getMapper(CategoryMapper.class);
        List<Category> categorys = mapper.selectAllCategory();
        session.close();
        return categorys;
    }
}