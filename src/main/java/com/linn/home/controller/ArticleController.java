package com.linn.home.controller;

import com.github.pagehelper.PageInfo;
import com.linn.frame.controller.BaseController;
import com.linn.frame.entity.ResultBean;
import com.linn.frame.util.DateUtils;
import com.linn.frame.util.SysContent;
import com.linn.home.entity.Archive;
import com.linn.home.entity.Article;
import com.linn.home.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2018/1/14.
 */
@Controller
public class ArticleController extends BaseController {

    @Resource
    private ArticleService articleService;

    /**
     * 发布文章
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/publishArticle",method = RequestMethod.POST)
    public ResultBean publishArticle(Article article) throws Exception {

        if(StringUtils.isEmpty(article.getId())) {
            //添加
            article.setGmtCreate(new Date());
            article.setGmtModified(new Date());
            int ret = articleService.addArticle(article);
        }else {
            //更新
            article.setGmtModified(new Date());
            int ret = articleService.updateArticle(article);
        }

        return new ResultBean(SysContent.SUCCESS,"发布成功");
    }

    /**
     * 查找所有文章
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/toArticleListAdmin")
    public List<Article> toArticleListAdmin() throws Exception {

        List<Article> articles = articleService.findArticleListAdmin();
        return articles;
    }

    /**
     * 跳转到文章列表
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/toArticleList")
    public PageInfo toArticleList(@RequestBody Map<String, String> map) throws Exception {
        PageInfo pageInfo = new PageInfo();
        if(map.containsKey("pageNum") && !StringUtils.isEmpty(map.get("pageNum"))){
            Integer pageNum = Integer.parseInt(map.get("pageNum"));
            pageInfo.setPageNum(pageNum);
        }else{
            pageInfo.setPageNum(1);
        }
        if(map.containsKey("pageSize") && !StringUtils.isEmpty(map.get("pageSize"))){
            Integer pageSize = Integer.parseInt(map.get("pageSize"));
            pageInfo.setPageSize(pageSize);
        }else{
            pageInfo.setPageSize(15);
        }

        if(map.containsKey("categoryId") && !StringUtils.isEmpty(map.get("categoryId"))){
            Integer categoryId = Integer.parseInt(map.get("categoryId"));
            pageInfo = articleService.selectArticleByCategoryId(categoryId,pageInfo);
        }
        if(map.containsKey("date") && !StringUtils.isEmpty(map.get("date")) ){
            String date = map.get("date");
            Date firstDay = DateUtils.firstDayByMonth(date);
            Date lastDay = DateUtils.lastDayByMonth(date);
            pageInfo = articleService.selectArticleByArchiveDate(firstDay,lastDay,pageInfo);
        }

        return pageInfo;
    }

    @ResponseBody
    @RequestMapping("/toArticleDetail")
    private Article toArticleDetail(@RequestBody Article article) throws Exception {

        if(article != null) {
            article = articleService.selectArticleById(article.getId());
        }
        return article;

    }

    @ResponseBody
    @RequestMapping("/getArchiveList")
    private List<Archive> getArchiveList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Archive> archives = null;

        archives = articleService.selectAllArchive();

        return archives;
    }

    @ResponseBody
    @RequestMapping("/delArticle")
    public ResultBean delArticle(int[] ids) throws Exception {

        if(ids!=null && ids.length > 0){
            for (int id: ids) {
                int ret = articleService.deleteArticle(id);
            }
        }
        return new ResultBean(SysContent.SUCCESS,"删除成功");
    }

    @ResponseBody
    @RequestMapping("/searchArticleList")
    private PageInfo searchArticleList(@RequestBody Map<String, String> map) throws Exception {
        PageInfo pageInfo = new PageInfo();
        if(map.containsKey("pageNum") && !StringUtils.isEmpty(map.get("pageNum"))){
            Integer pageNum = Integer.parseInt(map.get("pageNum"));
            pageInfo.setPageNum(pageNum);
        }else{
            pageInfo.setPageNum(1);
        }
        if(map.containsKey("pageSize") && !StringUtils.isEmpty(map.get("pageSize"))){
            Integer pageSize = Integer.parseInt(map.get("pageSize"));
            pageInfo.setPageSize(pageSize);
        }else{
            pageInfo.setPageSize(15);
        }

        if(map.containsKey("searchContent") && !StringUtils.isEmpty(map.get("searchContent"))){
            String searchContent = map.get("searchContent");
            pageInfo = articleService.selectArticleBySearch(searchContent,pageInfo);
        }else {//为传入任何条件，则显示最近记录
            pageInfo = articleService.selectArticleList(pageInfo);
        }
        return pageInfo;
    }

    @RequestMapping("/uploadImage")
    public void uploadImage(
            @RequestParam(value = "upload",required = false) CommonsMultipartFile file,
            HttpServletRequest request,
            HttpServletResponse response,
            ModelMap model
    ) {
        List<String> urls = new ArrayList<String>();

        String path = request.getSession().getServletContext().getRealPath("upload");
        String fileName = file.getOriginalFilename();
        File targetFile = new File(path,fileName);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        //保存
        try{
            file.transferTo(targetFile);
            urls.add(request.getContextPath() + "/upload/" + fileName);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
        }
        // 结合ckeditor功能
        // imageContextPath为图片在服务器地址，如upload/123.jpg,非绝对路径
        String imageContextPath = request.getContextPath() + "/upload/" + fileName;
        String callback = request.getParameter("CKEditorFuncNum");

        StringBuffer sb = new StringBuffer();
        sb.append("<script type=\"text/javascript\">");
        sb.append("window.parent.CKEDITOR.tools.callFunction(" + callback + ",'" + imageContextPath + "',''" + ")");
        sb.append("</script>");
        writer(response,sb.toString());

    }
}
