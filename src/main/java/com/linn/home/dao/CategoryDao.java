package com.linn.home.dao;

import com.linn.home.entity.Category;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;
@Repository("categoryDao")
public interface CategoryDao {
    /**
     * 查询所有文章分类
     * @return
     */
    List<Category> selectAllCategory() throws Exception;
}
