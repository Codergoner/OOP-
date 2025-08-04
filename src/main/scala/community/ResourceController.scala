package community

import javafx.fxml.FXML
import javafx.scene.control.TextField
import java.time.LocalDate

class ResourceController {
  @FXML private var titleField: TextField = _

  @FXML
  def uploadResource(): Unit = {
    val resource = Resource(titleField.getText, "General", LocalDate.now, new Volunteer("Uploader", "uploader@example.com"))
    println(s"Uploaded resource: ${'$'}{resource.title}")
  }
}
