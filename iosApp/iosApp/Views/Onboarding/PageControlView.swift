//
//  PageControl.swift
//  iosApp
//
//  Created by Yogesh N Ramsorrrun on 03/09/2020.
//  Copyright © 2020 orgName. All rights reserved.
//

import SwiftUI

struct PageControlView: View {
    @Binding var index: Int
    let maxIndex: Int

    var body: some View {
        HStack(spacing: 8) {
            ForEach(0...maxIndex, id: \.self) { index in
                Circle()
                    .fill(index == self.index ? Color.white : Color.gray)
                    .frame(width: 8, height: 8)
            }
        }
        .padding(15)
    }
}

struct PageControl_Previews: PreviewProvider {
    static var previews: some View {
        PageControlView(index: .mock(1), maxIndex: 4)
            .background(Color.blue)
    }
}
