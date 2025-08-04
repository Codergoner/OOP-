package community

import javafx.fxml.FXML

class ForumController {
  private val forum = new Forum

  @FXML
  def newThread(): Unit = {
    forum.createThread("General Discussion")
    println("Thread created")
  }
}
