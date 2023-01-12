package ru.otus.auth

import org.mindrot.jbcrypt.BCrypt

private val usersDb = mapOf(
    // BCRYPT хэши, использовался https://bcrypt-generator.com/
    "Vasya" to "\$2a\$10\$shhcegnKXd1eX.rbcSCFDOMC7.DbGF8F/BiV1Ld75CWirs0YOe0iG", // "123"
    "Petya" to "\$2a\$10\$eEzCXf3C07XwdLKSuPaJme6BcDel617Y6eo2MsE.gPtj1TEmmJ0D2" // "cba"
)

fun checkUserPassword(username: String, password: String): Boolean {
    val hash = usersDb[username] ?: return false
    return BCrypt.checkpw(password, hash)
}