package com.octopus.electricjuice.onboarding

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter

class OnboardingPagerAdapter(
    private val onboardingPages: List<OnboardingPage>,
    activity: AppCompatActivity,
) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int {
        return onboardingPages.size
    }

    override fun createFragment(position: Int): Fragment {
        val fragment = OnboardingPageFragment.instance()
        fragment.onboardingPage = onboardingPages[position]
        return fragment
    }

//    override fun getCount(): Int {
//        return 3
//    }
//
//    override fun getItem(position: Int): Fragment {
//        return OnboardingPageFragment.instance()
//    }
}