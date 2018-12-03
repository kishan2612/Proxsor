# Proxsor
Android Sensor library

Most Android-powered devices have built-in sensors that measure motion, orientation, and various environmental conditions. These sensors are capable of providing raw data with high precision and accuracy, and are useful if you want to monitor three-dimensional device movement or positioning, or you want to monitor changes in the ambient environment near a device. For example, a game might track readings from a device's gravity sensor to infer complex user gestures and motions, such as tilt, shake, rotation, or swing. Likewise, a weather application might use a device's temperature sensor and humidity sensor to calculate and report the dewpoint, or a travel application might use the geomagnetic field sensor and accelerometer to report a compass bearing.



### Usage

1. Include repository
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  ````
  
  2. Include project as local library
  
  ```
  dependencies {
    implementation 'com.github.kishan2612:Proxsor:v1.1'
	}
  ```
  3. In you class create instance
  
  ```
          ProximitySensor.instance.create(this)
          or
          ProximitySensor.instance.create(this,Sensor.TYPE_PROXIMITY)
           or
          ProximitySensor.instance.create(this,Sensor.TYPE_PROXIMITY, int sensorDelay)



  ```
  4. Listen to sensor events
  
  ```
  ProximityEventView sensorView = sensorView = new ProximityEventView() {
            @Override
            public void onSensorChanged(@NonNull SensorEvent value) {
                Log.v("Sensor overide"," "+value.values[0]);

            }
        };
  ```
  5. Register and unregister listner
  
  ```
  ProximitySensor.instance.listenToEvents(sensorView)
  ```
  
  ```
  ProximitySensor.instance.stopListeninToEvents(this)
  ```
  
  
  public methods
  
  Returns all available sensors in mobile
  ```
  ProximitySensor.instance.getAllAvailableSensors()
  ```
  
  Returns boolean checks whether the given sensor available or not
  
  ```
  ProximitySensor.instance.checkSensaorAvailable(sensorType)
  ```
  
  ## ChangeLog

#### V1.1 :
      Initial release.
      
# License

```
MIT License

Copyright (c) 2018 kishan V

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
