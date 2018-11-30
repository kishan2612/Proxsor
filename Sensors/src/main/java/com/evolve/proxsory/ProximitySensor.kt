package com.evolve.proxsory

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager

 class ProximitySensor : ProximitySensorHelper{

    private lateinit var context : Context

    private lateinit var mSensorManager : SensorManager

    private lateinit var mSensor: Sensor

    private var mSensorDelay : Int = SensorManager.SENSOR_DELAY_NORMAL
     /*
     lazy will provide single instance of the class
      */
     companion object instance{
        val instance : ProximitySensor by lazy { ProximitySensor() }

    }

    fun create(context: Context, sensorType: Int){
        this.context = context

        mSensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager

        mSensor = mSensorManager.getDefaultSensor(sensorType)
    }

     fun create(context: Context, sensorType: Int, senseorDelay : Int){
         this.context = context
         this.mSensorDelay = senseorDelay

         mSensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager

         mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)
     }

     /*
     Register the sensor listener
      */
    override fun listenToEvents(proximityEventView: ProximityEventView){
        mSensorManager.registerListener(ProximitySensorEventListner(proximityEventView) ,mSensor, mSensorDelay)
    }

     /*
     Unregister the sensor listner
      */

    override fun stopListeninToEvents(proximityEventView: ProximityEventView){
        mSensorManager.unregisterListener(ProximitySensorEventListner(proximityEventView))
    }

     /*
     Return the list of all available sensors
      */
     override fun getAllAvailableSensors(): List<Sensor> {
        return mSensorManager.getSensorList(Sensor.TYPE_ALL)
     }

     /*
     Checks whether the given sensor is available or not
      */

     override fun checkSensaorAvailable(sensorType: Int): Boolean {
        return mSensorManager.getDefaultSensor(sensorType) != null
     }


}