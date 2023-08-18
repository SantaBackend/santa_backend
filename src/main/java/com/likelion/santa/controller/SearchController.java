package com.likelion.santa.controller;

import com.likelion.santa.dto.BaseResponse;
import com.likelion.santa.dto.BoardDto;
import com.likelion.santa.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {
    private final SearchService searchService;

    @Autowired
    public SearchController(SearchService searchService){
        this.searchService = searchService;
    }
    @GetMapping("/search")
    public BaseResponse<List<BoardDto>> search(@RequestParam("mntnnm") String keyword){
        List<BoardDto> searchList = searchService.search(keyword);
        return new BaseResponse<>(searchList);
    }
}