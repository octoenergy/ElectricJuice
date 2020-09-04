//
//  OnboardingContainerView.swift
//  iosApp
//
//  Created by Yogesh N Ramsorrrun on 01/09/2020.
//  Copyright © 2020 orgName. All rights reserved.
//

import SwiftUI
import shared

struct OnboardingContainerView: View {

    @State var currentIndex: Int = 0 { didSet { buttonType = currentIndex == 2 ? .text : .arrow } }
    @State private var buttonType: OnboardingButton.ButtonType = .arrow
    @State private var isGetStartedButtonVisible: Bool = false
    @State private var isSkipButtonVisible: Bool = true
    @State private var onboardingPages: [OnboardingPage] = [OnboardingPage(image: OnboardingImage.OnboardingPageOne(), title: "Welcome to Electric Juice", subtitle: "Find, charge and pay in one place, with our ever-expanding network of charge points across the UK."),
                                                            OnboardingPage(image: OnboardingImage.OnboardingPageOne(), title: "Charge with one tap", subtitle: "Start charging in a flash, with a single tap in the app or with your Electric Juice card."),
                                                            OnboardingPage(image: OnboardingImage.OnboardingPageOne(), title: "Pay your way", subtitle: "Pay with any card, or link your Octopus Energy account to have charges magically appear on your energy bill.")]
    
    //TODO:- Dummy Data
    private var onboardingImages = ["onboarding_location",
                                    "onboarding_charge",
                                    "onboarding_payment"]
    

    var viewModel: OnboardingViewModel!
    
    var body: some View {
        NavigationView {
            ZStack {
                PageContainerView(pageCount: onboardingPages.count, currentIndex: $currentIndex) {
                    ForEach(0..<onboardingPages.count) { index in
                        OnboardingPageView(title: self.onboardingPages[index].title,
                                           subtitle: self.onboardingPages[index].subtitle, //Change once description is fixed
                            imageName: self.onboardingImages[index], //change once juicy image works
                            pageIndex: index)
                    }
                }
                VStack {
                    Spacer()
                    HStack {
                        PageControlView(index: $currentIndex, maxIndex: onboardingPages.count - 1)
                        Spacer()
                        OnboardingButton(buttonType: $buttonType, action: {
                            self.viewModel.onAction(action: OnboardingViewModel.UiActionNextClicked())
                        })
                            .padding()
                    }
                }
            }
        }
        .navigationBarItems(trailing:
            Button(action: {
                self.viewModel.onAction(action: OnboardingViewModel.UiActionSkipClicked())
            }, label: {
                Text("Skip")
            })
        )
            .foregroundColor(.white)
            .onAppear {
//                    self.setupViewStateObservers()
        }
    }
    
    private func setupViewStateObservers() {
        viewModel.nativeViewStateStream().watch { newState in
            guard let newState = newState  else { return }
            self.isGetStartedButtonVisible = newState.isGetStartedButtonVisible
            self.isSkipButtonVisible = newState.isSkipButtonVisible
            self.currentIndex = Int(newState.currentPageNumber) //Comes in as Int32
            self.onboardingPages = newState.onboardingPages
        }
    }
}


struct OnboardingContainerView_Previews: PreviewProvider {
    static var previews: some View {
        OnboardingContainerView()
    }
}
