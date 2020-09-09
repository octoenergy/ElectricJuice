//
//  JuicySubtitleText.swift
//  iosApp
//
//  Created by Yogesh N Ramsorrrun on 09/09/2020.
//  Copyright © 2020 orgName. All rights reserved.
//

import Foundation
import SwiftUI




struct JuicyTitleText: View {
    let text: String
    let font = UIFont(name: "GothamMedium", size: 20)!
    let lineHeight: CGFloat = 20
    var body: some View {
        Text(text)
            .font(.custom("GothamMedium", size: 20))
            .kerning(0.25)
            .lineSpacing(lineHeight - font.lineHeight)
            .padding(.vertical, (lineHeight - font.lineHeight) / 2)
            .multilineTextAlignment(.center)
            .foregroundColor(.white)
    }
}


struct JuicySubtitleText: View {
     var text: String
    let font = UIFont(name: "Gotham", size: 14)!
    let lineHeight: CGFloat = 20
    var body: some View {
        Text(text)
            .font(.custom("Gotham", size: 14))
            .kerning(0.25)
            .lineSpacing(lineHeight - font.lineHeight)
            .padding(.vertical, (lineHeight - font.lineHeight) / 2)
            .multilineTextAlignment(.center)
            .foregroundColor(.white)
    }
}


struct JuicySubtitleText_Previews: PreviewProvider {
    static var previews: some View {
        VStack {
            JuicyTitleText(text: "Charge with one tap")
                .padding()
            JuicySubtitleText(text: "Start charging in a flash, with a single tap in the app or with your Electric Juice card.")
                .padding()
        }
        .padding()
            .background(Color.black)
    }
}
