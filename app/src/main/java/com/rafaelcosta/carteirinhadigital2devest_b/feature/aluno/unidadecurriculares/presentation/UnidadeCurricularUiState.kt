package com.rafaelcosta.carteirinhadigital2devest_b.feature.aluno.unidadecurriculares.presentation

import com.rafaelcosta.carteirinhadigital2devest_b.feature.aluno.unidadecurriculares.domain.model.UnidadeCurricular

data class UnidadeCurricularUiState(
    val listaUnidadesCurriculares: List<com.rafaelcosta.carteirinhadigital2devest_b.feature.aluno.unidadecurriculares.domain.model.UnidadeCurricular> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
) {
}