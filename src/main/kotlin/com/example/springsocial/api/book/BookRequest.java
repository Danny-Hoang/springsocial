package com.example.springsocial.api.book;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookRequest {
    private String title;
    private String description;
    private String code;
    private Integer price;
    private Integer size;
    private Integer publishYear;
    private Integer totalPage;
    private Integer publisherId;
    private Set<Integer> categories;
    private Set<Integer> authors;
}
