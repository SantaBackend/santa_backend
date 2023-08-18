package com.likelion.santa.dto;

import com.likelion.santa.entity.Board;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDto {

    private Long id;

    private String hkngpntdscrt;
    //산정보 소재지
    private String mntninfopoflc;
    //대중교통정보 설명
    private String pbtrninfodscrt;
    //산코드
    private String mntnid;
    //산명
    private String mntnnm;
    //산 이미지
    private String mntnImageUrl;
    //등산로 이미지
    private String hkImageUrl;

    private List<DetailsDto> detailsDtoList;
    private List<ReplyResponse> replyList;

    public Board toEntity(){
        Board board = Board.builder()
                .hkngpntdscrt(hkngpntdscrt)
                .mntninfopoflc(mntninfopoflc)
                .pbtrninfodscrt(pbtrninfodscrt)
                .mntnid(mntnid)
                .mntnnm(mntnnm)
                .mntnImageUrl(mntnImageUrl)
                .hkImageUrl(hkImageUrl)
                .build();

        return board;
    }

    public BoardDto(Board board){
        this.id = board.getId();
        this.hkngpntdscrt = board.getHkngpntdscrt();
        this.mntninfopoflc = board.getMntninfopoflc();
        this.pbtrninfodscrt = board.getPbtrninfodscrt();
        this.mntnid = board.getMntnid();
        this.mntnnm =board.getMntnnm();
        this.mntnImageUrl = board.getMntnImageUrl();
        this.hkImageUrl = board.getHkImageUrl();
        this.detailsDtoList = board.getDetailsList().stream().map(DetailsDto::new).collect(Collectors.toList());
        this.replyList = board.getReplyList().stream().map(ReplyResponse::new).collect(Collectors.toList());
    }
}
