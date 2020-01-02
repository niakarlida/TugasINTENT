package id.ac.poliban.mi.nia.tugasintent;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MhsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mhs);

        EditText edNim = findViewById(R.id.edNim);
        EditText edNama = findViewById(R.id.edNama);
        EditText edAlamat = findViewById(R.id.edAlaamt);
        EditText edTelp = findViewById(R.id.edTelp);
        Button btSend = findViewById(R.id.btSend);

        btSend.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra("MhsNim", edNim.getText().toString());
            intent.putExtra("MhsNama", edNama.getText().toString());
            intent.putExtra("MhsAlamat", edAlamat.getText().toString());
            intent.putExtra("MhsTelp", edTelp.getText().toString());
            setResult(RESULT_OK, intent);
            finish();
        });
    }
}
