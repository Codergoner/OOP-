package community

import java.time.LocalDate
import community.users.User

case class Resource(
    title: String,
    category: String,
    uploadDate: LocalDate,
    uploader: User
)
