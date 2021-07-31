package com.example.springsocial.api.category

class CategoryService {
    lateinit var categoryRepository: CategoryRepository

    fun save(category: Category) : Category = categoryRepository.saveAndFlush(category);
    fun getAll(): List<Category> = categoryRepository.findAll()
}