package community

import javafx.fxml.{FXML, FXMLLoader}
import javafx.scene.Scene
import javafx.scene.layout.VBox
import javafx.stage.Stage

class DashboardController {
  @FXML private var rootPane: VBox = _

  @FXML
  def initialize(): Unit = {
    println("Dashboard loaded")
  }

  private def switchScene(fxml: String, activity: String): Unit = {
    val stage = rootPane.getScene.getWindow.asInstanceOf[Stage]
    val root = FXMLLoader.load(getClass.getResource(fxml))
    stage.setScene(new Scene(root))
    Session.currentUser.foreach(_.trackActivity(activity))
  }

  @FXML def goToEvents(): Unit =
    if (Session.currentUser.exists(_.role == CommunityLeaderRole))
      switchScene("/events.fxml", "navigate events")
    else
      println("Access denied")

  @FXML def goToForum(): Unit = switchScene("/forum.fxml", "navigate forum")
  @FXML def goToResources(): Unit = switchScene("/resources.fxml", "navigate resources")
}
