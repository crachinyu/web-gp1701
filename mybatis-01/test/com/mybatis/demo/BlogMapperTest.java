package com.mybatis.demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.mybatis.pojo.Blog;
import com.mybatis.util.MybatisUtil;

public class BlogMapperTest {

	@Test
	public void testSelectBlogNoInterface() {
		SqlSession session = MybatisUtil.geSqlSession();
		Blog blog = (Blog) session.selectOne("com.mybatis.demo.BlogMapper.selectBlog", 101);
		session.close();
		System.out.println(blog);
	}

	@Test
	public void testSelectBlog() {

		SqlSession session = MybatisUtil.geSqlSession();
		BlogMapper blogMapper = session.getMapper(BlogMapper.class);
		Blog blog = blogMapper.selectBlog(1);

		session.close();
		System.out.println(blog);

	}

	/**
	 * @author crachinyu #和$之间的区别。
	 */
	@Test
	public void testSelectBlogByTitle() {

		SqlSession session = MybatisUtil.geSqlSession();
		BlogMapper blogMapper = session.getMapper(BlogMapper.class);
		List<Blog> blogList = blogMapper.selectBlogByTitle("%1%");

		session.close();
		System.out.println(blogList);
	}

	@Test
	public void testSelectBlogByTitle2() {

		SqlSession session = MybatisUtil.geSqlSession();
		BlogMapper blogMapper = session.getMapper(BlogMapper.class);
		List<Blog> blogList = blogMapper.selectBlogByTitle2("1");

		session.close();
		System.out.println(blogList);
	}

	/**
	 * @author crachinyu 排序查询
	 */
	@Test
	public void testSelectBlogBySort() {

		SqlSession session = MybatisUtil.geSqlSession();
		BlogMapper blogMapper = session.getMapper(BlogMapper.class);
		List<Blog> blogList = blogMapper.selectBlogBySort("title");

		session.close();
		System.out.println(blogList);
	}

	@Test
	public void testSelectBlogByPage() {

		SqlSession session = MybatisUtil.geSqlSession();
		BlogMapper blogMapper = session.getMapper(BlogMapper.class);
		List<Blog> blogList = blogMapper.selectBlogByPage(0, 2);

		session.close();
		System.out.println(blogList);
	}

	@Test
	public void testSelectBlogByPage3() {

		SqlSession session = MybatisUtil.geSqlSession();
		BlogMapper blogMapper = session.getMapper(BlogMapper.class);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("offset", 0);
		map.put("pagesize", 2);
		List<Blog> blogList = blogMapper.selectBlogByPage3(map);

		session.close();
		System.out.println(blogList);
	}

	@Test
	public void testInsertBlog() {

		SqlSession session = MybatisUtil.geSqlSession();
		BlogMapper blogMapper = session.getMapper(BlogMapper.class);
		Blog blog = new Blog();
		int count = blogMapper.insertBlog(blog);
		session.commit();
		session.close();
		System.out.println(blog);
		System.out.println(count);
	}

	@Test
	public void testInsertBlog2() {

		SqlSession session = MybatisUtil.geSqlSession();
		BlogMapper blogMapper = session.getMapper(BlogMapper.class);
		Blog blog = new Blog();
		int count = blogMapper.insertBlogMysql(blog);
		session.commit();
		session.close();
		System.out.println(blog);
		System.out.println(count);
	}

	@Test
	public void testupdateBlog() {

		SqlSession session = MybatisUtil.geSqlSession();
		BlogMapper blogMapper = session.getMapper(BlogMapper.class);
		Blog blog = new Blog();
		blog.setTitle("小米");
		blog.setId(6);
		int count = blogMapper.updateBlog(blog);
		session.commit();
		session.close();
		System.out.println(blog);
		System.out.println(count);
	}

	@Test
	public void testdeleteBlogById() {

		SqlSession session = MybatisUtil.geSqlSession();
		BlogMapper blogMapper = session.getMapper(BlogMapper.class);

		int count = blogMapper.deleteBlogById(5);
		session.commit();
		session.close();

		System.out.println(count);
	}

	@Test
	public void testselectActiveBlogByTitle() {

		SqlSession session = MybatisUtil.geSqlSession();
		BlogMapper blogMapper = session.getMapper(BlogMapper.class);
		List<Blog> blogList = blogMapper.selectActiveBlogByTitle("小");

		session.close();
		System.out.println(blogList);
	}
	
