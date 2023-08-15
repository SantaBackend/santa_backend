package com.likelion.santa.entity;

import com.likelion.santa.dto.BoardDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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


    //산행 포인트 설명(=등산로 상세구간 설명)
    @Column(nullable = false)
    private String hkngpntdscrt;

    //산정보 소재지
    @Column(nullable = false)
    private String mntninfopoflc;

    //대중교통정보 설명
    @Column(nullable = false)
    private String pbtrninfodscrt;

    //산코드
    @Column(nullable = false)
    private String mntnid;

    //산명
    @Column(nullable = false)
    private String mntnnm;

    //산 이미지
    @Column
    private String mntnImageUrl;

    //등산로 이미지
    @Column String hkImageUrl;

    public void update(BoardDto boardDto){
        this.pmntn_nm = boardDto.getPmntn_nm();
        this.pmntn_main = boardDto.getPmntn_main();
        this.xpmntn_lt = boardDto.getXpmntn_lt();
        this.pmntn_dffl = boardDto.getPmntn_dffl();
        this.pmntn_uppl = boardDto.getPmntn_uppl();
        this.pmntn_godn = boardDto.getPmntn_godn();
        this.hkngpntdscrt = boardDto.getHkngpntdscrt();
        this.mntninfopoflc = boardDto.getMntninfopoflc();
        this.pbtrninfodscrt = boardDto.getPbtrninfodscrt();
        this.mntnnm = boardDto.getMntnnm();
        this.mntnid = boardDto.getMntnid();
        this.mntnImageUrl = boardDto.getMntnImageUrl();
        this.hkImageUrl = boardDto.getHkImageUrl();
    }

    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @OrderBy("id asc") //댓글 정렬
    private List<Reply> replyList;
}
