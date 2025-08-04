package community

class Farmer(name: String, email: String)
    extends User(name, email, FarmerRole) {
  override def trackActivity(activity: String): Unit =
    println(s"Farmer $name activity: $activity")
}