	@Test
	public void testselectActiveBlogByTitleOrStyle() {

		SqlSession session = MybatisUtil.geSqlSession();
		BlogMapper blogMapper = session.getMapper(BlogMapper.class);
		Blog blog = new Blog();
		blog.setTitle("%o%");
		blog.setStyle("ssfg");
		List<Blog> blogList = blogMapper.selectActiveBlogByTitleOrStyle(blog);

		session.close();
		System.out.println(blogList);
	}
	
	@Test
	public void testselectBlogByCondition() {

		SqlSession session = MybatisUtil.geSqlSession();
		BlogMapper blogMapper = session.getMapper(BlogMapper.class);
		Blog blog = new Blog();
		blog.setTitle("%o%");
		blog.setStyle("ssfg");
		List<Blog> blogList = blogMapper.selectBlogByCondition(blog);

		session.close();
		System.out.println(blogList);
	}
	@Test
	public void testupdateBlogByCondition() {

		SqlSession session = MybatisUtil.geSqlSession();
		BlogMapper blogMapper = session.getMapper(BlogMapper.class);
		Blog blog = new Blog();
		blog.setTitle("小米");
		blog.setId(4);
		int count = blogMapper.updateBlogByCondition(blog);
		session.commit();
		session.close();
		System.out.println(blog);
		System.out.println(count);
	}
	
	@Test
	public void testselectBlogByConditionTrim() {

		SqlSession session = MybatisUtil.geSqlSession();
		BlogMapper blogMapper = session.getMapper(BlogMapper.class);
		Blog blog = new Blog();
		blog.setTitle("%o%");
		blog.setStyle("ssfg");
		List<Blog> blogList = blogMapper.selectBlogByConditionTrim(blog);

		session.close();
		System.out.println(blogList);
	}
	@Test
	public void testupdateBlogByConditionTrim() {

		SqlSession session = MybatisUtil.geSqlSession();
		BlogMapper blogMapper = session.getMapper(BlogMapper.class);
		Blog blog = new Blog();
		blog.setTitle("小米");
		blog.setId(4);
		int count = blogMapper.updateBlogByConditionTrim(blog);
		session.commit();
		session.close();
		System.out.println(blog);
		System.out.println(count);
	}
	
	@Test
	public void testdeleteBlogList() {

		SqlSession session = MybatisUtil.geSqlSession();
		BlogMapper blogMapper = session.getMapper(BlogMapper.class);
		List ids=Arrays.asList(4,6);
		int count = blogMapper.deleteBlogList(ids);
		session.commit();
		session.close();
		
		System.out.println(count);
	}
	/**
	 * 测试一级缓存
	 */
	@Test
	public void testSelectBlogCacheLeveOne1() {

		SqlSession session = MybatisUtil.geSqlSession();
		BlogMapper blogMapper = session.getMapper(BlogMapper.class);
		
		Blog blog1 = blogMapper.selectBlog(1);
		System.out.println("结果已查询");
		
		Blog blog2 = blogMapper.selectBlog(1);
		System.out.println("结果已查询，从缓存中获取数据");
		
		session.close();
		
	}
	
	@Test
	public void testSelectBlogCacheLeveOne2() {

		SqlSession session = MybatisUtil.geSqlSession();
		BlogMapper blogMapper = session.getMapper(BlogMapper.class);
		
		Blog blog1 = blogMapper.selectBlog(1);
		System.out.println("结果已查询");
		blog1.setFeatured(true);
		blogMapper.updateBlog(blog1);
		System.out.println("刷新缓存");
		Blog blog2 = blogMapper.selectBlog(1);
		System.out.println("重新查询");
		session.commit();
		session.close();
		
	}
	
	/**
	 * 测试二级缓存
	 */
	@Test
	public void testSelectBlogCacheLeveTwo1() {

		SqlSession session1 = MybatisUtil.geSqlSession();
		BlogMapper blogMapper1 = session1.getMapper(BlogMapper.class);
		
		Blog blog1 = blogMapper1.selectBlog(1);
		System.out.println("结果已查询");
		blog1.setFeatured(true);
		blogMapper1.updateBlog(blog1);
		System.out.println("刷新缓存");
		session1.commit();
		session1.close();
		
		SqlSession session2 = MybatisUtil.geSqlSession();
		BlogMapper blogMapper2 = session2.getMapper(BlogMapper.class);
		
		Blog blog2 = blogMapper2.selectBlog(1);
		System.out.println("结果已查询，重新查询！");
		
		session2.close();
		
	}
}
