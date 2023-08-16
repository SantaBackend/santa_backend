package com.likelion.santa.dto;

import com.likelion.santa.entity.Details;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetailsDto {

    private Long id;
    //등산로 명
    private String pmntn_nm;
    //등산로 주요 지점 내용
    private String pmntn_main;
    //등산로 길이
    private double xpmntn_lt;
    //등산로 상행 시간
    private Long pmntn_uppl;
    //등산로 하행 시간
    private Long pmntn_godn;
    //등산로 난이도 명
    private String pmntn_dffl;

    public DetailsDto(Details details){
        this.id = details.getId();
        this.pmntn_nm = details.getPmntn_nm();
        this.pmntn_main = details.getPmntn_main();
        this.xpmntn_lt = details.getXpmntn_lt();
        this.pmntn_uppl = details.getPmntn_uppl();
        this.pmntn_godn = details.getPmntn_godn();
        this.pmntn_dffl = details.getPmntn_dffl();
    }

    public Details toEntity(){
        Details details = Details.builder()
                .pmntn_nm(pmntn_nm)
                .pmntn_main(pmntn_main)
                .xpmntn_lt(xpmntn_lt)
                .pmntn_uppl(pmntn_uppl)
                .pmntn_godn(pmntn_godn)
                .pmntn_dffl(pmntn_dffl)
                .build();

        return details;
    }
}
