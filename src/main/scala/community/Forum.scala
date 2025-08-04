package community

import scala.collection.mutable.{ListBuffer, Buffer}

class Forum {
  case class Post(author: User, content: String)
  case class Thread(title: String, posts: Buffer[Post] = ListBuffer.empty)

  private val threads: Buffer[Thread] = ListBuffer.empty

  def createThread(title: String): Thread = {
    val thread = Thread(title)
    threads += thread
    thread
  }

  def addPost(thread: Thread, author: User, content: String): Unit =
    thread.posts += Post(author, content)

  def allThreads: Seq[Thread] = threads.toSeq
}
