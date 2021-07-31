package com.example.springsocial.api.book

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/books")
class BookController(
        val bookService: BookService,
        val bookRepository: BookRepository
) {

    @GetMapping("/{id}")
    fun getOne(@PathVariable(value = "id") id: Long): ResponseEntity<Book> {
        var book: Optional<Book> = bookRepository.findById(id);
        if(book.isPresent) {
            return ResponseEntity.ok(book.get());
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/search")
    fun searchBooks(): List<BookDto> {

        var result = bookService.searchBook()
        return result;
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody bookRequest: BookRequest): ResponseEntity<Book> {
        return bookService.updateBook(id, bookRequest);
    }

    @GetMapping("/listBookDto")
    fun getBooksDto(): List<Book> {

//        var result = bookRepository.getBooksDto()
        var result = bookRepository.getBooksDto2()
        return result;
    }


    //    @EntityGraph(
//        type = EntityGraph.EntityGraphType.FETCH,
//        attributePaths = ["publisher"]
//    )
//    @GetMapping("/findAll")
//    fun findBooks(
//            @RequestParam(defaultValue = "") title: String
////        @RequestParam(defaultValue = "20") limit: Int,
////        @RequestParam(defaultValue = "0") offset: Int,
////        @RequestParam(defaultValue = "0") page: Int,
////        @RequestParam(defaultValue = "3") size: Int
//    ): List<BookDto>  {
////        val p = PageRequest.of(offset, limit, Sort.Direction.DESC, "createdAt")
////        val p = PageRequest.of(offset, limit)
//        var result = bookService.findBookWCategoryLike(title)
//        return result
//    }

    fun bookView(book: Book): Map<String, Book> {
        return mapOf("book" to book)
    }

}