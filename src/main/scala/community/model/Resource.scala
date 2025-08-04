package community.model

import java.time.LocalDate

/**
 * Educational resource uploaded to the platform.
 */
case class Resource(
  title: String,
  category: String,
  uploadDate: LocalDate,
  uploader: User
)
