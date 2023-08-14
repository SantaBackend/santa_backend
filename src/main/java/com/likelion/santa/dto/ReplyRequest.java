package com.likelion.santa.dto;

import com.likelion.santa.entity.Reply;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReplyRequest {
    private Long id;
    private String content;
    private String username;
    private Date regDate;
    private Date modifiedDate;

    public Reply toEntity(){
        Reply reply = Reply.builder()
                .id(id)
                .content(content)
                .username(username)
                .regDate(regDate)
                .modifiedDate(modifiedDate)
                .build();
        return reply;
    }
}
