package uz.pdp.online.pdp_online_module_4.student;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {
    private final MongoTemplate mongoTemplate;

    public StudentRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public Student save(Student student) {
        return mongoTemplate.save(student);
    }

    public Student findById(String id) {
        return mongoTemplate.findById(id, Student.class);
    }

    public Student findByName(String name) {
        return mongoTemplate.findOne(Query.query(Criteria.where("name").is(name)), Student.class);
    }

    public void delete(String id) {
        mongoTemplate.remove(Query.query(Criteria.where("id").is(id)), Student.class);

    }

    public boolean update(Student student) {
//        Criteria criteria = Criteria.where("_id").is(student.getId());
//        Query query = new Query(criteria);
//        Update update = new Update();
//        update.set("name", student.getName());
//        update.set("age", student.getAge());
//        update.set("birthDate", student.getBirthDate());
//        update.set("gender", student.getGender());
//
//        UpdateResult updateResult = mongoTemplate.updateFirst(query, update, Student.class);
//        return updateResult.wasAcknowledged();
        return true;
    }


    public List<Student> searchByGroupId(String groupId) {
        return mongoTemplate.find(Query.query(Criteria.where("groupId").is(groupId)), Student.class);
    }


    public List<Student> findByAge(int age) {
        return mongoTemplate.find(Query.query(Criteria.where("age").is(age)), Student.class);
    }

    public List<Student> findAll() {
        return mongoTemplate.findAll(Student.class);
    }
}

