//
//  OnboardingImageResource.swift
//  iosApp
//
//  Created by Yogesh N Ramsorrrun on 08/09/2020.
//  Copyright © 2020 orgName. All rights reserved.
//

import Foundation

enum OnboardingImageResource: String {
    case SharedOnboardingImageOnboardingPageOne
    case SharedOnboardingImageOnboardingPageTwo
    case SharedOnboardingImageOnboardingPageThree
    
    var imageString: String {
        switch self {
        case .SharedOnboardingImageOnboardingPageOne:
            return "onboarding_location"
        case .SharedOnboardingImageOnboardingPageTwo:
            return "onboarding_charge"
        case .SharedOnboardingImageOnboardingPageThree:
            return "onboarding_payment"
        }
    }
}
