package com.likelion.santa.service;

import com.likelion.santa.dto.BoardDto;
import com.likelion.santa.entity.Board;
import com.likelion.santa.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardService {

    @Autowired
    BoardRepository boardRepository;

    //게시물 작성
    @Transactional
    public BoardDto write(BoardDto boardDto){
        Board board = boardDto.toEntity();
        boardRepository.save(board);

        return boardDto;
    }

    //게시물 조회
    @Transactional(readOnly = true)
    public BoardDto getBoard(Long id){
        Board board = boardRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("Board Id를 찾을 수 없습니다.");
        });

        BoardDto boardDto = new BoardDto(board);

        return boardDto;
    }

    //게시물 수정
    @Transactional
    public Long update(BoardDto boardDto, Long id){
        Board board = boardRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("Board Id를 찾을 수 없습니다!");
        });

        board.update(
                boardDto.getPmntn_nm(),
                boardDto.getPmntn_main(),
                boardDto.getXpmntn_lt(),
                boardDto.getPmntn_dffl(),
                boardDto.getPmntn_uppl(),
                boardDto.getPmntn_godn(),
                boardDto.getHkngpntdscrt(),
                boardDto.getMntninfopoflc(),
                boardDto.getPbtrninfodscrt()
        );

        return board.getId();
    }

    //게시물 삭제
    @Transactional
    public void delete(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(() -> {
            throw new IllegalArgumentException("Board Id를 찾을 수 없습니다!");
        });

        boardRepository.delete(board);
    }
}