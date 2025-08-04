package community.model

import community.util.Trackable

/**
 * Base abstract user in the system.
 * @param name user's full name
 * @param email contact email
 * @param role role identifier for permissions
 */
abstract class User(var name: String, var email: String, var role: String) extends Trackable {
  def displayInfo(): String = s"$name ($role)"
}
