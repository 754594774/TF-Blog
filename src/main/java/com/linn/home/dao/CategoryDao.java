package com.linn.home.dao;

import com.linn.frame.entity.ResultBean;
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

    /**
     * 添加文章分类
     * @return
     * @throws Exception
     */
    int addCategory(Category catg) throws Exception;

    /**
     * 更新文章分类
     * @param catg 实体
     * @return ResultBean
     * @throws Exception
     */
    int updateCategoryById(Category catg) throws Exception;

    /**
     * 删除文章分类
     * @param id
     * @return
     * @throws Exception
     */
    int deleteCategoryById(int id) throws Exception;
}
