package community

import javafx.fxml.FXML
import javafx.scene.control.TextField

class LoginController {
  @FXML private var emailField: TextField = _

  @FXML
  def handleLogin(): Unit = {
    println(s"Login attempt for ${'$'}{emailField.getText}")
  }
}
