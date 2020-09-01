package com.octopus.electricjuice.githubrepositories

import com.octopus.electricjuice.common.ui.MotherFragment
import com.octopus.electricjuice.common.viewmodels.LifecycleReceiver

class MainFragment : MotherFragment() {

    override fun getLifecycleReceivers(): List<LifecycleReceiver> {
        return emptyList()
    }

    companion object {
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }
//
//    @Inject
//    lateinit var mainViewModel: MainViewModel
//
//    private var mainAdapter: MainAdapter? = null
//
//    override fun getLifecycleReceivers(): List<LifecycleReceiver> {
//        return listOf(mainViewModel)
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        return inflater.inflate(R.layout.fragment_main, container, false)
//    }
//
//    override fun onViewCreated(
//        view: View,
//        savedInstanceState: Bundle?
//    ) {
//        super.onViewCreated(view, savedInstanceState)
//        mainAdapter =
//            MainAdapter { mainViewModel.onAction(MainViewModel.UiAction.RepositoryClicked(it)) }
//        a_main_recycler.adapter = mainAdapter
//        a_main_recycler.layoutManager = LinearLayoutManager(requireActivity())
//        a_main_recycler.addItemDecoration(
//            DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
//        )
//        a_main_btn.setOnClickListener { mainViewModel.onAction(MainViewModel.UiAction.LoadReposClicked) }
//    }
//
//    override fun onStart() {
//        super.onStart()
//        mainViewModel.viewStateStream()
//            .onEach {
//                if (it.loadingIsVisible) {
//                    a_main_progress.visibility = View.VISIBLE
//                } else {
//                    a_main_progress.visibility = View.INVISIBLE
//                }
//                mainAdapter?.addAll(it.results)
//            }.launchIn(coroutineScope)
//    }
}
