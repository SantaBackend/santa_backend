package com.likelion.santa.entity;

import com.likelion.santa.dto.DetailsDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Board board;

    public void update(DetailsDto detailsDto){
        this.pmntn_nm = detailsDto.getPmntn_nm();
        this.pmntn_main = detailsDto.getPmntn_main();
        this.xpmntn_lt = detailsDto.getXpmntn_lt();
        this.pmntn_uppl = detailsDto.getPmntn_uppl();
        this.pmntn_godn = detailsDto.getPmntn_godn();
        this.pmntn_dffl = detailsDto.getPmntn_dffl();
    }

}
