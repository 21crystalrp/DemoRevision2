package sg.edu.rp.c346.id21033293.demorevision2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    EditText etUsername;
    TextView tvMode;
    ToggleButton toggleMode;
    Button btnLoad, btnSave;
    SharedPreferences myPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.etUsername);
        toggleMode = findViewById(R.id.toggleMode);
        btnLoad = findViewById(R.id.btnLoad);
        btnSave = findViewById(R.id.btnSave);

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getPreferences(MODE_PRIVATE);
                String msg;
                if (toggleMode.isChecked()) {
                    msg = prefs.getString("MultiName", "Player X");
                } else {
                    msg = prefs.getString("SoloName", "Solo PLayer X");
                }
                etUsername.setText(msg);
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor prefEdit = myPref.edit();
                String username = etUsername.getText().toString();
                boolean mode = toggleMode.isChecked();
                if (mode) {
                    prefEdit.putString("MultiName", username);
                } else {
                    prefEdit.putString("SoloName", username);
                }

                prefEdit.commit();
            }
        });

    }
}