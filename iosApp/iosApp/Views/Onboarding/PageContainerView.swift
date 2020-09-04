//
//  PageContainerView.swift
//  iosApp
//
//  Created by Yogesh N Ramsorrrun on 04/09/2020.
//  Copyright © 2020 orgName. All rights reserved.
//

import SwiftUI
import shared

//Swipeable paged container
struct PageContainerView<Content: View>: View {
    let pageCount: Int
    let content: Content
    @Binding var currentIndex: Int
    @GestureState private var translation: CGFloat = 0
    
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
extension NSString: JuicyImage {}


struct PageContainerView_Previews: PreviewProvider {
    static var onboardingPages: [OnboardingPage] = [OnboardingPage(image: NSString("onboarding_location"), title: "Welcome to Electric Juice", subtitle: "Find, charge and pay in one place, with our ever-expanding network of charge points across the UK."),
                                                    OnboardingPage(image: NSString("onboarding_charge"), title: "Charge with one tap", subtitle: "Start charging in a flash, with a single tap in the app or with your Electric Juice card."),
                                                    OnboardingPage(image: NSString("onboarding_payment"), title: "Pay your way", subtitle: "Pay with any card, or link your Octopus Energy account to have charges magically appear on your energy bill.")]
    
    static var previews: some View {
        PageContainerView(pageCount: 3, currentIndex: .mock(0), content: {
            ForEach(0..<onboardingPages.count) { index in
                OnboardingPageView(title: PageContainerView_Previews.onboardingPages[index].title,
                                   subtitle: PageContainerView_Previews.onboardingPages[index].subtitle, //Change once description is fixed
                    imageName: PageContainerView_Previews.onboardingPages[index].image as! String,
                    pageIndex: index)
            }
        })
    }
}


