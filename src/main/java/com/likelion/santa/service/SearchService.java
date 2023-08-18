package com.likelion.santa.service;

import com.likelion.santa.dto.BoardDto;
import com.likelion.santa.entity.Board;
import com.likelion.santa.repository.BoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SearchService {
    private final BoardRepository boardRepository;

    @Transactional
    public List<BoardDto> search(String keyword){
        List<Board> boardList = boardRepository.findByMntnnm(keyword);

        List<BoardDto> boardDtoList = boardList.stream()
                .map(board -> {
                    BoardDto mountainDto = board.toDto();

                    return mountainDto;
                })
                .collect(Collectors.toList());

        return boardDtoList;
    }
}