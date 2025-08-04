package community

import java.time.LocalDate
import community.users.User
import scala.collection.mutable.Buffer

case class Event(
    title: String,
    description: String,
    date: LocalDate,
    organizer: User,
    participants: Buffer[User] = Buffer.empty
) {
  def addParticipant(user: User): Unit = participants += user
  def removeParticipant(user: User): Unit = participants -= user
}
