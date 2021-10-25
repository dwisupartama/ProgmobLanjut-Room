package id.dwisupartama.approom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import id.dwisupartama.approom.Database.AppDatabase;
import id.dwisupartama.approom.Database.Entitas.Mahasiswa;

public class CreateActivity extends AppCompatActivity {
    private Button buttonSimpan;
    private EditText nim, nama, alamat;
    private AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        nim = findViewById(R.id.inputNIM);
        nama = findViewById(R.id.inputNama);
        alamat = findViewById(R.id.inputAlamat);
        buttonSimpan = findViewById(R.id.buttonSimpan);

        database = AppDatabase.getInstance(getApplicationContext());

        buttonSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Mahasiswa mahasiswa = new Mahasiswa();
                mahasiswa.nim = Integer.parseInt(nim.getText().toString());
                mahasiswa.nama = nama.getText().toString();
                mahasiswa.alamat = alamat.getText().toString();
                database.mahasiswaDao().insertAll(mahasiswa);
                Toast.makeText(CreateActivity.this, "Data Tersimpan", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}