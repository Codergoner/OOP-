package community

import javafx.fxml.FXML
import javafx.scene.control.TextField
import java.time.LocalDate

class EventController {
  @FXML private var titleField: TextField = _

  @FXML
  def createEvent(): Unit = {
    val event = Event(titleField.getText, "", LocalDate.now, new CommunityLeader("Admin", "admin@example.com"))
    println(s"Created event: ${'$'}{event.title}")
  }
}
