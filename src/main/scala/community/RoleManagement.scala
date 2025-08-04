package community

import community.users.User

trait RoleManagement {
  def assignRole(user: User, role: String): Unit
}
