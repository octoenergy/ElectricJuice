//
//  OnboardingControllerView.swift
//  iosApp
//
//  Created by Yogesh N Ramsorrrun on 02/09/2020.
//  Copyright © 2020 orgName. All rights reserved.
//

import SwiftUI

struct OnboardingControllerView: View {
    @State private var currentPage = 0
    var body: some View {
        OnboardingContainerView(pageCount: 0, currentIndex: $currentPage) {
            OnboardingPageView(title: "Welcome to Electric Juice", description: "Find, charge and pay in one place, with our ever-expanding network of charge points across the UK.", imageName: "onboarding_location", pageIndex: 0)
            OnboardingPageView(title: "Charge with one tap", description: "Start charging in a flash, with a single tap in the app or with your Electric Juice card.", imageName: "onboarding_charge", pageIndex: 1)
            OnboardingPageView(title: "Pay your way", description:  "Pay with any card, or link your Octopus Energy account to have charges magically appear on your energy bill.", imageName: "onboarding_payment", pageIndex: 2)
        }
    }
}

struct OnboardingControllerView_Previews: PreviewProvider {
    static var previews: some View {
        OnboardingControllerView()
    }
}
