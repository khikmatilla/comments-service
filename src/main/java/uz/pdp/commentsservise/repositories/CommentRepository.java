package uz.pdp.commentsservise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.pdp.commentsservise.entitys.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    @Query("select c from Comment c where c.postId = :postId")
    List<Comment> findAllByPostId(@Param("postId") Integer postId);
}