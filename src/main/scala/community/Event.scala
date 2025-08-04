package community

import java.time.LocalDate
import scala.collection.mutable.ListBuffer

case class Event(
    title: String,
    description: String,
    date: LocalDate,
    organizer: User,
    participants: ListBuffer[User] = ListBuffer.empty
) extends Notification {

  def addParticipant(user: User): Unit = participants += user

  override def sendNotification(message: String): Unit =
    println(s"[Event: $title] $message")
}
