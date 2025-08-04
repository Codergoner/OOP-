package community.util

import community.model.User

/**
 * Trait for assigning roles and managing permissions.
 */
trait RoleManagement {
  def assignRole(user: User, role: String): Unit
}
