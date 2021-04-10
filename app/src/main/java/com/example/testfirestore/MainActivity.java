package com.example.testfirestore;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.testfirestore.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    FirebaseFirestore db;

    ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        List<String> testList = new ArrayList<>();

        db = FirebaseFirestore.getInstance();
        final CollectionReference addReference = db.collection("Test");

//        testList.add("Url1");
//        testList.add("Url2");
//        testList.add("Url3");

//        TestObj testObj = new TestObj(6,10,"hai",testList);

        mainBinding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(mainBinding.etId.getText().toString());
                int priceDontSale = Integer.parseInt(mainBinding.etPriceDontSale.getText().toString());
                int priceSale = Integer.parseInt(mainBinding.etPriceSale.getText().toString());
                int salePercent = Integer.parseInt(mainBinding.etSalePercent.getText().toString());
                int totalItem = Integer.parseInt(mainBinding.etTotal.getText().toString());
                int totalItemSold = Integer.parseInt(mainBinding.etTotalSold.getText().toString());
                int itemSoldInMonth = Integer.parseInt(mainBinding.etitemSoldInMonth.getText().toString());
                int idUserSell = Integer.parseInt(mainBinding.etidUserSell.getText().toString());
                String codeMaidCate = mainBinding.etCodeMain.getText().toString();
                String CodeSideCateId = mainBinding.etCodeSide.getText().toString();
                String nameItemSell = mainBinding.etName.getText().toString();
                String tradeMark = mainBinding.ettradeMark.getText().toString();
                String characteristics = mainBinding.etcharacteristics.getText().toString();
                String EventCode = mainBinding.eteventCode.getText().toString();
                String sale = mainBinding.etSale.getText().toString();
                String DaySell = mainBinding.etdaySell.getText().toString();
                List<String> avatarItem = new ArrayList<>();
                if (mainBinding.etUrl1.getText().toString().trim().isEmpty() == false || mainBinding.etUrl1.getText().toString() != null) {
                    avatarItem.add(mainBinding.etUrl1.getText().toString());
                }
                if (mainBinding.etUrl2.getText().toString().trim().isEmpty() == false || mainBinding.etUrl2.getText().toString() != null) {
                    avatarItem.add(mainBinding.etUrl2.getText().toString());
                }
                if (mainBinding.etUrl3.getText().toString().trim().isEmpty() == false || mainBinding.etUrl3.getText().toString() != null) {
                    avatarItem.add(mainBinding.etUrl3.getText().toString());
                }
                if (mainBinding.etUrl4.getText().toString().trim().isEmpty() == false || mainBinding.etUrl4.getText().toString() != null) {
                    avatarItem.add(mainBinding.etUrl4.getText().toString());
                }

                ItemSell itemSell = new ItemSell(id, codeMaidCate, CodeSideCateId, nameItemSell, sale, salePercent, priceDontSale, priceSale, totalItem,
                        totalItemSold, itemSoldInMonth, idUserSell, tradeMark, characteristics, EventCode, DaySell, avatarItem);
                addItem(itemSell, addReference);
            }
        });

//        btnShow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                addReference.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                        if (task.isSuccessful()){
//                            QuerySnapshot snapshots = task.getResult();
//                            List<TestObj> testObjList = new ArrayList<>();
//                            for (QueryDocumentSnapshot doc : snapshots){
//                                TestObj testObj1 = doc.toObject(TestObj.class);
//                                testObjList.add(testObj1);
//                            }
//                        }
//                    }
//                });
//            }
//        });
    }

    private void addItem(ItemSell itemSell, CollectionReference addReference) {
        Map<String, Object> item = new HashMap<>();
        item.put("idItemSell", itemSell.getIdItemSell());
        item.put("codeMainCateId", itemSell.getCodeMainCateId());
        item.put("codeSideCateId", itemSell.getCodeSideCateId());
        item.put("nameItemSell", itemSell.getNameItemSell());
        item.put("sale", itemSell.getSale());
        item.put("salePercent", itemSell.getSalePercent());
        item.put("priceDontSale", itemSell.getPriceDontSale());
        item.put("priceSale", itemSell.getPriceSale());
        item.put("totalItem", itemSell.getTotalItem());
        item.put("totalItemSold", itemSell.getTotalItemSold());
        item.put("itemSoldInMonth", itemSell.getItemSoldInMonth());
        item.put("idUserSell", itemSell.getIdUserSell());
        item.put("tradeMark", itemSell.getTrademark());
        item.put("characteristics", itemSell.getCharacteristics());
        item.put("eventCode", itemSell.getEventCode());
        item.put("daySell", itemSell.getDaySell());
        item.put("avatarItem", itemSell.getAvatarItemSell());
        addReference.add(item).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(MainActivity.this, "Succes", Toast.LENGTH_SHORT).show();
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "False", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}