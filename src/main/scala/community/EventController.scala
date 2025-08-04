package community

import javafx.fxml.{FXML, FXMLLoader}
import javafx.scene.Scene
import javafx.scene.control.{ListView, TextField}
import java.time.LocalDate
import javafx.stage.Stage
import scala.collection.mutable.ListBuffer

class EventController {
  @FXML private var titleField: TextField = _
  @FXML private var eventsList: ListView[String] = _

  private val events = ListBuffer.empty[Event]

  @FXML
  def createEvent(): Unit = {
    val organizer = Session.currentUser.getOrElse(new CommunityLeader("Admin", "admin@example.com"))
    val event = Event(titleField.getText, "", LocalDate.now, organizer)
    events += event
    eventsList.getItems.add(event.title)
    event.sendNotification("Event created")
    organizer.trackActivity("created event")
  }

  @FXML
  def deleteEvent(): Unit = {
    val index = eventsList.getSelectionModel.getSelectedIndex
    if (index >= 0) {
      events.remove(index)
      eventsList.getItems.remove(index)
    }
  }

  @FXML
  def backToDashboard(): Unit = {
    val stage = eventsList.getScene.getWindow.asInstanceOf[Stage]
    val root = FXMLLoader.load(getClass.getResource("/dashboard.fxml"))
    stage.setScene(new Scene(root))
    Session.currentUser.foreach(_.trackActivity("back to dashboard"))
  }
}
