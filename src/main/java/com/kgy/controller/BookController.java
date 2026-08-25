package com.kgy.controller;

import com.kgy.Book;
import com.kgy.request.BookRequestDto;
import com.kgy.response.BookResponseDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class BookController {
    private final Map<Long, Book> bookList = new HashMap<>(); // 독서 기록 번호를 key로, Book 객체를 value로 저장합니다.
    private Long nextId = 1L; // 새 독서 기록에 자동으로 부여할 다음 번호입니다.


    @PostMapping("/books")
    public BookResponseDto RegisterBook(@RequestBody BookRequestDto requestDto){
        Book book = new Book(nextId,requestDto.getTitle(),requestDto.getComment());
        nextId++;
        bookList.put(book.getId(), book);
        BookResponseDto responseDto = new BookResponseDto(book.getId(),book.getTitle(),book.getComment());
        return responseDto;
    }

    @GetMapping("/books")
    public List<BookResponseDto> CheckAllBook(){
        List<BookResponseDto> responseDtoList = new ArrayList<BookResponseDto>();
        for (Book book : bookList.values()) {
            BookResponseDto responseDto = new BookResponseDto(book.getId(),book.getTitle(),book.getComment());
            responseDtoList.add(responseDto);
        }

        return responseDtoList;
    }
}
