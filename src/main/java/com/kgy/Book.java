package com.kgy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private Long id; // 각 독서 기록을 구분하는 번호입니다.
    private String title; // 책 제목입니다.
    private String comment; // 책에 남길 한 줄 기록입니다.
}