package edu.sjsu.cmpe.cache.client;

public class Client {

    public static void main(String[] args) throws Exception {
        CRDTClient crdtClient = new CRDTClient();
        crdtClient.addCacheServer("http://localhost:3000");
        crdtClient.addCacheServer("http://localhost:3001");
        crdtClient.addCacheServer("http://localhost:3002");
        
        boolean responseStatus = crdtClient.put(1, "a");
        if(responseStatus) {
        	System.out.println("Put of 1 <=> a successful");
        } else {
        	System.out.println("Put of 1 <=> a unsuccessful");
        }
        Thread.sleep(30000);
        responseStatus = crdtClient.put(1, "b");
        if(responseStatus) {
        	System.out.println("Put of 1 <=> b successful");
        } else {
        	System.out.println("Put of 1 <=> b unsuccessful");
        }
        Thread.sleep(30000);
        String responseValue = crdtClient.get(1);
        System.out.println("Read successful with value:"+ responseValue);
    }
}