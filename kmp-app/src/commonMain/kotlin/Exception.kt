
class TeamNotFoundException(id: String) : Exception("Team with id `$id` not found.")

class UserNotFoundException(id: String) : Exception("User with id `$id` not found.")

class MissingFieldException(field: String) : Exception("Field `$field` is required.")

