package com.isyxf.blog.controller.admin;

import com.isyxf.blog.dto.Result;
import com.isyxf.blog.entity.Article;
import com.isyxf.blog.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * @author Y.jer
 *
 * 文章请求列表
 */
@RestController
@RequestMapping("/api/article")
public class ArticleController {
    @Resource
    private ArticleService articleService;

    /**
     * TODO: 使用 Article 对象来接收请求体, 这种形式会将 JSON 字符串的值赋予 user 中对应的属性上，需要注意的是
     * JSON字符串中的key必须对应user中的属性名，否则是请求不过去的。
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
    public Result add(@RequestBody Article article) {
        return articleService.add(article);
    }

    /**
     * 更新文章
     * @param article
     * @return
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST, consumes = "application/json")
    public Result edit(@RequestBody Article article) {
        return articleService.edit(article);
    }

    /**
     * 删除文章
     */
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    public Result remove(@PathVariable("id") int id) {
        return articleService.remove(id);
    }


    /**
     * 查询文章信息
     * @param id 文章id
     * @return 文章实体对象
     */
    @RequestMapping(value = "/{id}/detail", method = RequestMethod.GET)
    public Result detail(@PathVariable("id") int id) {
        return articleService.getById(id);
    }

    /**
     * 模糊搜索
     * @param pageNum
     * @param pageSize
     * @param search
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public Result search(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize, @RequestParam("search") String search){
        return articleService.search(pageNum, pageSize, search, -1);
    }
}
