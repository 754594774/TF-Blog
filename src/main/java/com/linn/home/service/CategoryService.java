package com.linn.home.service;

import com.linn.frame.entity.ResultBean;
import com.linn.home.entity.Category;

import java.io.IOException;
import java.util.List;

public interface CategoryService {

    List<Category> findCategoryList () throws Exception;

    int addCategory (Category catg) throws Exception;

    int updateCategory (Category catg) throws Exception;

    int deleteCategory(int id) throws Exception;
}