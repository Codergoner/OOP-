package community

import java.time.LocalDate

case class Resource(
    title: String,
    category: String,
    uploadDate: LocalDate,
    uploader: User
) extends Notification {

  override def sendNotification(message: String): Unit =
    println(s"[Resource: $title] $message")
}
