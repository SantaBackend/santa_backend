package com.likelion.santa.entity;

import javax.persistence.*;

@Entity
public class Details {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "details_id")
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

    //등산로 상행 시간
    @Column(nullable = false)
    private Long pmntn_uppl;

    //등산로 하행 시간
    @Column(nullable = false)
    private Long pmntn_godn;

    //등산로 난이도 명
    @Column(nullable = false)
    private String pmntn_dffl;
    
}
