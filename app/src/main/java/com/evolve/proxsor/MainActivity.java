package com.evolve.proxsor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.evolve.proxsory.ProximitySensor;
import com.evolve.proxsory.ProximityEventView;

public class MainActivity extends AppCompatActivity {
    ProximityEventView sensorView;

    TextView valueTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valueTextView = findViewById(R.id.value);

        ProximitySensor.instance.getInstance().create(this);
         sensorView = new ProximityEventView() {
            @Override
            public void onSensorChanged(float value) {
                Log.v("Sensor overide"," "+value);

                valueTextView.setText(String.valueOf(value));
            }
        };

        ProximitySensor.instance.getInstance().listenToEvents(sensorView);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        ProximitySensor.instance.getInstance().stopListeninToEvents(sensorView);


    }
}