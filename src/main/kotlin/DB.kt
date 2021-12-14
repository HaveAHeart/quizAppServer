import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class DB {
    companion object {
        fun connect(): Connection? {
            Class.forName("org.postgresql.Driver")
            return try {
                DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "intellijIdea", "1234")
            } catch (e: SQLException) {
                println("Can not connect to DB.")
                e.printStackTrace()
                null
            }
        }
    }
}