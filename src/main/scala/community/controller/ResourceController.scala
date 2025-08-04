package community.controller

import javafx.collections.FXCollections
import javafx.fxml.FXML
import javafx.scene.control.{Button, ListView, TextField}
import community.model.{Resource, User}
import java.time.LocalDate

/**
 * Controller for resource sharing scene.
 */
class ResourceController {
  private val resources = FXCollections.observableArrayList[Resource]()

  @FXML private var titleField: TextField = _
  @FXML private var categoryField: TextField = _
  @FXML private var uploadButton: Button = _
  @FXML private var resourceList: ListView[Resource] = _

  @FXML
  private def uploadResource(): Unit = {
    val res = Resource(titleField.getText, categoryField.getText, LocalDate.now(), dummyUser)
    resources.add(res)
    resourceList.setItems(resources)
  }

  private val dummyUser: User = new User("system", "system@example.com", "system") {
    override def trackActivity(activity: String): Unit = ()
  }
}
