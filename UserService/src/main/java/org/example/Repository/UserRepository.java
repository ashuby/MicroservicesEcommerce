package org.example.Repository;

import org.bson.types.ObjectId;
import org.example.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {
    @Query("{email: \"?0\"}")
    User getUserByUserName(String userName);
}
