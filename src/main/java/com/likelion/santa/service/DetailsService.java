package com.likelion.santa.service;

import com.likelion.santa.dto.DetailsDto;
import com.likelion.santa.entity.Board;
import com.likelion.santa.entity.Details;
import com.likelion.santa.repository.BoardRepository;
import com.likelion.santa.repository.DetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DetailsService {

    @Autowired
    DetailsRepository detailsRepository;

    @Autowired
    BoardRepository boardRepository;

    @Transactional
    public Long write(Long board_id, DetailsDto detailsDto){
        Board board = boardRepository.findById(board_id).orElseThrow(() -> {
            throw new IllegalArgumentException("Board Id를 찾을 수 없습니다!");
        });

        Details details = detailsDto.toEntity();
        details.setBoard(board);

        detailsRepository.save(details);

        return board.getId();
    }

    @Transactional
    public String deleteDetails(Long details_id){
        Details details = detailsRepository.findById(details_id).orElseThrow(() -> {
            return new IllegalArgumentException("상세정보 Id를 찾을 수 없습니다!");
        });

        detailsRepository.deleteById(details_id);

        return "삭제";
    }

    @Transactional
    public Long updateDetails(Long details_id, DetailsDto detailsDto){
        Details details = detailsRepository.findById(details_id).orElseThrow(() -> {
            return new IllegalArgumentException("상세정보 Id를 찾을 수 없습니다!");
        });

        details.update(detailsDto);

        return details.getBoard().getId();
    }
}
