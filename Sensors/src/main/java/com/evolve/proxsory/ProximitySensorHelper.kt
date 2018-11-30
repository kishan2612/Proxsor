package com.evolve.proxsory

import android.hardware.Sensor

interface ProximitySensorHelper {
    fun listenToEvents(proximityEventView: ProximityEventView)
    fun stopListeninToEvents(proximityEventView: ProximityEventView)

    fun getAllAvailableSensors(): List<Sensor>

    fun checkSensaorAvailable(sensorType : Int) : Boolean


}