package com.likelion.santa.controller;

import com.likelion.santa.dto.BoardDto;
import com.likelion.santa.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    //게시물 작성
    @PostMapping("/post")
    public ResponseEntity<String> writeBoard(@RequestBody BoardDto boardDto) {
        boardService.write(boardDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("게시물이 작성되었습니다.");
    }

    //게시물 조회
    @GetMapping("/{id}")
    public ResponseEntity<BoardDto> getBoard(@PathVariable Long id) {
        BoardDto boardDto = boardService.getBoard(id);
        return ResponseEntity.status(HttpStatus.OK).body(boardDto);
    }

    //게시물 수정
    @PutMapping("/{id}")
    public ResponseEntity<String> updateBoard(@RequestBody BoardDto boardDto, @PathVariable Long id) {
        boardService.update(boardDto, id);
        return ResponseEntity.status(HttpStatus.OK).body("게시물이 수정되었습니다.");
    }

    //게시물 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBoard(@PathVariable Long id) {
        boardService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("게시물이 삭제되었습니다.");
    }

}
