package id.dwisupartama.approom.Database.Entitas;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Mahasiswa {
    @PrimaryKey
    public int nim;

    public String nama;

    public String alamat;


}
