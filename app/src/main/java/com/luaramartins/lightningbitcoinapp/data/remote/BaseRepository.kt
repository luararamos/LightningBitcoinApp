package com.luaramartins.lightningbitcoinapp.data.remote

import android.content.Context
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.luaramartins.lightningbitcoinapp.common.LightningConstants
import com.luaramartins.lightningbitcoinapp.domain.APIListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response

open class BaseRepository(val context: Context) {

    private fun failResponse(jsonErrorBody: String): String {
        return try {
            val errorResponse = Gson().fromJson(jsonErrorBody, ErrorResponse::class.java)
            errorResponse.error
        } catch (e: JsonSyntaxException) {
            LightningConstants.ERROR.JSON_ERROR + e.message
        }
    }

    suspend fun <T> execute(call: suspend () -> Response<T>, listener: APIListener<T>) {
        listener.onLoading(true)
        try {
            val response = withContext(Dispatchers.IO) {
                call()
            }

            if (response.isSuccessful) {
                response.body()?.let { listener.onSuccess(it) }
                    ?: listener.onError(LightningConstants.ERROR.EMPTY_RESPONSE)
            } else {
                val errorBody =
                    response.errorBody()?.string() ?: LightningConstants.ERROR.UNKNOWN_ERROR
                listener.onError(failResponse(errorBody))
            }
        } catch (e: HttpException) {
            listener.onError(LightningConstants.ERROR.HTTP_ERROR + e.message())
        } catch (e: Exception) {
            listener.onError(LightningConstants.ERROR.ERROR_UNEXPECTED)
        } finally {
            listener.onLoading(false)
        }
    }


}