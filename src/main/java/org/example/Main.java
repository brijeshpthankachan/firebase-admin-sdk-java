package org.example;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutionException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {


        Scanner scanner = new Scanner(System.in);

        FileInputStream serviceAccount =
                new FileInputStream("D:\\Downloads\\fbase-e0c3a-firebase-adminsdk-gzan0-35fd98ba3f.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        FirebaseApp.initializeApp(options);

        Firestore db = FirestoreClient.getFirestore();

        // Create a Map to store the data we want to set
        Map<String, Object> docData = new HashMap<>();
        docData.put("name", "Los Angeles");
        docData.put("state", "CA");
        docData.put("country", "USA");
        docData.put("regions", Arrays.asList("west_coast", "socal"));

// Add a new document (asynchronously) in collection "cities" with id "LA"
        ApiFuture<WriteResult> future = db.collection("cities").document("LA").set(docData);

// future.get() blocks on response
        System.out.println("Update time : " + future.get().getUpdateTime());


        // asynchronously update doc, create the document if missing
        Map<String, Object> update = new HashMap<>();
        update.put("capital", true);

        ApiFuture<WriteResult> writeResult =
                db.collection("cities").document("LA").set(update, SetOptions.merge());

        System.out.println("Update time : " + writeResult.get().getUpdateTime());

        // asynchronously update doc, create the document if missing
        Map<String, Object> update1 = new HashMap<>();
        update1.put("population", 100000050);

        ApiFuture<WriteResult> writeResult1 =
                db.collection("cities").document("LA").set(update1,SetOptions.merge());

        System.out.println("Update time : " + writeResult1.get().getUpdateTime());

        // asynchronously update doc, create the document if missing
        Map<String, Object> update2 = new HashMap<>();
        update2.put("president", "donald trump");

        ApiFuture<WriteResult> writeResult2 =
                db.collection("cities").document("LA").set(update2,SetOptions.merge());

        System.out.println("Update time : " + writeResult2.get().getUpdateTime());

        while (true) {
            System.out.println("Enter a character (y to exit):");
            char input = scanner.nextLine().charAt(0);

            if (input == 'y') {
                break;
            }
        }

    }
}