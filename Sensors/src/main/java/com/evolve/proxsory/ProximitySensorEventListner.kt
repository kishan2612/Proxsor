package com.evolve.proxsory

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener

class ProximitySensorEventListner(proximityEventView: ProximityEventView) : SensorEventListener {
    private  var proximityEventView : ProximityEventView

    init {
        this.proximityEventView = proximityEventView
    }
    override fun onSensorChanged(event: SensorEvent?) {
        event?.let {
            proximityEventView.onSensorChanged(it)
        }
    }
    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

}