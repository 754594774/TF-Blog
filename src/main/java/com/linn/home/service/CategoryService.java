package com.linn.home.service;

import com.linn.frame.util.MyBatisUtils;
import com.linn.home.dao.CategoryMapper;
import com.linn.home.entity.Category;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

public interface CategoryService {

    List<Category> findCategoryList () throws IOException;
}