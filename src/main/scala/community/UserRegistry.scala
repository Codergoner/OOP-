package community

import scala.collection.mutable

object UserRegistry {
  val users: mutable.Map[String, User] = mutable.Map(
    "farmer@example.com" -> new Farmer("Farmer Joe", "farmer@example.com"),
    "volunteer@example.com" -> new Volunteer("Volunteer Bob", "volunteer@example.com"),
    "leader@example.com" -> new CommunityLeader("Leader Alice", "leader@example.com")
  )
}

