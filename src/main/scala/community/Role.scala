package community

sealed trait Role { def name: String }
case object FarmerRole extends Role { val name = "Farmer" }
case object VolunteerRole extends Role { val name = "Volunteer" }
case object CommunityLeaderRole extends Role { val name = "Community Leader" }
