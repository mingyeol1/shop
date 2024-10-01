package com.example.shop.comment;

import com.example.shop.Member.CustomUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;


    public void register(Comment comment, Authentication auth){

        CustomUser user = (CustomUser) auth.getPrincipal();
        comment.setUsername(user.getUsername());
        commentRepository.save(comment);

    }

    public List<Comment> list(Long parentId){
        return commentRepository.findAllByParentId(parentId);
    }
}
