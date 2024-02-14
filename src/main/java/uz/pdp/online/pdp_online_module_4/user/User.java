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
public class User {
    private int id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;

    public User(Document document) {
        this.id = document.getInteger("id");
        this.name = document.getString("name");
        this.username = document.getString("username");
        this.email = document.getString("email");

        Document addressDoc = (Document) document.get("address");
        if (addressDoc != null) {
            this.address = new Address(addressDoc);
        }

        this.phone = document.getString("phone");
        this.website = document.getString("website");

        Document companyDoc = (Document) document.get("company");
        if (companyDoc != null) {
            this.company = new Company(companyDoc);
        }
    }
}
