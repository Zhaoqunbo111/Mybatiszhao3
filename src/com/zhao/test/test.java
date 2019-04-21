package com.zhao.test;

import com.zhao.mapper.CategoryMapper;
import com.zhao.po.Category;
import com.zhao.po.Product;
import com.zhao.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class test {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession(false);
        CategoryMapper categoryMapper= sqlSession.getMapper(CategoryMapper.class);
        List<Category> categories =categoryMapper.listCategory();
        for (Category category:categories) {
            System.out.println(category);
            List<Product> products=category.getProducts();
            for (Product product:products) {
                System.out.println("\t"+product);
            }
        }
    }
}
