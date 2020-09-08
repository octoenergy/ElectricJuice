//
//  OnboaringGradientView.swift
//  iosApp
//
//  Created by Yogesh N Ramsorrrun on 07/09/2020.
//  Copyright © 2020 orgName. All rights reserved.
//

import SwiftUI

struct OnboardingGradientView: View {

    let requiredHeight: CGFloat = 155.0 //This is approximately where we want the white to start so ##pts from the bottom up 
    private func calculateGradient() -> Gradient {
        var ratio: CGFloat { (UIScreen.screenHeight - requiredHeight)/UIScreen.screenHeight }
        return Gradient(stops: [.init(color: .electricPurple, location: ratio),
                                         .init(color: .white, location: 1)])
    }
    var body: some View {
        LinearGradient(gradient: calculateGradient(), startPoint: UnitPoint(x: 0.5, y: 0.25), endPoint: UnitPoint(x: 0.5, y: 1))
            .edgesIgnoringSafeArea(.top)
    }
}

struct OnboardingGradientView_Previews: PreviewProvider {
    static var previews: some View {
        OnboardingGradientView()
    }
}
