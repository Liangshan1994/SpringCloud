package com.pikaqiu.springcloud.blogservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 吕梁山
 * @date 2019/7/19
 */
@RestController
@RequestMapping("/blog/")
public class BlogController {

    @RequestMapping(value = "getBlog", method = RequestMethod.GET)
    public String getBlog(String blogId){
        return "查找博客：" + blogId;
    }

    @RequestMapping(value = "addBlog", method = RequestMethod.POST)
    public String addBlog(String blogName){
        return "新增博客标题：" + blogName;
    }

    @RequestMapping(value = "updateBlog", method = RequestMethod.PUT)
    public String updateBlog(String blogName){
        return "更新博客标题：" + blogName;
    }

    @RequestMapping(value = "deleteBlog", method = RequestMethod.DELETE)
    public String deleteBlog(String blogId){
        return "删除博客：" + blogId;
    }
}
