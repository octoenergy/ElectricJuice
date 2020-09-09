//
//  OnboardingPageView.swift
//  iosApp
//
//  Created by Yogesh N Ramsorrrun on 02/09/2020.
//  Copyright © 2020 orgName. All rights reserved.
//

import SwiftUI
import shared

struct OnboardingPageView: View {
    
    let colour1 = Color(red: 0.106, green: 0.024, blue: 0.227)
    let gradient = Gradient(colors: [.black, .pink])
    @State var title: String
    @State var subtitle: String
    @State var image: JuicyImage
    let pageIndex: Int
    
    var body: some View {
        VStack {
            HStack(spacing: 0) {
                if pageIndex == 0 { Spacer() }
                if pageIndex == 1 {
                    Image(image.map())
                        .resizable()
                        .aspectRatio(contentMode: .fit)
                } else { Image(image.map()) }
                if pageIndex == 2 { Spacer() }
            }
            .padding(.bottom, 96)
            VStack {
                JuicyTitleText(text: title)
                    .padding(.bottom, 16)
                JuicySubtitleText(text: subtitle)
                    .padding(.horizontal, 32)
                    .padding(.vertical, 8)
                    .frame(width: UIScreen.screenWidth, height: 64, alignment: .top)
                Spacer()
                    .frame(width: UIScreen.screenWidth, height: 180, alignment: .top)
            }
        }
        .frame(width: UIScreen.screenWidth,
               height: UIScreen.screenHeight,
               alignment: .bottom)
    }
}

struct OnboardingPageView_Previews: PreviewProvider {
    static var previews: some View {
        OnboardingPageView(title: "Charge with one tap", subtitle: "Start charging in a flash, with a single tap in the app or with your Electric Juice card.", image: OnboardingImage.OnboardingPageTwo(), pageIndex: 1)
            .background(OnboardingGradientView())
        
        
        
    }
}
