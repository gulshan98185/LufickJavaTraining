package com.lufick.training.collections;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.lufick.training.R;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.adapters.ItemAdapter;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class CollectionsActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    FastAdapter<ListItem> fastAdapter;
    ItemAdapter<ListItem> itemItemAdapter;
    ArrayList<Student> listItems;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collections);
        recyclerView = findViewById(R.id.recycler_view);
        itemItemAdapter = ItemAdapter.items();
        fastAdapter = FastAdapter.with(itemItemAdapter);
        recyclerView.setAdapter(fastAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Array list
        listItems = new ArrayList<>();
        listItems.add(new Student("School", "class1", 3));
        listItems.add(new Student("Van", "car", 32));
        listItems.add(new Student("Country", "branch", 4));
        listItems.add(new Student("Collage", "class", 2));
        listItems.add(new Student("Market", "city", 5));
        listItems.add(new Student("Student", "rollno", 71));
        listItems.add(new Student("School", "mall", 6));
        listItems.add(new Student("Van", "city", 8));
        listItems.add(new Student("Country", "city", 7));
        listItems.add(new Student("Collage", "rollno", 9));
        listItems.add(new Student("Student", "branch", 23));
        listItems.add(new Student("Market", "mall1", 54));
        listItems.add(new Student("School", "class2", 62));
        listItems.add(new Student("Van", "car", 70));
        listItems.add(new Student("Country", "car", 22));
        listItems.add(new Student("Collage", "branch", 18));
        listItems.add(new Student("Market", "mall2", 65));
        listItems.add(new Student("Student", "rollno", 51));
//        Log.d("TAG_SIZE", "onCreate: "+listItems.size());
//        ListItem listItem = listItems.get(10);
//        Log.d("TAG_SIZE", "onCreate: "+listItem.title + " " + listItem.subTitle);
//        listItems.remove(new ListItem("Student", "branch"));
//        listItems.remove(11);
//        Log.d("TAG_SIZE", "onCreate: "+listItems.size());

//        Collections.reverse(listItems);
//        Collections.shuffle(listItems);



        //stack
        Stack<Student> stackItems = new Stack<>();
        stackItems.push(new Student("School", "class1", 3));
        stackItems.push(new Student("Van", "car", 32));
        stackItems.push(new Student("Country", "branch", 4));
        stackItems.push(new Student("Collage", "class", 2));
        stackItems.push(new Student("Market", "city", 5));
        stackItems.push(new Student("Student", "rollno", 71));
        stackItems.push(new Student("School", "mall", 6));
        stackItems.push(new Student("Van", "city", 8));
        stackItems.push(new Student("Country", "city", 7));
        stackItems.push(new Student("Collage", "rollno", 9));
        stackItems.push(new Student("Student", "branch", 23));
        stackItems.push(new Student("Market", "mall1", 54));
        stackItems.push(new Student("School", "class2", 62));
        stackItems.push(new Student("Van", "car", 70));
        stackItems.push(new Student("Country", "car", 22));
        stackItems.push(new Student("Collage", "branch", 18));
        stackItems.push(new Student("Market", "mall2", 65));
        stackItems.push(new Student("Student", "rollno", 51));
        /*Student item = stackItems.pop();
        Student item = stackItems.peek();
        Log.d("TAG_SIZE", "onCreate: "+item.name + " father "+item.fatherName);
        Collections.sort(stackItems, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.name.compareTo(o2.name)>0){
                    return 1;
                }else if (o1.name.compareTo(o2.name)<0){
                    return -1;
                }else {
                    if (o1.fatherName.compareTo(o2.fatherName)>0){
                        return 1;
                    }else if (o1.fatherName.compareTo(o2.fatherName)<0){
                        return -1;
                    }else {
                        return o2.rollNO - o1.rollNO;
                    }
                }

            }
        });
        stackItems.pop();*/



        //set
        Set<Student> setItems = new HashSet<>();
        setItems.add(new Student("School", "class1", 3));
        setItems.add(new Student("School", "class1", 3));
        setItems.add(new Student("School", "class1", 3));
        setItems.add(new Student("School", "class1", 3));
        setItems.add(new Student("School", "class1", 3));
        setItems.add(new Student("School", "class1", 3));
        setItems.add(new Student("School", "class1", 3));
        setItems.add(new Student("Van", "car", 32));
        setItems.add(new Student("Country", "branch", 4));
        setItems.add(new Student("Collage", "class", 2));
        setItems.add(new Student("Market", "city", 5));
        setItems.add(new Student("Student", "rollno", 71));
        setItems.add(new Student("School", "mall", 6));
        setItems.add(new Student("Van", "city", 8));
        setItems.add(new Student("Country", "city", 7));
        setItems.add(new Student("Collage", "rollno", 9));
        setItems.add(new Student("Student", "branch", 23));
        setItems.add(new Student("Market", "mall1", 54));
        setItems.add(new Student("School", "class2", 62));
        setItems.add(new Student("Van", "car", 70));
        setItems.add(new Student("Van", "car", 70));
        setItems.add(new Student("Van", "car", 70));
        setItems.add(new Student("Van", "car", 70));
        setItems.add(new Student("Van", "car", 70));
        setItems.add(new Student("Van", "car", 70));
        setItems.add(new Student("Van", "car", 70));
        setItems.add(new Student("Van", "car", 70));
        setItems.add(new Student("Van", "car", 70));
        setItems.add(new Student("Van", "car", 70));
        setItems.add(new Student("Van", "car", 70));
        setItems.add(new Student("Van", "car", 70));
        setItems.add(new Student("Van", "car", 70));
        setItems.add(new Student("Van", "car", 70));
        setItems.add(new Student("Van", "car", 70));
        setItems.add(new Student("Van", "car", 70));
        setItems.add(new Student("Van", "car", 70));
        setItems.add(new Student("Van", "car", 70));
        setItems.add(new Student("Van", "car", 70));
        setItems.add(new Student("Country", "car", 22));
        setItems.add(new Student("Collage", "branch", 18));
        setItems.add(new Student("Market", "mall2", 65));
        setItems.add(new Student("Student", "rollno", 51));
//        we cannot sort sets directly
        ArrayList<Student> setList = new ArrayList<>(setItems);
        Collections.sort(setList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.name.compareTo(o2.name)>0){
                    return 1;
                }else if (o1.name.compareTo(o2.name)<0){
                    return -1;
                }else {
                    if (o1.fatherName.compareTo(o2.fatherName)>0){
                        return 1;
                    }else if (o1.fatherName.compareTo(o2.fatherName)<0){
                        return -1;
                    }else {
                        return o2.rollNO - o1.rollNO;
                    }
                }

            }
        });





        //map
        Map<String, Student> mapItems = new HashMap<>();
        mapItems.put("3", new Student("School", "class1", 3));
        mapItems.put("32", new Student("Van", "car", 32));
        mapItems.put("4", new Student("Country", "branch", 4));
        mapItems.put("2", new Student("Collage", "class", 2));
        mapItems.put("5", new Student("Market", "city", 5));
        mapItems.put("71", new Student("Student", "rollno", 71));
        mapItems.put("6", new Student("School", "mall", 6));
        mapItems.put("8", new Student("Van", "city", 8));
        mapItems.put("7", new Student("Country", "city", 7));
        mapItems.put("9", new Student("Collage", "rollno", 9));
        mapItems.put("23", new Student("Student", "branch", 23));
        mapItems.put("54", new Student("Market", "mall1", 54));
        mapItems.put("62", new Student("School", "class2", 62));
        mapItems.put("70", new Student("Van", "car", 70));
        mapItems.put("22", new Student("Country", "car", 22));
        mapItems.put("18", new Student("Collage", "branch", 18));
        mapItems.put("65", new Student("Market", "mall2", 65));
        mapItems.put("51", new Student("Student", "rollno", 51));
        Student studentMap = mapItems.get("65");
        boolean containKey = mapItems.containsKey("51");
        boolean containValue = mapItems.containsValue(new Student("Market", "mall2", 65));



        ArrayList<ListItem> listItemsArrayList = new ArrayList<>();
        for (Student student: mapItems.values()){
            listItemsArrayList.add(new ListItem(student));
        }

        /*listItems.forEach(student -> {
                listItemsArrayList.add(new ListItem(student));
        });*/
        itemItemAdapter.setNewList(listItemsArrayList);

    }
}