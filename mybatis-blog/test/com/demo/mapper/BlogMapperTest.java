package com.demo.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.demo.pojo.Blog;
import com.demo.pojo.BlogExample;
import com.mybatis.util.MybatisUtil;

public class BlogMapperTest {

	@Test
	public void testDelete(){
		SqlSession session = MybatisUtil.geSqlSession();
		BlogMapper blogMapper = session.getMapper(BlogMapper.class);
		int count = blogMapper.deleteByPrimaryKey(6);
		session.commit();
		session.close();

		System.out.println("删除了"+count+"条记录");
	}
	
	@Test
	public void testSelect(){
		SqlSession session = MybatisUtil.geSqlSession();
		BlogMapper blogMapper = session.getMapper(BlogMapper.class);
		Blog blog = blogMapper.selectByPrimaryKey(1);

		session.close();
		System.out.println(blog.toString());
	}
	
	@Test
	public void testSelectExample(){
		SqlSession session = MybatisUtil.geSqlSession();
		BlogMapper blogMapper = session.getMapper(BlogMapper.class);
		
		BlogExample blogExample = new BlogExample();
		BlogExample.Criteria blogCriteria = blogExample.createCriteria();
		blogCriteria.andTitleLike("%啊%");
		List<Blog> blog = blogMapper.selectByExample(blogExample);

		session.close();
		System.out.println(blog.toString());
	}
}
