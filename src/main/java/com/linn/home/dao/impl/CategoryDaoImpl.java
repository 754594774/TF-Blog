package com.linn.home.dao.impl;

import com.linn.frame.util.MyBatisUtils;
import com.linn.home.dao.CategoryDao;
import com.linn.home.entity.Category;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

/**
 * Created by admin on 2018/1/13.
 */
@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao {
    @Override
    public List<Category> selectAllCategory() throws IOException {
        SqlSession session =  MyBatisUtils.getSqlSession();

        CategoryDao mapper = session .getMapper(CategoryDao.class);
        List<Category> categorys = mapper.selectAllCategory();
        session.close();
        return categorys;
    }
}
