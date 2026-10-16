package com.rafaelcosta.carteirinhadigital2devest_b.feature.aluno.unidadecurriculares.data.repository

import com.rafaelcosta.carteirinhadigital2devest_b.feature.aluno.unidadecurriculares.data.remote.service.UnidadeCurricularApi
import com.rafaelcosta.carteirinhadigital2devest_b.feature.aluno.unidadecurriculares.domain.model.UnidadeCurricular
import com.rafaelcosta.carteirinhadigital2devest_b.feature.aluno.unidadecurriculares.domain.repository.UnidadeCurricularRepository
import okio.IOException
import retrofit2.HttpException

class ApiUnidadeCurricularRepositoryImpl(
    private val api: com.rafaelcosta.carteirinhadigital2devest_b.feature.aluno.unidadecurriculares.data.remote.service.UnidadeCurricularApi
): com.rafaelcosta.carteirinhadigital2devest_b.feature.aluno.unidadecurriculares.domain.repository.UnidadeCurricularRepository {
    override suspend fun listarUnidadesCurriculares(): Result<List<com.rafaelcosta.carteirinhadigital2devest_b.feature.aluno.unidadecurriculares.domain.model.UnidadeCurricular>> {
       return runCatching {
            api.listarUnidadesCurriculares().map {
                it.toDomain()
            }
       }.recoverCatching { throwable ->
           throw when(throwable){
               is HttpException ->{
                   if (throwable.code()==401){
                       IllegalStateException("Sua sessão expirou. Faça logn novamente")
                   }else{
                       IllegalStateException("Erro ao carregar unidades curriculares (${throwable.code()})")
                   }
               }
               is IOException ->
                   IllegalStateException("Não foi possivel conectar na API")
               else ->
                   IllegalStateException(throwable.message ?: "Erro ao carregar unidades curriculares")
           }

       }

    }

}