package community

import javafx.fxml.FXML
import javafx.scene.control.TextField
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage

class SignupController {
  @FXML private var nameField: TextField = _
  @FXML private var emailField: TextField = _

  @FXML
  def handleSignup(): Unit = {
    val name = nameField.getText
    val email = emailField.getText
    if (name.nonEmpty && email.nonEmpty) {
      val newUser = new Volunteer(name, email)
      UserRegistry.users(email) = newUser
      Session.currentUser = Some(newUser)
      val stage = nameField.getScene.getWindow.asInstanceOf[Stage]
      val root = FXMLLoader.load(getClass.getResource("/dashboard.fxml"))
      stage.setScene(new Scene(root))
    } else {
      println("Please enter name and email")
    }
  }

  @FXML
  def handleBack(): Unit = {
    val stage = nameField.getScene.getWindow.asInstanceOf[Stage]
    val root = FXMLLoader.load(getClass.getResource("/login.fxml"))
    stage.setScene(new Scene(root))
  }
}

