package com.example.springsocial.api.book;

import com.example.springsocial.api.category.Category;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public interface DataDto {
    Integer getBookId();
    String getBookTitle();

    List<CategoryDto> getCategories();

    interface CategoryDto {
        String getName();
        Integer getId();
        String getCode();
    }

}

