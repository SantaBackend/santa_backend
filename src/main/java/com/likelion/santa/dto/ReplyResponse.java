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
public class ReplyResponse {
    private Long id;
    private String content;
    private String username;
    private Date regDate;
    private Date modifiedDate;
    private Long boardId;

    public ReplyResponse(Reply reply){
        this.id = reply.getId();
        this.content = reply.getContent();
        this.username = reply.getUsername();
        this.regDate = reply.getRegDate();
        this.modifiedDate = reply.getModifiedDate();
        this.boardId = reply.getBoard().getId();
    }
}