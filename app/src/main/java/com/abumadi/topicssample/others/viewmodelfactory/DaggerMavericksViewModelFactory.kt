package com.abumadi.topicssample.others.viewmodelfactory

import com.abumadi.topicssample.others.TopicsListApp
import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
import com.airbnb.mvrx.ViewModelContext

class DaggerMavericksViewModelFactory<VM : MavericksViewModel<S>, S : MavericksState>(
    private val viewModelClass: Class<VM>
) : MavericksViewModelFactory<VM, S> {

    override fun create(viewModelContext: ViewModelContext, state: S): VM {
        val viewModelFactoryMap = viewModelContext.app<TopicsListApp>().appComponent.viewModelFactories()
        val viewModelFactory = viewModelFactoryMap[viewModelClass]

        @Suppress("UNCHECKED_CAST")
        val castedViewModelFactory = viewModelFactory as? AssistedViewModelFactory<VM, S>
        val viewModel = castedViewModelFactory?.create(state)
        return viewModel as VM
    }
}
//reified : To access the information about the type of class, we use a keyword called reified in Kotlin
inline fun <reified VM : MavericksViewModel<S>, S : MavericksState> daggerMavericksViewModelFactory() = DaggerMavericksViewModelFactory<VM, S>(VM::class.java)
