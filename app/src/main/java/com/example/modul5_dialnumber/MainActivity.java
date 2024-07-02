package com.example.modul5_dialnumber;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements KontakAdapter.OnContactClickListener{

    public RecyclerView rv;
    public KontakAdapter contactAdapter;
    public RecyclerView.LayoutManager layoutManager;
    public List<Kontak> listContact = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.rvContact);

        listContact.add(new Kontak("Papah",
                "083123456789",
                "https://cdn2.iconfinder.com/data/icons/male-avatars/512/avatars_accounts___man_male_people_person_glasses_moustache_mustache_hairstyle_cardigan_sweater.png"));

        listContact.add(new Kontak("Mamah",
                "O83811176543",
                "https://cdn2.iconfinder.com/data/icons/female-avatars-4/512/avatars_accounts___female_woman_people_person_short_hair_hair_necklace_earrings.png"));

        listContact.add(new Kontak("Nanda April",
                "083156686645",
                "https://cdn2.iconfinder.com/data/icons/female-avatars-4/512/avatars_accounts___female_woman_people_person_necklace_earrings_long_hair.png"));

        listContact.add(new Kontak("Intan",
                "083868765343",
                "https://cdn2.iconfinder.com/data/icons/female-avatars-4/512/avatars_accounts___female_woman_people_person_medium_hair_necklace_earrings.png"));

        listContact.add(new Kontak("Rendy",
                "083176855678",
                "https://cdn2.iconfinder.com/data/icons/male-avatars/512/avatars_accounts___man_male_people_person_wavy_hair_jacket_turtleneck.png"));

        listContact.add(new Kontak("Deti",
                "085433176895",
                "https://cdn2.iconfinder.com/data/icons/female-avatars-4/512/avatars_accounts___female_woman_people_person_buns_earrings_shirt.png"));

        listContact.add(new Kontak("Teddy",
                "083159616789",
                "https://cdn2.iconfinder.com/data/icons/female-avatars-4/512/avatars_accounts___female_woman_people_person_earrings_hoodie_short_hair.png"));

        listContact.add(new Kontak("Rio",
                "083122281087",
                "https://cdn2.iconfinder.com/data/icons/male-avatars/512/avatars_accounts___man_male_people_person_shirt_headphone_headset_music_listen.png"));


        contactAdapter = new KontakAdapter(listContact);
        contactAdapter.setListener(this);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        rv.setAdapter(contactAdapter);
        rv.setLayoutManager(layoutManager);
    }

    @Override
    public void onClick(View view, int position) {
        Kontak kontak = listContact.get(position);
        Toast.makeText(this, kontak.getNama(), Toast.LENGTH_LONG)
                .show();

        String nomorTelepon = kontak.getTelepon();
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + nomorTelepon));
        startActivity(intent);
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}