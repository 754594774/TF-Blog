package com.linn;

import com.linn.home.entity.Category;
import com.linn.home.service.impl.CategoryServiceImpl;

import java.io.IOException;
import java.util.List;

public class Test {

    public static void main(String[] args) throws IOException {

        CategoryServiceImpl categoryServiceImpl  = new CategoryServiceImpl();
        List<Category> categorys = categoryServiceImpl.findCategoryList();
        System.out.println(categorys);
//        SqlSession session =  MyBatisUtils.getSqlSession();
//
//        CategoryMapper mapper = session.getMapper(CategoryMapper.class);
//        Category category = mapper.selectCategory(1);
//        System.out.println(category);
//        session.close();

    }
}
