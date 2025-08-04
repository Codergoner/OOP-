package community.model

import java.time.LocalDateTime
import scala.collection.mutable.{ListBuffer, Map}

/**
 * Simple forum for discussion threads.
 */
case class Post(author: User, content: String, date: LocalDateTime = LocalDateTime.now())

class Forum {
  private val threads = Map.empty[String, ListBuffer[Post]]

  def createThread(title: String): Unit =
    threads.getOrElseUpdate(title, ListBuffer.empty)

  def addPost(thread: String, post: Post): Unit =
    threads.get(thread).foreach(_ += post)

  def getPosts(thread: String): List[Post] =
    threads.get(thread).map(_.toList).getOrElse(Nil)
}
