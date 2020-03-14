package com.mmall.service;

import com.mmall.dao.CategoryMapper;
import com.mmall.pojo.Category;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> getChildrenParallelCategory(Integer id) {
        List<Category> categoryList = categoryMapper.selectCategoryChildrenByParentId(id);
        if (CollectionUtils.isEmpty(categoryList)) {
            log.info("未找到当前分类的子分类");
        }
        return categoryList;
    }
}
