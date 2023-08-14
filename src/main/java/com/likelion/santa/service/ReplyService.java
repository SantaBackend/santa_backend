package com.likelion.santa.service;

import com.likelion.santa.dto.ReplyRequest;
import com.likelion.santa.dto.ReplyResponse;
import com.likelion.santa.entity.Board;
import com.likelion.santa.entity.Reply;
import com.likelion.santa.repository.BoardRepository;
import com.likelion.santa.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class ReplyService {

    @Autowired
    ReplyRepository replyRepository;
    @Autowired
    BoardRepository boardRepository;

    //댓글 작성
    @Transactional
    public Long write(Long board_id, ReplyRequest request){
        Board board = boardRepository.findById(board_id).orElseThrow(() -> {
            return new IllegalArgumentException("Board Id를 찾을 수 없습니다!");
        });

        Reply reply = request.toEntity();
        reply.setBoard(board);
        reply.setRegDate(new Date());
        reply.setModifiedDate(new Date());

        replyRepository.save(reply);

        return board_id;
    }

    //댓글 삭제
    @Transactional
    public String deleteReply(Long reply_id){
        Reply reply = replyRepository.findById(reply_id).orElseThrow(() -> {
            return new IllegalArgumentException("댓글 Id를 찾을 수 없습니다!");
        });

        replyRepository.deleteById(reply_id);

        return "삭제";
    }
    //댓글 수정
    @Transactional
    public Long updateReply(Long reply_id, ReplyRequest replyRequest){
        Reply reply = replyRepository.findById(reply_id).orElseThrow(() -> {
            return new IllegalArgumentException("댓글 Id를 찾을 수 없습니다!");
        });

        reply.update(replyRequest.getContent());

        return reply.getBoard().getId();
    }
}
