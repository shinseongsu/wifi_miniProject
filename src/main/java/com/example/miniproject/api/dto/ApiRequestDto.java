package com.example.miniproject.api.dto;

import lombok.Getter;

@Getter
public class ApiRequestDto {
    private Integer currentPage;
    private Integer nextPage;

    // 초기화
    public ApiRequestDto() {
        this.currentPage = 1;
        this.nextPage = 1000;
    }

    public String currentPageToString() {
        return String.valueOf(currentPage);
    }

    public String nextPageToString() {
        return String.valueOf(nextPage);
    }

    // 다음 페이지
    public void nextPage() {
        this.currentPage += 1000;
        this.nextPage += 1000;
    }

}
