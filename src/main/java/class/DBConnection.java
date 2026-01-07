package enum

import java.sql.Connection
import java.sql.DriverManager

object DBConnection {

var connection: Connection? = null

fun getConnection(): Connection? {
        if (connection == null) {
val url = System.getenv("JDBC_URL")
val user = System.getenv("USERNAME")
val password = System.getenv("PASSWORD")

connection = DriverManager.getConnection(url, user, password)
        }
                return connection
    }

fun closeConnection() {
    connection?.close()
    connection = null
}
}
