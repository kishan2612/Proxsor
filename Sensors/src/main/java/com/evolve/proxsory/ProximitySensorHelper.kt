package com.evolve.proxsory

interface ProximitySensorHelper{
   public fun listenToEvents(proximityEventView: ProximityEventView)
   public fun stopListeninToEvents(proximityEventView: ProximityEventView)
}