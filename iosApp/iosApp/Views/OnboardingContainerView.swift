//
//  OnboardingContainerView.swift
//  iosApp
//
//  Created by Yogesh N Ramsorrrun on 01/09/2020.
//  Copyright © 2020 orgName. All rights reserved.
//

import SwiftUI

struct OnboardingContainerView<Content: View>: View {
    let pageCount: Int
    @Binding var currentIndex: Int
    @GestureState private var translation: CGFloat = 0
    let content: Content
    
    init(pageCount: Int, currentIndex: Binding<Int>, @ViewBuilder content: () -> Content) {
        self.pageCount = pageCount
        self._currentIndex = currentIndex
        self.content = content()
    }
    
    var body: some View {
        GeometryReader { geometry in
            HStack(spacing: 0) {
                self.content.frame(width: geometry.size.width)
            }
            .frame(width: geometry.size.width, alignment: .leading)
            .offset(x: -CGFloat(self.currentIndex) * geometry.size.width)
            .offset(x: self.translation)
            .animation(.interactiveSpring())
            .gesture(
                DragGesture().updating(self.$translation) { value, state, _ in
                    state = value.translation.width
                }.onEnded { value in
                    let offset = value.translation.width / geometry.size.width
                    let newIndex = (CGFloat(self.currentIndex) - offset).rounded()
                    self.currentIndex = min(max(Int(newIndex), 0), self.pageCount - 1)
                }
            )
        }
    }

}

struct OnboardingContainerView_Previews: PreviewProvider {
    static var previews: some View {
        OnboardingView()
    }
}

struct ContentoView: View {
    @State private var currentPage = 0

    var body: some View {
        OnboardingContainerView(pageCount: 3, currentIndex: $currentPage) {
            Color.blue
            Color.red
            Color.green
        }
    }
}

struct OnboardingView: View {

    let colour1 = Color(red: 0.106, green: 0.024, blue: 0.227)
    let gradient = Gradient(colors: [.black, .pink])
    
    var body: some View {
        LinearGradient(gradient: Gradient(colors: [colour1, colour1, colour1, colour1, colour1, colour1, .white]), startPoint: UnitPoint(x: 0.5,y: 0), endPoint: UnitPoint(x: 0.5, y: 1))
            .edgesIgnoringSafeArea(.all)
            .overlay(
                VStack(alignment: .center) {
                    Image("onboarding_location")
                        .alignmentGuide(.trailing, computeValue: { d in d[explicit: .trailing]! })
//                        .padding()
                
                }
        )

        
        
        
    }
    
}
