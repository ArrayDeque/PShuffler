/*
 * Copyright 2016 Frank Jennings
 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 
 * http://www.apache.org/licenses/LICENSE-2.0
 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.pshuffler.encode;

import java.util.ArrayDeque;

/**
 *
 * @author Frank Jennings
 */
public class Encoder {
    
    public static String encode(String text){
        
        //Get the chars that must be shuffled
        char[] textArray = text.toCharArray();

        ArrayDeque<String> deck = new ArrayDeque();

        //Encode
        boolean isFront = true;
        for (int i = 0; i < textArray.length; i++) {
            String token = "" + textArray[i];
            if (isFront) {
                deck.addFirst(token);
                isFront = false;
            } else {
                deck.addLast(token);
                isFront = true;
            }
        }
        String output = "";
        output = deck.stream().map((word) -> word).reduce(output, String::concat);
        
        return output;
    }
}
