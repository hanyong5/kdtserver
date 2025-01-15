package com.ganseo.ganseo.jpa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {
    @Autowired
    BookService bookService;
    @Autowired
    private BookRepository bookRepository;

    @RequestMapping("/")
    @ResponseBody
    public String root(){
        return "Hello, this is plain text output!";
    }

    @RequestMapping("/all")
    @ResponseBody
    public List<Book> getAll(){
        List<Book> books = bookService.findAll();
        return books;
    }

    @GetMapping("/books")
    public Page<Book> getBooks(
            @RequestParam(defaultValue = "0") int page,  // 기본 페이지 번호: 0
            @RequestParam(defaultValue = "10") int size // 기본 페이지 크기: 10
    ) {
        Pageable pageable = PageRequest.of(page, size); // 페이지 정보 생성
        return bookRepository.findAll(pageable);        // 페이지네이션된 데이터 반환
    }

    @GetMapping("/books/search")
    public List<Book> searchBooksByKeyword(@RequestParam String keyword) {
        return bookRepository.findByKeyword(keyword);
    }

}
