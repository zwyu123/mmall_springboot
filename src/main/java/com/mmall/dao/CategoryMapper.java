package com.mmall.dao;

import com.mmall.pojo.Category;

import java.util.List;

public interface CategoryMapper {
    List<Category> selectCategoryChildrenByParentId(Integer id);
}
