package community.users

import community.{Notification, Trackable}

abstract class User(val name: String, val email: String, val role: String)
    extends Notification
    with Trackable {

  override def sendNotification(message: String): Unit =
    println(s"Notification for $name: $message")

  override def trackActivity(activity: String): Unit =
    println(s"$name performed activity: $activity")
}
