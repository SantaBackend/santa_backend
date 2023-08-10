package com.likelion.santa.dto;

import com.likelion.santa.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {

    private Long id;
    //등산로 명
    private String pmtn_nm;
    //등산로 주요 지점 내용
    private String pmntn_main;
    //등산로 길이
    private Long xpmtn_lt;
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
    private String mtnImgUrl;
    //등산로 이미지
    private String hkImgUrl;

    public Board toEntity(){
        Board board = Board.builder()
                .pmtn_nm(pmtn_nm)
                .pmntn_main(pmntn_main)
                .xpmtn_lt(xpmtn_lt)
                .pmntn_dffl(pmntn_dffl)
                .pmntn_godn(pmntn_godn)
                .hkngpntdscrt(hkngpntdscrt)
                .mntninfopoflc(mntninfopoflc)
                .pbtrninfodscrt(pbtrninfodscrt)
                .mtnImgUrl(mtnImgUrl)
                .hkImgUrl(hkImgUrl)
                .build();

        return board;
    }

    public BoardDto(Board board){
        this.id = board.getId();
        this.pmtn_nm = board.getPmtn_nm();
        this.xpmtn_lt = board.getXpmtn_lt();
        this.pmntn_dffl = board.getPmntn_dffl();
        this.pmntn_godn = board.getPmntn_godn();
        this.hkngpntdscrt = board.getHkngpntdscrt();
        this.mntninfopoflc = board.getMntninfopoflc();
        this.pbtrninfodscrt = board.getPbtrninfodscrt();
        this.mtnImgUrl = board.getMtnImgUrl();
        this.hkImgUrl = board.getHkImgUrl();
    }
}
