package uz.pdp.online.pdp_online_module_4.student;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Document("group")
public class Group {
    public String id;
    public String name;
}
