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
    @State var currentIndex: Int = 0
    @State private var buttonType: OnboardingButton.ButtonType = .arrow
    @State private var isGetStartedButtonVisible: Bool = false { didSet { buttonType = currentIndex == 2 ? .text : .arrow } }
    @State private var isSkipButtonVisible: Bool = true
    @State private var onboardingPages: [OnboardingPage] = [OnboardingPage(image: OnboardingImage.OnboardingPageOne(), title: "Welcome to Electric Juice", subtitle: "Find, charge and pay in one place, with our ever-expanding network of charge points across the UK."),
                                                            OnboardingPage(image: OnboardingImage.OnboardingPageTwo(), title: "Charge with one tap", subtitle: "Start charging in a flash, with a single tap in the app or with your Electric Juice card."),
                                                            OnboardingPage(image: OnboardingImage.OnboardingPageThree(), title: "Pay your way", subtitle: "Pay with any card, or link your Octopus Energy account to have charges magically appear on your energy bill.")]
    

    var viewModel: OnboardingViewModel!
    
    var body: some View {
        NavigationView {
            ZStack {
                VStack {
                    PageContainerView(pageCount: onboardingPages.count, currentIndex: $currentIndex) {
                        ForEach(0..<onboardingPages.count) { index in
                            OnboardingPageView(title: self.onboardingPages[index].title,
                                               subtitle: self.onboardingPages[index].subtitle, //Change once description is fixed
                                image: self.onboardingPages[index].image, //change once juicy image works
                                pageIndex: index)
                        }
                    }
                    Spacer(minLength: OnboardingGradientView.whiteGradientSpacing) //To allow
                }
                VStack {
                    Spacer()
                    HStack {
                        PageControlView(index: $currentIndex, maxIndex: onboardingPages.count - 1)
                            .padding(.leading, 32)
                        Spacer()
                        OnboardingButton(buttonType: $buttonType, action: {
                            if self.isGetStartedButtonVisible {
                                 self.viewModel.onAction(action: OnboardingViewModel.UiActionGetStartedClicked())
                            } else {
                                self.viewModel.onAction(action: OnboardingViewModel.UiActionNextClicked())
                            }
                        })
                            .padding(.trailing, 32)
                    }
                }
            }
            .background(
             OnboardingGradientView())
        }
        .navigationBarItems(trailing:
            Button(action: {
                self.viewModel.onAction(action: OnboardingViewModel.UiActionSkipClicked())
            }, label: {
                Text("Skip")
            })
        )
            .background(Color.clear)
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
