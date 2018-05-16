package com.linn.home.controller;

import com.alibaba.fastjson.JSON;
import com.linn.frame.controller.BaseController;
import com.linn.frame.entity.ResultBean;
import com.linn.frame.util.SysContent;
import com.linn.home.entity.Category;
import com.linn.home.service.CategoryService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

    @ResponseBody
    @RequestMapping("addOrUpdateCatg")
    public ResultBean addOrUpdateCatg(Category catg) throws Exception {
        if(StringUtils.isEmpty(catg.getId())) {
            //添加
            catg.setGmtCreate(new Date());
            catg.setGmtModified(new Date());
            int ret = categoryService.addCategory(catg);

        }else {
            //更新
            catg.setGmtModified(new Date());
            int ret = categoryService.updateCategory(catg);
        }

        return new ResultBean(SysContent.SUCCESS,"操作成功");
    }

    @ResponseBody
    @RequestMapping("delCategory")
    public ResultBean delCategory(int[] ids) throws Exception {

        if(ids!=null && ids.length > 0){
            for (int id: ids) {
                int ret = categoryService.deleteCategory(id);
            }
        }
        return new ResultBean(SysContent.SUCCESS,"删除成功");
    }
}
