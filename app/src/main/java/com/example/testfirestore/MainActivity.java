package com.example.testfirestore;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private Button btnAdd, btnShow;
    private TextView tvShow;
    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd= findViewById(R.id.btnAdd);
        btnShow = findViewById(R.id.btnShow);
        tvShow = findViewById(R.id.tvShow);
        List<String> testList = new ArrayList<>();

        db = FirebaseFirestore.getInstance();
        final CollectionReference addReference = db.collection("Test");

        testList.add("Url1");
        testList.add("Url2");
        testList.add("Url3");

        TestObj testObj = new TestObj(6,10,"hai",testList);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String,Object> item = new HashMap<>();
                item.put("id",testObj.getId());
                item.put("number",testObj.getNumber());
                item.put("name",testObj.getName());
                item.put("listUrl",testObj.getListUrl());
                addReference.add(item).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(MainActivity.this,"Succes",Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this,"False",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addReference.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            QuerySnapshot snapshots = task.getResult();
                            List<TestObj> testObjList = new ArrayList<>();
                            for (QueryDocumentSnapshot doc : snapshots){
                                TestObj testObj1 = doc.toObject(TestObj.class);
                                testObjList.add(testObj1);
                            }
                            tvShow.setText(testObjList.get(0).toString());
                        }
                    }
                });
            }
        });
    }
}