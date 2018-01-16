package com.linn.home.controller;

import com.alibaba.fastjson.JSON;
import com.linn.frame.controller.BaseController;
import com.linn.home.entity.Category;
import com.linn.home.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by admin on 2018/1/15.
 */
@Controller
public class CategoryController extends BaseController{

    @Resource
    private CategoryService categoryService;

    @ResponseBody
    @RequestMapping("toCategoryList")
    public List<Category> toCategoryList() throws Exception {

        List<Category>  categorys = categoryService.findCategoryList();
        return categorys;
    }
}
