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

        animalData.animalList.add(new Animal("Cat", "แมว", R.drawable.cat, getString(R.string.details_cat)));
        animalData.animalList.add(new Animal("Dog", "หมา", R.drawable.dog, getString(R.string.details_dog)));
        animalData.animalList.add(new Animal("Dolphin", "โลมา", R.drawable.dolphin, getString(R.string.details_dolphin)));
        animalData.animalList.add(new Animal("Koala", "โคอาลา", R.drawable.koala, getString(R.string.details_koala)));
        animalData.animalList.add(new Animal("Owl", "นกฮูก", R.drawable.owl, getString(R.string.details_owl)));
        animalData.animalList.add(new Animal("Rabbit", "กระต่าย", R.drawable.rabbit, getString(R.string.details_rabbit)));
        animalData.animalList.add(new Animal("Penguin", "เพนกวิน", R.drawable.penguin, getString(R.string.details_penguin)));
        animalData.animalList.add(new Animal("Tiger", "เสือ", R.drawable.tiger, getString(R.string.details_tiger)));
        animalData.animalList.add(new Animal("Pig", "หมู", R.drawable.pig, getString(R.string.details_pig)));
        animalData.animalList.add(new Animal("Lion", "สิงโต", R.drawable.lion, getString(R.string.details_lion)));

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
                Toast.makeText(MainActivity.this, animal.englishName, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, AnimalDetailsActivity.class);
                //intent.putExtra("englishName", animal.englishName);
                //intent.putExtra("picture", animal.picture);
                intent.putExtra("position", i);
                startActivity(intent);
            }
        });

    }
}
