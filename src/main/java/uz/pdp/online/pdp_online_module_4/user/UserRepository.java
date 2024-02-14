package uz.pdp.online.pdp_online_module_4.user;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserRepository {
    private static final MongoClient CLIENT = MongoClients.create("mongodb://@localhost:27017/pdp_spring");
    private static final MongoDatabase DB = CLIENT.getDatabase("pdp_spring");
    private static final MongoCollection<Document> COLLECTION = DB.getCollection("user");



    public void save(User user) {

        Document document = new Document(Map.of(
                "name", user.getName(),
                "age", user.getPhone(),
                "email", user.getEmail(),
                "address", new Document(Map.of(

                        "street", user.getAddress().getStreet(),
                        "suite", user.getAddress().getSuite(),
                        "city", user.getAddress().getCity(),
                        "zipcode", user.getAddress().getZipcode(),
                        "geo", new Document(Map.of(
                                "lat", user.getAddress().getGeo().getLat(),
                                "lng", user.getAddress().getGeo().getLng()
                        ))
                )),
                "company", new Document(Map.of(
                        "name", user.getCompany().getName(),
                        "catchPhrase", user.getCompany().getCatchPhrase(),
                        "bs", user.getCompany().getBs()
                ))

        ));
        COLLECTION.insertOne(document);
    }

    public boolean delete(String id) {
        Bson filter = Filters.eq("_id", new ObjectId(id));
        return COLLECTION.deleteOne(filter).wasAcknowledged();
    }

    public User get(String id) {
        Bson filter = Filters.eq("_id", new ObjectId(id));
        Document document = COLLECTION.find(filter).first();
        if (document == null)
            return null;
        return new User(document);
    }

    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        for (Document document : COLLECTION.find()) {
            users.add(new User(document));
        }
        return users;
    }

    public boolean update(User user) {
        Bson filter = Filters.eq("_id", user.getId());
        Bson update = Updates.combine(
                Updates.set("name", user.getName()),
                Updates.set("age", user.getPhone()),
                Updates.set("email", user.getEmail()),
                Updates.set("address", new Document(Map.of(
                        "street", user.getAddress().getStreet(),
                        "suite", user.getAddress().getSuite(),
                        "city", user.getAddress().getCity(),
                        "zipcode", user.getAddress().getZipcode(),
                        "geo", new Document(Map.of(
                                "lat", user.getAddress().getGeo().getLat(),
                                "lng", user.getAddress().getGeo().getLng()
                        )),
                        "company", new Document(Map.of(
                                "name", user.getCompany().getName(),
                                "catchPhrase", user.getCompany().getCatchPhrase(),
                                "bs", user.getCompany().getBs())
                        ))
                )));
        return COLLECTION.updateOne(filter, update).wasAcknowledged();
    }

}
