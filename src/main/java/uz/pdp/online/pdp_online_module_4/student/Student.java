package uz.pdp.online.pdp_online_module_4.student;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Document("student")
public class Student {
    @Id
    private String id;
    private String name;
    private Integer age;
    private LocalDate birthDate;
    private Gender gender;
}

enum Gender {
    MALE, FEMALE
}
