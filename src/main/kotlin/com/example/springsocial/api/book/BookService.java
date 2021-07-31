package com.example.springsocial.api.book;

import com.example.springsocial.api.author.Author;
import com.example.springsocial.api.author.AuthorRepository;
import com.example.springsocial.api.category.Category;
import com.example.springsocial.api.category.CategoryRepository;
import com.example.springsocial.api.publisher.Publisher;
import com.example.springsocial.api.publisher.PublisherRepository;
import com.example.springsocial.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Service
public class BookService {
        private final EntityManager entityManager;
        private final BookRepository bookRepository;
        private final CategoryRepository categoryRepository;
        private final PublisherRepository publisherRepository;
        private final AuthorRepository authorRepository;

        public BookService(EntityManager entityManager, BookRepository bookRepository, CategoryRepository categoryRepository,
            PublisherRepository publisherRepository, AuthorRepository authorRepository
        ) {
            this.bookRepository = bookRepository;
            this.entityManager = entityManager;
            this.categoryRepository = categoryRepository;
            this.publisherRepository = publisherRepository;
            this.authorRepository = authorRepository;
        }
//    fun getBook(bookId: Long): ResponseEntity<Book> {
//        return bookRepository.findById(bookId).map {
//            book -> ResponseEntity.ok(book)
//        }.orElse(ResponseEntity.notFound().build())
//    }

//    public List<BookDto> findBookWCategoryLike(String: title) {
//        Query q = entityManager.createNativeQuery("""
//            SELECT b.title, b.book_id as bookID, GROUP_CONCAT(c.category_id,'-',c.category_name) categories
//            FROM `books` b
//            LEFT JOIN book_category bc
//                ON bc.book_id = b.book_id
//            LEFT JOIN categories c
//                ON c.category_id = bc.category_id
//
//            WHERE c.category_name LIKE :title
//            GROUP BY b.book_id
//        """);
//        q.setParameter("title", "%$title%");
//        List<Object> resultList = q.getResultList().stream().toList();
//
//        val result = resultList.map {
//            it ->
//                    val lst = it as Array<out Any>
//            var x = lst[1];
//            BookDto(
//                    lst[0] as String,
//                    lst[1] as BigInteger,
//                    lst[2] as String
//            )
//        }
//        return result
//    }

    public List<BookDto> searchBook() {
        Query q = entityManager.createNativeQuery("""
            SELECT b.title, b.book_id as bookID, GROUP_CONCAT(c.category_id,'-',c.category_name) categories FROM `books` b
            LEFT JOIN book_category bc
                ON bc.book_id = b.book_id
            LEFT JOIN categories c
                ON c.category_id = bc.category_id

            WHERE c.category_name LIKE '%11%'
            GROUP BY b.book_id
        """);

        System.out.println("reach here=================");
        List<BookDto> list = q.getResultList();

        return list;
    }

    @Transactional
    public ResponseEntity<Book> updateBook(Long bookID, BookRequest newBook) {
        Book book = bookRepository.findById(bookID).orElseThrow(() -> new EntityNotFoundException());

        Set<Integer> categorySet = newBook.getCategories();
        for(Integer categoryId: categorySet) {
            Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new EntityNotFoundException());
            book.getCategories().add(category);
        }

        if(newBook.getPublisherId() != null) {
            Publisher publisher = publisherRepository.getById(newBook.getPublisherId());
        }

        for(Integer authorId: newBook.getAuthors()) {
            Author author = authorRepository.getById(authorId);
            book.getAuthors().add(author);
        }

        if(newBook.getTitle() != null) {
            book.setTitle(newBook.getTitle());
        }

        if(newBook.getDescription() != null) {
            book.setDescription(newBook.getDescription());
        }

        if(newBook.getCode() != null) {
            book.setCode(newBook.getCode());
        }
        if(newBook.getSize() != null) {
            book.setSize(newBook.getSize());
        }
        if(newBook.getPrice() != null) {
            book.setPrice(newBook.getPrice());
        }

        if(newBook.getTotalPage() != null) {
            book.setTotalPage(newBook.getTotalPage());
        }


        return ResponseEntity.ok().body(bookRepository.save(book));

    }

//    private Book convertToEntity(BookDto bookDto) {
//            Book book = new Book()
//    }
}