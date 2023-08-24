/**
 * Copyright [2023] [RAFAEL ALCOCER CALDERA]
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package rafael.alcocer.caldera.kafka.swing.utils;

import java.awt.Dimension;
import java.awt.Toolkit;

public final class SizeUitls {
    
    private SizeUitls() {
    }

    public static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int X_10 = 10;
    public static final int X_100 = 100;
    public static final int X_150 = 150;
    public static final int X_200 = 200;
    public static final int X_250 = 250;
    public static final int X_300 = 300;
    public static final int Y_10 = 10;
    public static final int Y_50 = 50;
    public static final int Y_100 = 100;
    public static final int Y_150 = 150;
    public static final int Y_200 = 200;
    public static final int Y_250 = 250;
    public static final int Y_300 = 300;
    public static final int Y_500 = 500;
    public static final int Y_550 = 550;
    public static final int Y_600 = 600;
    public static final int Y_650 = 650;
    public static final int WIDTH_100 = 100;
    public static final int WIDTH_150 = 150;
    public static final int WIDTH_200 = 200;
    public static final int WIDTH_300 = 300;
    public static final int WIDTH_500 = 500;
    public static final int HEIGHT_40 = 40;
    public static final int HEIGHT_200 = 200;
    public static final int HEIGHT_300 = 300;
    public static final int HEIGHT_500 = 500;
    public static final int HALF_SCREEN_WIDTH = screenSize.width / 2;
    public static final int HALF_SCREEN_WIDTH_LESS_50 = HALF_SCREEN_WIDTH - 50;
    public static final int HALF_SCREEN_WIDTH_LESS_100 = HALF_SCREEN_WIDTH - 100;
    public static final int HALF_SCREEN_HEIGHT = screenSize.height / 2;
    public static final int HALF_SCREEN_HEIGHT_LESS_100 = HALF_SCREEN_HEIGHT - 100;
    public static final int HALF_SCREEN_HEIGHT_PLUS_100 = HALF_SCREEN_HEIGHT + 100;
}
