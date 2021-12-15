import java.sql.SQLException

class Auth {
    private val conn = DB.connect()!!

    fun register(login: String, pwdHash: String): Boolean {
        return try {
            conn.createStatement()
                .execute("insert into testapp.users(login, passwordHash) values ('$login', '$pwdHash');")
            println("user registered: ($login : $pwdHash)")
            true
        } catch (e: SQLException) {
            println(e.message)
            false
        }
    }

    fun login(login: String, pwdHash: String): Boolean  {
        val resSet = conn.createStatement()
            .executeQuery("select * from testapp.users where login='$login' and passwordHash='$pwdHash'")
        return resSet.next()
    }
}