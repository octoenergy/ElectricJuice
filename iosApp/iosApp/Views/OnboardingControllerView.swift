//
//  OnboardingControllerView.swift
//  iosApp
//
//  Created by Yogesh N Ramsorrrun on 02/09/2020.
//  Copyright © 2020 orgName. All rights reserved.
//

import SwiftUI
import shared

struct OnboardingControllerView: View {
    @State private var isGetStartedButtonVisible = false
    @State private var isSkipButtonVisible = true
    @State private var currentPageNumber = 0
    @State private var onboardingPages = [OnboardingPage]()
    
    var viewModel: OnboardingViewModel!
    
    var body: some View {
        NavigationView {
            OnboardingContainerView(pageCount: 3, currentIndex: $currentPageNumber) {
                OnboardingPageView(title: "Welcome to Electric Juice", description: "Find, charge and pay in one place, with our ever-expanding network of charge points across the UK.", imageName: "onboarding_location", pageIndex: 0)
                OnboardingPageView(title: "Charge with one tap", description: "Start charging in a flash, with a single tap in the app or with your Electric Juice card.", imageName: "onboarding_charge", pageIndex: 1)
                OnboardingPageView(title: "Pay your way", description:  "Pay with any card, or link your Octopus Energy account to have charges magically appear on your energy bill.", imageName: "onboarding_payment", pageIndex: 2)
            }
            .navigationBarItems(trailing:
                Button(action: {
                    self.viewModel.onAction(action: OnboardingViewModel.UiActionSkipClicked())
                }, label: {
                    Text("Skip")
                })
            )
                .foregroundColor(.white)
        }
        .onAppear {
//            self.setupViewStateObservers()
        }
    }
    
    private func setupViewStateObservers() {
        viewModel.nativeViewStateStream().watch { newState in
             guard let newState = newState  else { return }
            self.isGetStartedButtonVisible = newState.isGetStartedButtonVisible
            self.isSkipButtonVisible = newState.isSkipButtonVisible
            self.currentPageNumber = Int(newState.currentPageNumber) //Comes in as Int32
            self.onboardingPages = newState.onboardingPage
        }
    }
}

struct OnboardingControllerView_Previews: PreviewProvider {
    static var previews: some View {
        OnboardingControllerView()
        
    }
}


protocol ViewControllable {
    associatedtype ViewModel
    
    var viewModel: ViewModel { get }
    func setupViewStateObservers()
    
}
