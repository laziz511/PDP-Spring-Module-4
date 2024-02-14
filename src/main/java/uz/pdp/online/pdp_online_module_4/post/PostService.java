package uz.pdp.online.pdp_online_module_4.post;

import org.springframework.lang.NonNull;
import uz.pdp.online.pdp_online_module_4.dto.CommentCreateDTO;
import uz.pdp.online.pdp_online_module_4.dto.PostCreateDTO;
import uz.pdp.online.pdp_online_module_4.dto.PostDTO;

import java.util.List;

public interface PostService {
    PostDTO getPost(@NonNull Integer id);

    PostDTO createPost(@NonNull PostCreateDTO dto);

    void createComment(@NonNull List<CommentCreateDTO> dtos);
}