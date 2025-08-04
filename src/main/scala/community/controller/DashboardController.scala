package community.controller

import javafx.fxml.FXML
import javafx.scene.control.{Button, Label}

/**
 * Controller for the main dashboard scene.
 */
class DashboardController {
  @FXML private var welcomeLabel: Label = _
  @FXML private var eventsButton: Button = _
  @FXML private var forumButton: Button = _
  @FXML private var resourcesButton: Button = _

  @FXML
  private def openEvents(): Unit = println("Open events scene")

  @FXML
  private def openForum(): Unit = println("Open forum scene")

  @FXML
  private def openResources(): Unit = println("Open resources scene")
}
