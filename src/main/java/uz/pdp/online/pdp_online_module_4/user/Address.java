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
public class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;

    public Address(Document document) {
        this.street = document.getString("street");
        this.suite = document.getString("suite");
        this.city = document.getString("city");
        this.zipcode = document.getString("zipcode");

        Document geoDoc = (Document) document.get("geo");
        if (geoDoc != null) {
            this.geo = new Geo(geoDoc);
        }
    }
}
