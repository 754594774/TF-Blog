package com.linn.home.service.impl;

import com.linn.home.dao.CategoryDao;
import com.linn.home.entity.Category;
import com.linn.home.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryDao categoryDao;

    @Override
    public List<Category> findCategoryList() throws Exception {

        return categoryDao.selectAllCategory();
    }
}