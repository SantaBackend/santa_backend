package com.likelion.santa.repository;

import com.likelion.santa.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
    boolean existsByBoard_IdAndUsername(Long boardId, String username);
}
