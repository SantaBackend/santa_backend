package com.likelion.santa.controller;

import com.likelion.santa.dto.ReplyRequest;
import com.likelion.santa.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reply/{board_id}")
public class ReplyController {

    @Autowired
    ReplyService replyService;

    @PostMapping("")
    public ResponseEntity<String> postRely(@PathVariable Long board_id, @RequestBody ReplyRequest request) {
        try {
            if (replyService.hasUserCommentedOnBoard(board_id, request.getUsername())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("이미 댓글을 작성하셨습니다!");
            }

            replyService.write(board_id, request);
            return ResponseEntity.ok("댓글 작성 성공");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{reply_id}")
    public ResponseEntity<String> deleteReply(@PathVariable Long board_id, @PathVariable Long reply_id){
        try {
            replyService.deleteReply(reply_id);
            return ResponseEntity.ok("댓글 삭제 성공");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PatchMapping("/{reply_id}")
    public ResponseEntity<String> updateReply(@PathVariable Long board_id, @RequestBody ReplyRequest request){
        try{
            replyService.updateReply(board_id, request);
            return ResponseEntity.ok("댓글 수정 성공");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}