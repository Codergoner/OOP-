package community.controller

import javafx.collections.FXCollections
import javafx.fxml.FXML
import javafx.scene.control.{Button, ListView, TextArea, TextField}
import community.model.{Event, User}
import java.time.LocalDate

/**
 * Controller for event management scene.
 */
class EventController {
  private val events = FXCollections.observableArrayList[Event]()

  @FXML private var titleField: TextField = _
  @FXML private var descriptionArea: TextArea = _
  @FXML private var dateField: TextField = _
  @FXML private var createButton: Button = _
  @FXML private var eventList: ListView[Event] = _

  @FXML
  private def createEvent(): Unit = {
    val event = Event(titleField.getText, descriptionArea.getText, LocalDate.parse(dateField.getText), dummyUser)
    events.add(event)
    eventList.setItems(events)
  }

  private val dummyUser: User = new User("system", "system@example.com", "system") {
    override def trackActivity(activity: String): Unit = ()
  }
}
