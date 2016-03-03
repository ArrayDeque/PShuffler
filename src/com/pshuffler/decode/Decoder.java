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
package com.pshuffler.decode;

import java.util.ArrayDeque;

/**
 *
 * @author Frank Jennings
 */
public class Decoder {
    
    public static String decode(String text){
        //Construct a scrap deque and decode
        char[] textArray = text.toCharArray();
        ArrayDeque<String> sdeck = new ArrayDeque();

        for (int i = 0; i < textArray.length; i++) {
            String word = "" + textArray[i];
            sdeck.add(word);
        }

        boolean isFront = true;

        char[] outputArray = new char[textArray.length];
        int pindex = 0;

        for (int i = 0; i < textArray.length; i++) {

            if (isFront) {
                String q = sdeck.removeFirst();
                outputArray[pindex] = q.charAt(0);
                isFront = false;
            } else {
                String p = sdeck.removeLast();
                outputArray[pindex] = p.charAt(0);
                isFront = true;
            }
            pindex++;
        }
        
        return new StringBuilder(new String(outputArray)).reverse().toString();
        
    }
    
}
