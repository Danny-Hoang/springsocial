package com.example.springsocial.api.category

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.GetMapping.*
import java.util.*


@RestController
@RequestMapping("/api")
class CategoryController {
    @Autowired
    private val categoryRepository: CategoryRepository? = null

    @get:GetMapping(value = ["/categories"])
    val all: List<Category?>
        get() = categoryRepository!!.findAll()

    @PostMapping("/categories")
    fun create(@RequestBody category: Category): ResponseEntity<Category> {
        return ResponseEntity(categoryRepository!!.save(category), HttpStatus.CREATED)
    }

    @GetMapping("/categories/{categoryId}")
    fun getOne(@PathVariable categoryId: Int): Optional<Category?> {
        return categoryRepository!!.findById(categoryId)
    }
}