package community.model

import java.time.LocalDate
import scala.collection.mutable.ListBuffer

/**
 * Represents a community event.
 */
case class Event(
  title: String,
  description: String,
  date: LocalDate,
  organizer: User,
  participants: ListBuffer[User] = ListBuffer.empty
) {
  def addParticipant(user: User): Unit = participants += user
}
