package com.bia.mongodbdemo;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.Mongo;
import java.net.UnknownHostException;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App {

    static MongoOperations mongoOps;

    public static void main(String[] args) throws UnknownHostException {

        mongoOps = new MongoTemplate(new Mongo(), "database");

        //mongoOps.insert(new Person("Joe", 34));

        //Person p = mongoOps.findOne(new Query(where("name").is("Joe")), Person.class);

        int max = 50;
        
        System.out.println(mongoOps.count(new Query(where("name").is("Joe")), Person.class));

//        runSet(0, 50);
//        runSet(0, 100);
//        runSet(0, 200);
//        runSet(0, 500);
//        runSet(0, 1000);
//        runSet(0, 10000);
//        runSet(0, 20000);
//        runSet(0, 50000);
//        runSet(0, 100000);
//        runSet(0, 200000);
//        runSet(0, 500000);
//        runSet(0, 1000000);
        
//        runGet(100, 50);
//        runGet(1000, 100);
//        runGet(2000, 200);
//        runGet(3000, 500);
//        runGet(4000, 1000);
//          runSet(0, 200000);
//          runSet(0, 2000000);
//          runSet(0, 2000000);
//          runSet(0, 2000000);
//          runSet(0, 2000000);

        System.out.println(mongoOps.getCollectionNames());

        mongoOps.dropCollection("myPojo");
    }

    public static void runSet(Integer i, int max) {
        max += i;
        long st = (new Date().getTime());
        for (; i < max; i++) {
            Person p = new Person("Joe", 34);
            mongoOps.insert(p);
        }
        long et = (new Date().getTime());

        System.out.println("inserts : " + max + " time: " + (et - st));
    }

    public static void runGet(Integer i, int max) {
        max += i;
        long st = (new Date().getTime());
        for (; i < max; i++) {
            mongoOps.findOne(new Query(where("name").is("Joe" + i)), Person.class);
        }
        long et = (new Date().getTime());

        System.out.println("get : " + max + " time: " + (et - st)/1000);
    }
}
