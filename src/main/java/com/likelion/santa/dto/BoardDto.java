package com.likelion.santa.dto;

import com.likelion.santa.entity.Board;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {

    private Long id;
    //등산로 명
    private String pmntn_nm;
    //등산로 주요 지점 내용
    private String pmntn_main;
    //등산로 길이
    private double xpmntn_lt;
    //등산로 난이도 명
    private String pmntn_dffl;
    //등산로 상행 시간
    private Long pmntn_uppl;
    //등산로 하행 시간
    private Long pmntn_godn;
    //산행 포인트 설명(=등산로 상세구간 설명)
    private String hkngpntdscrt;
    //산정보 소재지
    private String mntninfopoflc;
    //대중교통정보 설명
    private String pbtrninfodscrt;
    //산 이미지
    private String mntnImageUrl;
    //등산로 이미지
    private String hkImageUrl;

    private List<ReplyResponse> replyList;

    public Board toEntity(){
        Board board = Board.builder()
                .pmntn_nm(pmntn_nm)
                .pmntn_main(pmntn_main)
                .xpmntn_lt(xpmntn_lt)
                .pmntn_dffl(pmntn_dffl)
                .pmntn_uppl(pmntn_uppl)
                .pmntn_godn(pmntn_godn)
                .hkngpntdscrt(hkngpntdscrt)
                .mntninfopoflc(mntninfopoflc)
                .pbtrninfodscrt(pbtrninfodscrt)
                .mntnImageUrl(mntnImageUrl)
                .hkImageUrl(hkImageUrl)
                .build();

        return board;
    }

    public BoardDto(Board board){
        this.id = board.getId();
        this.pmntn_nm = board.getPmntn_nm();
        this.pmntn_main = board.getPmntn_main();
        this.xpmntn_lt = board.getXpmntn_lt();
        this.pmntn_dffl = board.getPmntn_dffl();
        this.pmntn_uppl = board.getPmntn_uppl();
        this.pmntn_godn = board.getPmntn_godn();
        this.hkngpntdscrt = board.getHkngpntdscrt();
        this.mntninfopoflc = board.getMntninfopoflc();
        this.pbtrninfodscrt = board.getPbtrninfodscrt();
        this.mntnImageUrl = board.getMntnImageUrl();
        this.hkImageUrl = board.getHkImageUrl();
        this.replyList = board.getReplyList().stream().map(ReplyResponse::new).collect(Collectors.toList());
    }
}
