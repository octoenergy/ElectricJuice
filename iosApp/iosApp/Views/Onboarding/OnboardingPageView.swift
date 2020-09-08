//
//  OnboardingPageView.swift
//  iosApp
//
//  Created by Yogesh N Ramsorrrun on 02/09/2020.
//  Copyright © 2020 orgName. All rights reserved.
//

import SwiftUI

struct OnboardingPageView: View {
    
    let colour1 = Color(red: 0.106, green: 0.024, blue: 0.227)
    let gradient = Gradient(colors: [.black, .pink])
    @State var title: String
    @State var subtitle: String
    @State var imageName: String
    let pageIndex: Int
    
    var body: some View {
        VStack(alignment: .center) {
            HStack(spacing: 0) {
                if pageIndex == 0 { Spacer() }
                if pageIndex == 1 {
                    Image(imageName)
                        .resizable()
                        .aspectRatio(contentMode: .fit)
                        .offset(CGSize(width: 0, height: -25))
                } else { Image(imageName) }
                if pageIndex == 2 { Spacer() }
            }
            Text(title)
                .font(.custom("GothamMedium", size: 20))
                .padding()
                .foregroundColor(.white)
            Text(subtitle)
                .font(.custom("Gotham", size: 14))
                .padding()
                .foregroundColor(.white)
        }
        .background(Color.clear)
    }
}

struct OnboardingPageView_Previews: PreviewProvider {
    static var previews: some View {
        OnboardingPageView(title: "Charge with one tap", subtitle: "Start charging in a flash, with a single tap in the app or with your Electric Juice card.", imageName: "onboarding_charge", pageIndex: 1)
            .background(Color.electricPurple)
        
        
    }
}
