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
public class Geo {
    private String lat;
    private String lng;

    public Geo(Document geoDoc) {
        this.lat = geoDoc.getString("lat");
        this.lng = geoDoc.getString("lng");
    }
}
