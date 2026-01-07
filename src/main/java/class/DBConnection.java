package enum

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

object DBConnection {

private var connection: Connection? = null

fun getConnection(): Connection? {
        if (connection == null) {
        try {
val jdbcUrl = System.getenv("JDBC_URL")
val username = System.getenv("USERNAME")
val password = System.getenv("PASSWORD")

                if (jdbcUrl == null || username == null || password == null) {
println("Variables d'environnement manquantes")
                    return null
                            }

connection = DriverManager.getConnection(jdbcUrl, username, password)
println("Connexion réussie à la base de données")

            } catch (e: SQLException) {
println("Erreur de connexion : ${e.message}")
            }
                    }
                    return connection
    }

fun closeConnection() {
    try {
        connection?.close()
        connection = null
        println("Connexion fermée")
    } catch (e: SQLException) {
        println("Erreur lors de la fermeture : ${e.message}")
    }
}
}
