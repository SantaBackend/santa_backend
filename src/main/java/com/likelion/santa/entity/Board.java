package com.likelion.santa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "board")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    //등산로 명
    @Column
    private String pmtn_nm;

    //등산로 주요 지점 내용
    @Column
    private String pmntn_main;

    //등산로 길이
    @Column
    private Long xpmtn_lt;

    //등산로 난이도 명
    @Column
    private String pmntn_dffl;

    //등산로 상행 시간
    @Column
    private Long pmntn_uppl;

    //등산로 하행 시간
    @Column
    private Long pmntn_godn;

    //산행 포인트 설명(=등산로 상세구간 설명)
    @Column
    private String hkngpntdscrt;

    //산정보 소재지
    @Column
    private String mntninfopoflc;

    //대중교통정보 설명
    @Column
    private String pbtrninfodscrt;

    //산 이미지
    @Column
    private String mtnImgUrl;

    //등산로 이미지
    @Column
    private String hkImgUrl;

    //영속성
    public void update(String pmtn_nm, String pmntn_main, Long xpmtn_lt, String pmntn_dffl, Long pmntn_uppl, Long pmntn_godn, String hkngpntdscrt, String mntninfopoflc, String pbtrninfodscrt, String mtnImgUrl, String hkImgUrl) {
        this.pmtn_nm = pmtn_nm;
        this.pmntn_main = pmntn_main;
        this.xpmtn_lt = xpmtn_lt;
        this.pmntn_dffl = pmntn_dffl;
        this.pmntn_uppl = pmntn_uppl;
        this.pmntn_godn = pmntn_godn;
        this.hkngpntdscrt = hkngpntdscrt;
        this.mntninfopoflc = mntninfopoflc;
        this.pbtrninfodscrt = pbtrninfodscrt;
        this.mtnImgUrl = mtnImgUrl;
        this.hkImgUrl = hkImgUrl;
    }

}
