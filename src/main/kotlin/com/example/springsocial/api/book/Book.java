package com.example.springsocial.api.book;

import com.example.springsocial.api.author.Author;
import com.example.springsocial.api.category.Category;
import com.example.springsocial.api.publisher.Publisher;
import com.example.springsocial.model.audit.UserDateAudit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book extends UserDateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String code;
    private String description;
    private Integer price;
    private Integer size;
    private Integer totalPage;
    private Integer publishYear;

    @ManyToOne
    private Publisher publisher;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "book_category",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories;

    @ManyToMany
    private Set<Author> authors;

    public String getTitle() {
        return this.title;
    }
    public String getCode() {
        return this.code;
    }
    public String getDescription() {
        return this.description;
    }
    public Integer getSize() {
        return this.size;
    }

    public Integer getPrice() {
        return this.price;
    }

    public Integer getTotalPage() {
        return this.totalPage;
    }

    public void addCategory(Category category) {
        this.categories.add(category);
    }

    public void addAuthor(Author author) {
        this.authors.add(author);
    }

    public  Integer getPublishYear() {
        return this.publishYear;
    }
}
