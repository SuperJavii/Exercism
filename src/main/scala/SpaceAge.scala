import java.math._
object SpaceAge {
  val period = 31557600
  def onMercury(seconds:Double):Double = (math rint ((seconds/period) / 0.2408467)* 100) / 100
  def onVenus (seconds:Double):Double = (math rint ((seconds/period) / 0.61519726)* 100) / 100
  def onEarth(seconds:Double)= (math rint ((seconds/period) /1.0000)* 100) / 100
  def onMars (seconds:Double) = (math rint ((seconds/period) / 1.8808158)* 100) / 100
  def onJupiter (seconds:Double) = (math rint ((seconds/period)/11.862615)* 100) / 100
  def onSaturn (seconds:Double) = (math rint ((seconds/period) / 29.447498)* 100) / 100
  def onUranus (seconds:Double) = (math rint ((seconds/period) / 84.016846)* 100) / 100
  def onNeptune (seconds:Double) = (math rint ((seconds/period) / 164.79132)* 100) / 100
}


