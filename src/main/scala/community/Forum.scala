package community

import scala.collection.mutable

class Forum {
  private val threads = mutable.Map.empty[String, mutable.Buffer[String]]

  def addThread(title: String): Unit =
    threads.getOrElseUpdate(title, mutable.Buffer.empty)

  def addPost(threadTitle: String, post: String): Unit =
    threads.get(threadTitle).foreach(_ += post)

  def getPosts(threadTitle: String): Seq[String] =
    threads.getOrElse(threadTitle, mutable.Buffer.empty).toSeq
}
