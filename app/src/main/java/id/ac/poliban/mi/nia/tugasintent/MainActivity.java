package id.ac.poliban.mi.nia.tugasintent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private final int REQUEST_CODE = 100;
    private String mahasiswa;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        assert data != null;
        if (requestCode == REQUEST_CODE && resultCode== Activity.RESULT_OK && data.getExtras()!=null)
            mahasiswa = "NIM        : " + data.getStringExtra("MhsNim") + "\n";
            mahasiswa += "Nama      : " + data.getStringExtra("MhsNama") + "\n";
            mahasiswa += "Alamat    : " + data.getStringExtra("MhsAlamat") + "\n";
            mahasiswa += "Telepon   : " + data.getStringExtra("MhsTelp");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btShowInput = findViewById(R.id.btShowInput);
        btShowInput.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MhsActivity.class);
            startActivityForResult(intent, REQUEST_CODE);
        });

        Button btShowMhs = findViewById(R.id.btShowMhs);
        btShowMhs.setOnClickListener(v -> {
            new AlertDialog.Builder(this)
                    .setTitle("Info Mahasiswa : ")
                    .setMessage(mahasiswa)
                    .setPositiveButton("OK", null)
                    .show();
        });

    }

}
