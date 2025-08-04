package community

import scalafx.application.JFXApp3
import scalafx.scene.Scene
import scalafx.fxml.FXMLLoader
import scalafx.scene.Parent

object Main extends JFXApp3 {
  override def start(): Unit = {
    val loader = new FXMLLoader(getClass.getResource("/LoginScene.fxml"))
    val root: Parent = loader.load()
    stage = new JFXApp3.PrimaryStage {
      title = "Community Engagement Platform"
      scene = new Scene(root)
    }
  }
}
