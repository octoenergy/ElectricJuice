//
//  JuicyColours.swift
//  iosApp
//
//  Created by Yogesh N Ramsorrrun on 07/09/2020.
//  Copyright © 2020 orgName. All rights reserved.
//

import SwiftUI

protocol JuicyColours {
    static var electricGreen: Color { get }
    static var electricPink: Color { get }
    static var electricPurple: Color { get }
    static var electricBlack: Color { get }
    static var sunsetElectric: Color { get }
    static var darkGrey: Color { get }
    static var paperGrey: Color { get }
    static var silverGrey: Color { get }
}

extension JuicyColours {
    static var electricGreen: Color { Color("electric_green") }
    static var electricPink: Color { Color("electric_pink") }
    static var electricPurple:  Color { Color("electric_purple") }
    static var electricBlack: Color { Color("electric_black") }
    static var sunsetElectric: Color { Color("sunset_electric") }
    static var darkGrey: Color { Color("dark_grey") }
    static var paperGrey: Color { Color("paper_grey") }
    static var silverGrey: Color { Color("silver_grey") }
}

extension Color: JuicyColours {}
