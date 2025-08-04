package community

import javafx.fxml.{FXML, FXMLLoader}
import javafx.scene.Scene
import javafx.scene.control.ListView
import javafx.stage.Stage

class ForumController {
  private val forum = new Forum
  @FXML private var threadsList: ListView[String] = _

  @FXML
  def newThread(): Unit = {
    val thread = forum.createThread("General Discussion")
    threadsList.getItems.add(thread.title)
    Session.currentUser.foreach(_.trackActivity("created thread"))
    println("Thread created")
  }

  @FXML
  def deleteThread(): Unit = {
    val index = threadsList.getSelectionModel.getSelectedIndex
    if (index >= 0) {
      val thread = forum.allThreads(index)
      forum.removeThread(thread)
      threadsList.getItems.remove(index)
    }
  }

  @FXML
  def backToDashboard(): Unit = {
    val stage = threadsList.getScene.getWindow.asInstanceOf[Stage]
    val root = FXMLLoader.load(getClass.getResource("/dashboard.fxml"))
    stage.setScene(new Scene(root))
    Session.currentUser.foreach(_.trackActivity("back to dashboard"))
  }
}
