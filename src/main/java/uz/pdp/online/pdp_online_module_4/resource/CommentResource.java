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
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import uz.pdp.online.pdp_online_module_4.dto.CommentCreateDTO;
import uz.pdp.online.pdp_online_module_4.dto.CommentDTO;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentResource {

    private final RestTemplate restTemplate;
    private final WebClient webClient;

    @Value("${comments.url.postComments}")
    private String postCommentsURL;

    @Value("${comments.url.saveComments}")
    private String saveCommentsURL;


    public List<CommentDTO> getAllComments(@NonNull Integer postID) {
        // return getCommentsWithRestTemplate(postID);
        return getCommentsWithWebClient(postID);
    }

    public void saveAll(List<CommentCreateDTO> commentCreateDTOS) {
        // saveCommentsWithRestTemplate(commentCreateDTOS);
        saveCommentsWithWebClient(commentCreateDTOS);
    }

    private List<CommentDTO> getCommentsWithWebClient(Integer postID) {
        return webClient
                .get()
                .uri(postCommentsURL, postID)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<CommentDTO>>() { })
                .block();
    }

    private List<CommentDTO> getCommentsWithRestTemplate(Integer postID) {
        try {
            return restTemplate.exchange(
                    postCommentsURL,
                    HttpMethod.GET,
                    HttpEntity.EMPTY,
                    new ParameterizedTypeReference<List<CommentDTO>>() {
                    },
                    postID).getBody();
        } catch (ResourceAccessException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    private void saveCommentsWithWebClient(List<CommentCreateDTO> commentCreateDTOS) {
        webClient.post()
                .uri(saveCommentsURL)
                .body(BodyInserters.fromValue(commentCreateDTOS))
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }

    private void saveCommentsWithRestTemplate(List<CommentCreateDTO> commentCreateDTOS) {
        HttpEntity<List<CommentCreateDTO>> httpEntity = new HttpEntity<>(commentCreateDTOS);
        restTemplate.exchange(saveCommentsURL, HttpMethod.POST, httpEntity, Void.class);
    }
}