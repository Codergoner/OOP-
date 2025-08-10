package community

import javafx.fxml.FXML
import javafx.scene.control.TextField
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage

class LoginController {
  @FXML private var emailField: TextField = _

  private val users = UserRegistry.users

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

  @FXML
  def handleShowSignup(): Unit = {
    val stage = emailField.getScene.getWindow.asInstanceOf[Stage]
    val root = FXMLLoader.load(getClass.getResource("/signup.fxml"))
    stage.setScene(new Scene(root))
  }
}
