package community

abstract class User(val name: String, val email: String, private var _role: Role)
    extends Trackable
    with RoleManagement {

  def role: Role = _role

  override def assignRole(role: Role): Unit = {
    _role = role
  }
}
