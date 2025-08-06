package community

class CommunityLeader(name: String, email: String)
    extends User(name, email, CommunityLeaderRole) {
  override def trackActivity(activity: String): Unit = {
    super.trackActivity(activity)
    println(s"Leader $name activity: $activity")
  }
}
