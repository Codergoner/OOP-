package community

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage

/**
 * Entry point for the Community Engagement Platform.
 * Loads the login scene by default.
 */
class MainApp extends Application {
  override def start(primaryStage: Stage): Unit = {
    val loader = new FXMLLoader(getClass.getResource("/LoginScene.fxml"))
    val scene = new Scene(loader.load())
    primaryStage.setTitle("Community Engagement Platform")
    primaryStage.setScene(scene)
    primaryStage.show()
  }
}

object MainApp {
  def main(args: Array[String]): Unit = {
    Application.launch(classOf[MainApp], args: _*)
  }
}
