package com.likelion.santa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reply")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_id")
    private Long id;

    @Column
    private String content;

    @Column
    private String username;

    @Column
    private Date regDate;

    @Column
    private Date modifiedDate;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Board board;


    public void update(String content){
        this.content = content;
        this.modifiedDate = new Date();
    }
}
