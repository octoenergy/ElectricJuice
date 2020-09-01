package com.octopus.electricjuice.githubrepositories

import com.octopus.electricjuice.common.ui.MotherFragment
import com.octopus.electricjuice.common.viewmodels.LifecycleReceiver

class DetailsFragment : MotherFragment() {

    override fun getLifecycleReceivers(): List<LifecycleReceiver> {
        return emptyList()
    }

//    @Inject
//    lateinit var detailsViewModel: DetailsViewModel
//
//    override fun getLifecycleReceivers(): List<LifecycleReceiver> {
//        return listOf(detailsViewModel)
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        return inflater.inflate(R.layout.fragment_details, container, false)
//    }
//
//    override fun onViewCreated(
//        view: View,
//        savedInstanceState: Bundle?
//    ) {
//        super.onViewCreated(view, savedInstanceState)
//        a_details_btn.setOnClickListener { detailsViewModel.onAction(DetailsViewModel.UiAction.RepositoryClicked) }
//    }
//
//    override fun onStart() {
//        super.onStart()
//        detailsViewModel.viewStateStream()
//            .onEach {
//                requireAppCompatActivity().supportActionBar?.title = it.toolbarTitle
//                a_details_txt.text = it.urlAddress
//            }.launchIn(coroutineScope)
//    }
}
