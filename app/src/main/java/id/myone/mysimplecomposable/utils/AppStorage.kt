/**
 * Created by Mahmud on 20/03/23.
 * mahmud120398@gmail.com
 */

package id.myone.mysimplecomposable.utils

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class AppStorage constructor(private val dataStore: DataStore<Preferences>) {

    val getUserToken: Flow<String?> = dataStore.data.map { preferences ->
        preferences[USER_TOKEN_KEY]
    }

    suspend fun storeUserToken(token: String) {
        dataStore.edit { preferences ->
            preferences[USER_TOKEN_KEY] = token
        }
    }

    companion object {
        private val USER_TOKEN_KEY = stringPreferencesKey("user_token_key")
    }
}