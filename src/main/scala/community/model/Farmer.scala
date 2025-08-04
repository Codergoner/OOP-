package community.model

import community.util.Notification

/**
 * Farmer user of the platform.
 */
class Farmer(name: String, email: String)
  extends User(name, email, "Farmer") with Notification {

  override def sendNotification(message: String): Unit =
    println(s"Notification to $name: $message")

  override def trackActivity(activity: String): Unit =
    println(s"Farmer $name activity: $activity")
}
