//
//  JuicyImage+Additions.swift
//  iosApp
//
//  Created by Yogesh N Ramsorrrun on 08/09/2020.
//  Copyright © 2020 orgName. All rights reserved.
//

import Foundation
import shared

extension JuicyImage {
    func map() -> String {
        if let onboardingImage = self as? OnboardingImage { return onboardingImage.mapOnboardingImage() }
        print("Class not matched")
        return ""
    }
}

extension OnboardingImage {
    func mapOnboardingImage() -> String {
        let string = String(describing: type(of: self))
         guard let resource = OnboardingImageResource(rawValue: string) else {
            print("Enum case not matched")
            return ""
        }
        return resource.imageString
    }
}
