package community.controller

import javafx.collections.FXCollections
import javafx.fxml.FXML
import javafx.scene.control.{Button, ListView, TextArea, TextField}
import community.model.{Forum, Post, User}
import java.time.LocalDateTime

/**
 * Controller for community forum scene.
 */
class ForumController {
  private val forum = new Forum
  private val posts = FXCollections.observableArrayList[String]()

  @FXML private var threadField: TextField = _
  @FXML private var contentArea: TextArea = _
  @FXML private var postButton: Button = _
  @FXML private var postList: ListView[String] = _

  @FXML
  private def addPost(): Unit = {
    val thread = threadField.getText
    forum.createThread(thread)
    val p = Post(dummyUser, contentArea.getText, LocalDateTime.now())
    forum.addPost(thread, p)
    posts.setAll(forum.getPosts(thread).map(_.content): _*)
    postList.setItems(posts)
  }

  private val dummyUser: User = new User("system", "system@example.com", "system") {
    override def trackActivity(activity: String): Unit = ()
  }
}
