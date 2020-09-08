//
//  JuicyImages.swift
//  iosApp
//
//  Created by Yogesh N Ramsorrrun on 08/09/2020.
//  Copyright © 2020 orgName. All rights reserved.
//

import Foundation
import shared
import SwiftUI

enum OnboardingImages: NSString {
    case onboardingImage1 = "onboarding_location"
    case onboardingImage2 = "onboarding_charge"
    case onboardingImage3 = "onboarding_payment"
    
    func juicyImage() -> JuicyImage {
        return self.rawValue
    }
}

extension NSString: JuicyImage {}


struct ExampleImage: View {
    var body: some View {
        Image(OnboardingImages.onboardingImage1.juicyImage() as! String)
    }
}

struct JuicyImages_Previews: PreviewProvider {
    static var previews: some View {
        ExampleImage()
    }
}
