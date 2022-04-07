import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import static com.mongodb.client.model.Aggregates.group;

public class Main {

    public static void main(String[] args) {

        String uri = "mongodb://root:root@localhost:27017/?authSource=admin&readPreference=primary&appname=MongoDB%20Compass&directConnection=true&ssl=false";
        MongoClient mongoClient = MongoClients.create(uri);

        MongoDatabase mongoDatabase = mongoClient.getDatabase("vakinha");

        MongoCollection<Document> donate = mongoDatabase.getCollection("donate");

        Document newDonate = new Document("ID_DONATE", 1)
                .append("ID_REQUEST", 1)
                .append("DONATOR_NAME", "Ana")
                .append("DONATOR_EMAIL", Arrays.asList("ana@gmail.com", "aninha@gmail.com", "anagocthel@gmail.com"))
                .append("DONATE_VALUE",500)
                .append("DONATE_DESCRIPTION", "Boa sorte");
        donate.insertOne(newDonate);
        System.out.println(newDonate);


        ArrayList<Document> newArrayDonates = new ArrayList<Document>();

        newDonate = new Document("ID_DONATE", 2)
                .append("ID_REQUEST", 1)
                .append("DONATOR_NAME", "Ana")
                .append("DONATOR_EMAIL", Arrays.asList("ana@gmail.com", "aninha@gmail.com", "anagocthel@gmail.com"))
                .append("DONATE_VALUE",1000)
                .append("DONATE_DESCRIPTION", "Boa sorte");
        newArrayDonates.add(newDonate);

        newDonate = new Document("ID_DONATE", 3)
                .append("ID_REQUEST", 2)
                .append("DONATOR_NAME", "Rafael")
                .append("DONATOR_EMAIL", Arrays.asList("rafa@gmail.com", "rafael@gmail.com"))
                .append("DONATE_VALUE",600)
                .append("DONATE_DESCRIPTION", null);
        newArrayDonates.add(newDonate);

        donate.insertMany(newArrayDonates);
        System.out.println(newArrayDonates);


        System.out.println(donate.updateOne(Filters.eq("DONATE_VALUE", 600), new Document("$set", new Document("DONATE_VALUE" , 1000))));
        System.out.println( donate.updateMany(Filters.eq("DONATOR_EMAIL", "ana@gmail.com"), new Document("$set", new Document( "ID_REQUEST",2 ))));

        Document findDonate = donate.find(new Document("DONATOR_NAME" , "Ana")).first();
        System.out.println(findDonate);

        FindIterable<Document> iterobj
                = donate.find();

        Iterator itr = iterobj.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        System.out.println(donate.deleteOne(Filters.eq("DONATE_DESCRIPTION" , null)));
        System.out.println(donate.deleteMany(Filters.eq("ID_REQUEST", 2)));

}}
