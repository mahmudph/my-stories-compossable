/**
 * Created by Mahmud on 22/03/23.
 * mahmud120398@gmail.com
 */

package id.myone.mysimplecomposable.commons



class ServerException(message: String): Exception(message)
class DatabaseException(message: String): Exception(message)

class FormValidationException(
    message: String,
    val errors: Map<String, List<String>>
) : Exception(message) {

    override fun toString(): String {
        val errorTemp = mutableListOf<String>()
        for (error in errors) {
            errorTemp.add("${error.key} => ${error.value.joinToString(",")}")
        }

        return errorTemp.joinToString("\n")
    }
}
