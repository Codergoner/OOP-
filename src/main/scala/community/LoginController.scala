package community

import javafx.fxml.FXML
import javafx.scene.control.TextField
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage

class LoginController {
  @FXML private var emailField: TextField = _

  private val users: Map[String, User] = Map(
    "farmer@example.com" -> new Farmer("Farmer Joe", "farmer@example.com"),
    "volunteer@example.com" -> new Volunteer("Volunteer Bob", "volunteer@example.com"),
    "leader@example.com" -> new CommunityLeader("Leader Alice", "leader@example.com")
  )

  @FXML
  def handleLogin(): Unit = {
    val email = emailField.getText
    users.get(email) match {
      case Some(user) =>
        Session.currentUser = Some(user)
        user.trackActivity("login")
        val stage = emailField.getScene.getWindow.asInstanceOf[Stage]
        val root = FXMLLoader.load(getClass.getResource("/dashboard.fxml"))
        stage.setScene(new Scene(root))
      case None =>
        println("Invalid user")
    }
  }
}
