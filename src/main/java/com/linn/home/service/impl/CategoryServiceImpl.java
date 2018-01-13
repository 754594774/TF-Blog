package com.linn.home.service.impl;

import com.linn.frame.util.MyBatisUtils;
import com.linn.home.dao.CategoryDao;
import com.linn.home.entity.Category;
import com.linn.home.service.CategoryService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryDao categoryDao;

    @Override
    public List<Category> findCategoryList() throws IOException {

        return categoryDao.selectAllCategory();
    }
}