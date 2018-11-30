package com.evolve.proxsory

import android.hardware.SensorEvent

interface ProximityEventView {

    fun onSensorChanged(value : SensorEvent);
}