package community

import javafx.fxml.{FXML, FXMLLoader}
import javafx.scene.Scene
import javafx.scene.control.{ListView, TextField}
import java.time.LocalDate
import javafx.stage.Stage
import scala.collection.mutable.ListBuffer

class ResourceController {
  @FXML private var titleField: TextField = _
  @FXML private var resourcesList: ListView[String] = _

  private val resources = ListBuffer.empty[Resource]

  @FXML
  def uploadResource(): Unit = {
    val uploader = Session.currentUser.getOrElse(new Volunteer("Uploader", "uploader@example.com"))
    val resource = Resource(titleField.getText, "General", LocalDate.now, uploader)
    resources += resource
    resourcesList.getItems.add(resource.title)
    resource.sendNotification("Resource uploaded")
    uploader.trackActivity("uploaded resource")
  }

  @FXML
  def deleteResource(): Unit = {
    val index = resourcesList.getSelectionModel.getSelectedIndex
    if (index >= 0) {
      resources.remove(index)
      resourcesList.getItems.remove(index)
    }
  }

  @FXML
  def backToDashboard(): Unit = {
    val stage = resourcesList.getScene.getWindow.asInstanceOf[Stage]
    val root = FXMLLoader.load(getClass.getResource("/dashboard.fxml"))
    stage.setScene(new Scene(root))
    Session.currentUser.foreach(_.trackActivity("back to dashboard"))
  }
}
