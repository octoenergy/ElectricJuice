//
//  Resources.swift
//  iosApp
//
//  Created by Yogesh N Ramsorrrun on 04/09/2020.
//  Copyright © 2020 orgName. All rights reserved.
//

import Foundation
import shared

class ImageAndStringProvider: ResourceProvider {
    func getString(juicyString: JuicyString) -> String {
        return "Strings!" 
    }
}
