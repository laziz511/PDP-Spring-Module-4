package uz.pdp.online.pdp_online_module_4.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    private String name;
    private String catchPhrase;
    private String bs;

    public Company(Document document) {
        this.name = document.getString("name");
        this.catchPhrase = document.getString("catchPhrase");
        this.bs = document.getString("bs");
    }
}
