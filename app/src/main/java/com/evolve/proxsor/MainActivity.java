package com.evolve.proxsor;

import android.annotation.TargetApi;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.evolve.proxsory.ProximitySensor;
import com.evolve.proxsory.ProximityEventView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ProximityEventView sensorView;

    TextView valueTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valueTextView = findViewById(R.id.value);

        ProximitySensor.instance.getInstance().create(this);

       List<Sensor> allsensors = ProximitySensor.instance.getInstance().getAllAvailableSensors();

        ProximitySensor.instance.getInstance().create(this, Sensor.TYPE_PROXIMITY);
         sensorView = new ProximityEventView() {
            @Override
            public void onSensorChanged(@NonNull SensorEvent value) {
                Log.v("Sensor overide"," "+value.values[0]);

                valueTextView.setText(""+value.values[0]);

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