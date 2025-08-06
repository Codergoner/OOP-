package community

import scala.collection.mutable.ListBuffer

/**
 * Provides basic activity tracking for domain objects.
 * Implementations can record user interactions which are
 * retrievable via [[activities]].
 */
trait Trackable {
  private val log = ListBuffer.empty[String]

  /** Record an activity string into the log. */
  def trackActivity(activity: String): Unit = log += activity

  /** Obtain the recorded activity history. */
  def activities: Seq[String] = log.toSeq
}
