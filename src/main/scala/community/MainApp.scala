package community

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage

class MainApp extends Application {
  override def start(stage: Stage): Unit = {
    val loader = new FXMLLoader(getClass.getResource("/login.fxml"))
    val scene = new Scene(loader.load())
    stage.setScene(scene)
    stage.setTitle("Community Engagement Platform")
    stage.show()
  }
}

object MainApp {
  def main(args: Array[String]): Unit = {
    Application.launch(classOf[MainApp], args: _*)
  }
}
