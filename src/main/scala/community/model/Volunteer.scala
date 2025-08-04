package community.model

import community.util.Notification

/**
 * Volunteer user of the platform.
 */
class Volunteer(name: String, email: String)
  extends User(name, email, "Volunteer") with Notification {

  override def sendNotification(message: String): Unit =
    println(s"Notification to $name: $message")

  override def trackActivity(activity: String): Unit =
    println(s"Volunteer $name activity: $activity")
}
