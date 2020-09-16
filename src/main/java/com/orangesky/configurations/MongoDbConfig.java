package com.orangesky.configurations;

/**
 * @author RaminderSingh
 *
mongoHost : localhost
mongoPort : 27017
mongoDB : local
collectionName: products


 */


public class MongoDbConfig {

    private String mongoHost;
    private int mongoPort;
    private String mongoDB;
    private String collectionName;

    public MongoDbConfig() {
    }

    public String getMongoHost() {
        return mongoHost;
    }

    public void setMongoHost(String mongoHost) {
        this.mongoHost = mongoHost;
    }

    public int getMongoPort() {
        return mongoPort;
    }

    public void setMongoPort(int mongoPort) {
        this.mongoPort = mongoPort;
    }

    public String getMongoDB() {
        return mongoDB;
    }

    public void setMongoDB(String mongoDB) {
        this.mongoDB = mongoDB;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }
}
