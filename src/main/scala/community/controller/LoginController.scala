package community.controller

import javafx.fxml.FXML
import javafx.scene.control.{Button, PasswordField, TextField}

/**
 * Controller for the login scene.
 */
class LoginController {
  @FXML private var emailField: TextField = _
  @FXML private var passwordField: PasswordField = _
  @FXML private var loginButton: Button = _

  @FXML
  private def handleLogin(): Unit = {
    // Placeholder for login logic
    println(s"Logging in: ${'$'}{emailField.getText}")
  }
}
