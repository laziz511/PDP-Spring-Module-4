package uz.pdp.online.pdp_online_module_4.post;

import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Document("posts")
public class Post {
    @Id
    private String postId;

    @Field("post_title")
    /*@Indexed(name = "post_title_unique_index",
            unique = true,
            sparse = true)*/
    private String title;

    @Field("post_body")
    private String body;

    private Integer userId;

    private Integer id;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @CreatedBy
    private Long createdBy;

    @LastModifiedBy
    private Long updatedBy;
}
