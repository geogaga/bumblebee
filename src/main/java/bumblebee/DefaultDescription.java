/*
 * Copyright 2011 Alexey Hanin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package bumblebee;

/**
 * Serves as a builder of description.
 */
public class DefaultDescription implements Description {

    private StringBuilder sb = new StringBuilder();

    /**
     * Append text.
     *
     * @param text text describing essential reason of mismatch
     */
    public Description appendText(String text) {
        if (sb.length() > 0) {
            sb.append(' ');
        }
        sb.append(text);
        return this;
    }

    public String toString() {
        return sb.toString();
    }
}
