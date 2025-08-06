package community

class Volunteer(name: String, email: String)
    extends User(name, email, VolunteerRole) {
  override def trackActivity(activity: String): Unit = {
    super.trackActivity(activity)
    println(s"Volunteer $name activity: $activity")
  }
}
