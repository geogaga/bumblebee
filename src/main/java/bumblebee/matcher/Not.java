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
package bumblebee.matcher;

import bumblebee.Description;
import bumblebee.Matcher;

public class Not<T> implements Matcher<T> {

    private final Matcher<T> matcher;

    public Not(Matcher<T> matcher) {
        this.matcher = matcher;
    }

    public boolean matches(T object) {
        return !matcher.matches(object);
    }

    public void describeMismatch(T object, Description description) {
        description.appendText("not");
    }
}
