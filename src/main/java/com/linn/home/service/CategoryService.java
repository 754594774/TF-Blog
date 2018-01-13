package com.linn.home.service;

import com.linn.home.entity.Category;

import java.io.IOException;
import java.util.List;

public interface CategoryService {

    List<Category> findCategoryList () throws Exception;
}