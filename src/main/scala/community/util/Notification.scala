package community.util

/**
 * Notification capability for delivering messages to users.
 */
trait Notification {
  def sendNotification(message: String): Unit
}
