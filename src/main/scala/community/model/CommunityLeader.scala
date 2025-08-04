package community.model

import community.util.{Notification, RoleManagement}

/**
 * Community leader with role management capabilities.
 */
class CommunityLeader(name: String, email: String)
  extends User(name, email, "CommunityLeader")
    with Notification with RoleManagement {

  override def sendNotification(message: String): Unit =
    println(s"Notification to $name: $message")

  override def trackActivity(activity: String): Unit =
    println(s"Community leader $name activity: $activity")

  override def assignRole(user: User, role: String): Unit = {
    user.role = role
    println(s"$name assigned role '$role' to ${user.name}")
  }
}
