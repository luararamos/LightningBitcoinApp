package com.luaramartins.lightningbitcoinapp.common

class LightningConstants private constructor(){
    object ERROR{
        const val UNKNOWN_ERROR = "Erro desconhecido"
        const val SERVICE_ERROR= "Erro servidor"
        const val HTTP_ERROR= "Erro HTTP "
        const val JSON_ERROR= "Erro Json "
        const val EMPTY_RESPONSE= "Resposta vazia"
        const val ERROR_UNEXPECTED= "Um erro inesperado ocorreu. Tente novamente mais tarde."
    }

    object HTTP {
        const val SUCCESS = 200
    }
}