package community

trait Notification {
  def sendNotification(message: String): Unit
}
