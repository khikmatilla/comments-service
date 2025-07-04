package uz.pdp.commentsservise.entitys;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.commentsservise.dto.CommentCreateDTO;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String message;
    private Integer postId;

    public Comment(CommentCreateDTO commentCreateDTO) {
        this.message = commentCreateDTO.getMessage();
        this.postId = commentCreateDTO.getPostId();
    }
}