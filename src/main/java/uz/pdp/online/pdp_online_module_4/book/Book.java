package uz.pdp.online.pdp_online_module_4.book;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("books")
public class Book {
    @Id
    private String id;
    private String name;
    private String author;
}