package com.travel.travelapp.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.travel.travelapp.model.UserDetails;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class UserDetailService {
    public UserDetails get(String id) {

        Firestore db = FirestoreClient.getFirestore();
        DocumentReference ref = db.collection("user_details").document(id);
        ApiFuture<DocumentSnapshot> future = ref.get();
        DocumentSnapshot doc = null;
        try {
            doc = future.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        UserDetails details;
        if (doc.exists()) {
            details = doc.toObject(UserDetails.class);
            return details;
        }
        return null;
    }


    public String create(UserDetails details) {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collection = db.collection("user_details").document(
                details.getId()).set(details);
        try {
            return collection.get().getUpdateTime().toString();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
