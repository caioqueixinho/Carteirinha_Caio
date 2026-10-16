package com.rafaelcosta.carteirinhadigital2devest_b.app.di

import com.rafaelcosta.carteirinhadigital2devest_b.core.auth.AuthTokenStore
import com.rafaelcosta.carteirinhadigital2devest_b.feature.login.data.repository.LoginRepository
import com.rafaelcosta.carteirinhadigital2devest_b.feature.aluno.unidadecurriculares.domain.repository.UnidadeCurricularRepository

interface AppContainer {

    val loginRepository: LoginRepository

    val unidadeCurricularRepository: com.rafaelcosta.carteirinhadigital2devest_b.feature.aluno.unidadecurriculares.domain.repository.UnidadeCurricularRepository

    val authTokenStore: AuthTokenStore
}