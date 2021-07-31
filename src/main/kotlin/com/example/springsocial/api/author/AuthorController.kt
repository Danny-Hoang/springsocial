package com.example.springsocial.api.author

import com.example.springsocial.exception.ResourceNotFoundException
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/authors")
class AuthorController(
    val authorRepository: AuthorRepository,
    val authorService: AuthorService
) {

    @GetMapping("/search")
    fun searchBooks(
        @RequestParam authorName: String,
        @RequestParam(defaultValue = "0") page: Int,
        @RequestParam(defaultValue = "20") size: Int,
    ): Page<Author> {
        //pageable đã bao gồm paging và sorting
        val p = PageRequest.of(page, size, Sort.Direction.DESC, "authorName")
        var result = authorRepository.findAuthorNameLike(authorName, p);
        return result;
    }

    @GetMapping("/list")
    fun list(): List<AuthorDto> {
        return authorService.getAll();
    }

    @GetMapping("/test")
    fun test(): Any {
        authorRepository.findById(1)?.let {
//            return mapOf("article" to AuthorDto("Thai",15), "count" to 1)
            return mapOf("article" to it)
        }

        throw ResourceNotFoundException("Author", "authorID", 1)
    }
}