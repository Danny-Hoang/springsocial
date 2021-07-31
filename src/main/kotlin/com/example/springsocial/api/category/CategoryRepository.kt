package com.example.springsocial.api.category

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import javax.transaction.Transactional


@Repository
interface CategoryRepository : JpaRepository<Category, Int> { //    @Query(
    //            value = "SELECT * FROM categories WHERE categoryName LIKE %:title%",
    //            countQuery = "SELECT count(*) FROM books",
    //            nativeQuery = true)
    //    Page<Book> findByTitleLike(@RequestParam(defaultValue = "", required = false) String title, Pageable pageable);

//    @Transactional
//    @Modifying
//    @Query("DELETE FROM Category c WHERE c.id = :id")
//    fun remveCategory(@Param("id") id: Int)

}
