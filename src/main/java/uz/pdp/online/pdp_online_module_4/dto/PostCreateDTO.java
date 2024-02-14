package uz.pdp.online.pdp_online_module_4.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostCreateDTO implements Serializable {
    private String title;
    private String body;
}
