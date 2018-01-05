package com.linn;

import com.linn.frame.util.DateUtils;
import com.linn.home.entity.Category;
import com.linn.home.service.impl.CategoryServiceImpl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Test {

    public static void main(String[] args) throws IOException, ParseException {
        SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
        String str = "201801";
        Date firstDay = DateUtils.firstDayByMonth(str);
        Date lastDay = DateUtils.lastDayByMonth(str);
        System.out.println(sdf.format(firstDay));
        System.out.println(sdf.format(lastDay));
//        CategoryServiceImpl categoryServiceImpl  = new CategoryServiceImpl();
//        List<Category> categorys = categoryServiceImpl.findCategoryList();
//        System.out.println(categorys);
//        SqlSession session =  MyBatisUtils.getSqlSession();
//
//        CategoryMapper mapper = session.getMapper(CategoryMapper.class);
//        Category category = mapper.selectCategory(1);
//        System.out.println(category);
//        session.close();

    }
}
