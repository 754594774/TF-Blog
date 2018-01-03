package com.linn.home.dao;

import com.linn.home.entity.Category;

import java.util.List;

public interface CategoryMapper {
    /**
     * 查询所有文章分类
     * @return
     */
    List<Category> selectAllCategory();
}
