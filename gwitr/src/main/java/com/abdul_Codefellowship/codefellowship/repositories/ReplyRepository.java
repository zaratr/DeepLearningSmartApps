package com.abdul_Codefellowship.codefellowship.repositories;

import com.abdul_Codefellowship.codefellowship.model.Post;
import com.abdul_Codefellowship.codefellowship.model.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply,Long> {

    List<Reply> findAllByPost(Post post);
}
