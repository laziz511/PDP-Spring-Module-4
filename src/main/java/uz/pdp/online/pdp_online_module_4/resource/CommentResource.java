package uz.pdp.online.pdp_online_module_4.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import uz.pdp.online.pdp_online_module_4.dto.CommentCreateDTO;
import uz.pdp.online.pdp_online_module_4.dto.CommentDTO;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentResource {

    private final RestTemplate restTemplate;

    @Value("${comments.url.postComments}")
    private String postCommentsURL;

    @Value("${comments.url.saveComments}")
    private String saveCommentsURL;


    public List<CommentDTO> getAllComments(@NonNull Integer postID) {
        // ResponseEntity<List> responseEntity = restTemplate.getForEntity(url, List.class, post.getId());
        // List comments = responseEntity.getBody();
        // List comments = restTemplate.getForObject(url, List.class, post.getId());
        // HttpHeaders headers = new HttpHeaders();
        // headers.add("Authorization", "Bearer token................");
        // headers.setBearerAuth("token");
        // headers.setBasicAuth("username","123");
        // headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
        // HttpEntity<Object> httpEntity = new HttpEntity<>(new Object(), headers);
        try {
            return restTemplate.exchange(
                    postCommentsURL,
                    HttpMethod.GET,
                    HttpEntity.EMPTY,
                    new ParameterizedTypeReference<List<CommentDTO>>() {},
                    postID).getBody();
        } catch (ResourceAccessException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public void saveAll(List<CommentCreateDTO> commentCreateDTOS) {
        HttpEntity<List<CommentCreateDTO>> httpEntity = new HttpEntity<>(commentCreateDTOS);
        restTemplate.exchange(saveCommentsURL, HttpMethod.POST, httpEntity, Void.class);
    }
}