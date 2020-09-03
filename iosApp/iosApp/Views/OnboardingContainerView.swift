//
//  OnboardingContainerView.swift
//  iosApp
//
//  Created by Yogesh N Ramsorrrun on 01/09/2020.
//  Copyright © 2020 orgName. All rights reserved.
//

import SwiftUI
import shared



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
                }
                .onEnded { value in
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
        OnboardingContainerView(pageCount: 3, currentIndex: .mock(0)) {
            OnboardingPageView(title: "Welcome to Electric Juice", description: "Find, charge and pay in one place, with our ever-expanding network of charge points across the UK.", imageName: "onboarding_location", pageIndex: 0)
            OnboardingPageView(title: "Charge with one tap", description: "Start charging in a flash, with a single tap in the app or with your Electric Juice card.", imageName: "onboarding_charge", pageIndex: 1)
            OnboardingPageView(title: "Pay your way", description:  "Pay with any card, or link your Octopus Energy account to have charges magically appear on your energy bill.", imageName: "onboarding_payment", pageIndex: 2)
        }
    }
}














///Experimental Views and Example code

struct PontentView: View {
    @State private var alignment: HorizontalAlignment = .leading
    
    var body: some View {
        VStack {
            Spacer()
            
            VStack(alignment: alignment) {
                LabelView(title: "Athos", color: .green)
                    .alignmentGuide(.leading, computeValue: { _ in 30 } )
                    .alignmentGuide(HorizontalAlignment.center, computeValue: { _ in 30 } )
                    .alignmentGuide(.trailing, computeValue: { _ in 90 } )
                
                LabelView(title: "Porthos", color: .red)
                    .alignmentGuide(.leading, computeValue: { _ in 90 } )
                    .alignmentGuide(HorizontalAlignment.center, computeValue: { _ in 30 } )
                    .alignmentGuide(.trailing, computeValue: { _ in 30 } )
                
                LabelView(title: "Aramis", color: .blue) // use implicit guide
                
            }
            
            Spacer()
            HStack {
                Button("leading") { withAnimation(.easeInOut(duration: 2)) { self.alignment = .leading }}
                Button("center") { withAnimation(.easeInOut(duration: 2)) { self.alignment = .center }}
                Button("trailing") { withAnimation(.easeInOut(duration: 2)) { self.alignment = .trailing }}
            }
        }
    }
}

struct LabelView: View {
    let title: String
    let color: Color
    
    var body: some View {
        Text(title)
            .font(.title)
            .padding(10)
            .frame(width: 200, height: 40)
            .background(RoundedRectangle(cornerRadius: 8)
                .fill(LinearGradient(gradient: Gradient(colors: [color, .black]), startPoint: UnitPoint(x: 0, y: 0), endPoint: UnitPoint(x: 2, y: 1))))
    }
}
