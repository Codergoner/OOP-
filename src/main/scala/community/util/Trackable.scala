package community.util

/**
 * Trait for tracking user activity within the platform.
 */
trait Trackable {
  /**
   * Track a user activity description.
   * @param activity description of the action performed
   */
  def trackActivity(activity: String): Unit
}
