//
//  OnboardingButton.swift
//  iosApp
//
//  Created by Yogesh N Ramsorrrun on 03/09/2020.
//  Copyright © 2020 orgName. All rights reserved.
//

import SwiftUI

struct OnboardingButton: View {
    enum ButtonType {
        case arrow
        case text
        
        func imageNames() -> (normal: String, focussed: String) {
            switch self {
            case .arrow:
                return (normal: "onboarding_button", focussed: "onboarding_button_focus")
            default:
                return (normal: "onboarding_text_button", focussed: "onboarding_text_button_focus")
            }
        }
    }
    
    @State private var isPressed = false
    @Binding var buttonType: ButtonType
    private var image: Image {
        isPressed ? Image(buttonType.imageNames().focussed) :  Image(buttonType.imageNames().normal)
    }
    
    let action: () -> Void
    var body: some View {
        Button(action: {
            self.action()
        }) {
            image
            .gesture(DragGesture(minimumDistance: 0.0)
                 .onChanged { _ in self.isPressed = true }
                 .onEnded { _ in self.isPressed = false })
        }
        .buttonStyle(PlainButtonStyle())
 
        
    }
}

struct OnboardingButton_Previews: PreviewProvider {
    static var previews: some View {
        OnboardingButton(buttonType: .mock(.text)) {
            
        }
    }
}
