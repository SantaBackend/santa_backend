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
    @Column(nullable = false)
    private String pmntn_nm;

    //등산로 주요 지점 내용
    @Column(nullable = false)
    private String pmntn_main;

    //등산로 길이
    @Column(nullable = false)
    private double xpmntn_lt;

    //등산로 난이도 명
    @Column(nullable = false)
    private String pmntn_dffl;

    //등산로 상행 시간
    @Column(nullable = false)
    private Long pmntn_uppl;

    //등산로 하행 시간
    @Column(nullable = false)
    private Long pmntn_godn;

    //산행 포인트 설명(=등산로 상세구간 설명)
    @Column(nullable = false)
    private String hkngpntdscrt;

    //산정보 소재지
    @Column(nullable = false)
    private String mntninfopoflc;

    //대중교통정보 설명
    @Column(nullable = false)
    private String pbtrninfodscrt;

    //영속성
    public void update(String pmntn_nm, String pmntn_main, double xpmntn_lt, String pmntn_dffl, Long pmntn_uppl, Long pmntn_godn, String hkngpntdscrt, String mntninfopoflc, String pbtrninfodscrt) {
        this.pmntn_nm = pmntn_nm;
        this.pmntn_main = pmntn_main;
        this.xpmntn_lt = xpmntn_lt;
        this.pmntn_dffl = pmntn_dffl;
        this.pmntn_uppl = pmntn_uppl;
        this.pmntn_godn = pmntn_godn;
        this.hkngpntdscrt = hkngpntdscrt;
        this.mntninfopoflc = mntninfopoflc;
        this.pbtrninfodscrt = pbtrninfodscrt;
    }

}
