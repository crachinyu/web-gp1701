package com.mybatis.demo;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.mybatis.pojo.Blog;

public interface BlogMapper {
      
	Blog selectBlog(Integer id);
	
	List<Blog> selectBlogByTitle(String title);
	
	List<Blog> selectBlogByTitle2(String title);
	
	List<Blog> selectBlogBySort(String column);
	
	List<Blog> selectBlogByPage(int offset,int pagesize);
	
	List<Blog> selectBlogByPage2(@Param(value="offset") int offset,@Param(value="pagesize") int pagesize);
	
	List<Blog> selectBlogByPage3(Map<String, Object> map);
	
	int insertBlog(Blog blog);
	
	int insertBlogMysql(Blog blog);
	
	int updateBlog(Blog blog);
	
	int deleteBlogById(Integer id);
	
	List<Blog> selectActiveBlogByTitle(String title);
	
	List<Blog> selectActiveBlogByTitleOrStyle(Blog blog);
	
	List<Blog> selectBlogByCondition(Blog blog);
	
	int updateBlogByCondition(Blog blog);
	
	List<Blog> selectBlogByConditionTrim(Blog blog);
	
	int updateBlogByConditionTrim(Blog blog);
	
	int deleteBlogList(List ids);
}
