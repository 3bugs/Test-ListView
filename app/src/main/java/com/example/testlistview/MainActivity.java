package com.example.testlistview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.testlistview.adapter.AnimalListAdapter;
import com.example.testlistview.model.Animal;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    //private ArrayList<Animal> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.list_view);

        final AnimalData animalData = AnimalData.getInstance();
        animalData.animalList = new ArrayList<>();

        animalData.animalList.add(new Animal("Cat", R.drawable.cat));
        animalData.animalList.add(new Animal("Dog", R.drawable.dog));
        animalData.animalList.add(new Animal("Dolphin", R.drawable.dolphin));
        animalData.animalList.add(new Animal("Koala", R.drawable.koala));
        animalData.animalList.add(new Animal("Owl", R.drawable.owl));
        animalData.animalList.add(new Animal("Ribbit", R.drawable.rabbit));
        animalData.animalList.add(new Animal("Penguin", R.drawable.penguin));
        animalData.animalList.add(new Animal("Tiger", R.drawable.tiger));
        animalData.animalList.add(new Animal("Pic", R.drawable.pig));
        animalData.animalList.add(new Animal("Lion", R.drawable.lion));

        AnimalListAdapter adapter = new AnimalListAdapter(
                this,
                R.layout.item,
                animalData.animalList
        );

        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Animal animal = animalData.animalList.get(i);
                Toast.makeText(MainActivity.this, animal.name, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, AnimalDetailsActivity.class);
                //intent.putExtra("name", animal.name);
                //intent.putExtra("picture", animal.picture);
                intent.putExtra("position", i);
                startActivity(intent);
            }
        });

    }
}
