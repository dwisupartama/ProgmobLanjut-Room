package id.dwisupartama.approom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import id.dwisupartama.approom.Database.AppDatabase;
import id.dwisupartama.approom.Database.Entitas.Mahasiswa;

public class UpdateActivity extends AppCompatActivity {
    private Button buttonUpdate;
    private EditText nim, nama, alamat;
    private AppDatabase database;
    private int idEdit = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        nim = findViewById(R.id.inputNIM);
        nama = findViewById(R.id.inputNama);
        alamat = findViewById(R.id.inputAlamat);
        buttonUpdate = findViewById(R.id.buttonUpdate);

        database = AppDatabase.getInstance(getApplicationContext());

        Intent data = getIntent();
        idEdit = data.getIntExtra("nim", 0);
        if(idEdit > 0){
            Mahasiswa mahasiswa = database.mahasiswaDao().get(idEdit);
            nama.setText(mahasiswa.nama);
            alamat.setText(mahasiswa.alamat);
        }

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database.mahasiswaDao().update(nama.getText().toString(), alamat.getText().toString(), idEdit);
                Toast.makeText(UpdateActivity.this, "Data Telah Diperbaharui", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}