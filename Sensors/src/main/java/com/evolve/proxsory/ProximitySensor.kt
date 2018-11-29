package com.evolve.proxsory

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager

 class ProximitySensor : ProximitySensorHelper{

    private lateinit var context : Context

    private lateinit var mSensorManager : SensorManager

    private lateinit var mSensor: Sensor

     companion object instance{
        val instance : ProximitySensor by lazy { ProximitySensor() }
    }

    fun create(context: Context){
        this.context = context

        mSensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager

        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)
    }

    override fun listenToEvents(proximityEventView: ProximityEventView){
        mSensorManager.registerListener(ProximitySensorEventListner(proximityEventView) ,mSensor, SensorManager.SENSOR_DELAY_FASTEST)
    }

    override fun stopListeninToEvents(proximityEventView: ProximityEventView){
        mSensorManager.unregisterListener(ProximitySensorEventListner(proximityEventView))
    }


}