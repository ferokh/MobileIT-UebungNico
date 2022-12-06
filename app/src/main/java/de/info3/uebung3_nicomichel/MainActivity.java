package de.info3.uebung3_nicomichel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSendMessage = this.findViewById(R.id.btnSendMessage);
        Button btnOpenDeparture = this.findViewById(R.id.departure);
        Button btnMap = this.findViewById(R.id.map);

        EditText edtMessage = this.findViewById(R.id.edtMessage);

        TextView txtMessage = this.findViewById(R.id.txtMessage);


        btnOpenDeparture.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DepartureActivity.class);
                startActivity(intent);
            }
        });

        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MapActivity.class);
                startActivity(intent);
            }
        });

        btnSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = edtMessage.getText().toString(); //Text rausholen und in eine Variable speichern
                txtMessage.setText(message);
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("Message",message);
                startActivity(intent);
            }
        });


    }
    public void openUrl(View view)
    {
        EditText txtUrl = this.findViewById(R.id.edtUrl);
        String url = txtUrl.getText().toString();

        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        Intent browserChooser = Intent.createChooser(browserIntent, "Wähle einen Browser");

        this.startActivity(browserChooser);
    }

}
