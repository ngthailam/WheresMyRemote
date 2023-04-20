package vn.thailam.wheresmyremote.domain.usecase

import kotlinx.coroutines.flow.Flow

abstract class BaseFlowUseCase<I, O> {
    abstract operator fun invoke(input: I): Flow<O>
}

abstract class BaseFlowUseCaseNoInput<O> : BaseFlowUseCase<Unit, O>()

abstract class BaseSuspendUseCase<I, O> {
    abstract suspend operator fun invoke(input: I): O
}

abstract class BaseSuspendUseCaseNoOutput<I>: BaseSuspendUseCase<I, Unit>()
