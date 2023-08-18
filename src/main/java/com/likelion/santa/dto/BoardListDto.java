package com.likelion.santa.dto;

import com.likelion.santa.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardListDto {
    private Long id;
    private String mntnnm;

    public BoardListDto(Board board){
        this.id = board.getId();
        this.mntnnm = board.getMntnnm();
    }

    public static List<BoardListDto> fromBoardList(List<Board> boardList) {
        return boardList.stream()
                .map(BoardListDto::new)
                .collect(Collectors.toList());
    }
}
