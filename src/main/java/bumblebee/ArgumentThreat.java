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

public class ArgumentThreat<T> extends AbstractMatchingThreat<T> {

    private String name;
    private T object;

    public ArgumentThreat(String name, T object, Matcher<T> matcher) {
        this.name = name;
        this.object = object;
        setMatcher(matcher);
    }

    public void describe(Description description) {
        description.appendText("Parameter " + name);
        Matcher<T> matcher = getMatcher();
        matcher.describeMismatch(object, description);
    }

    public void throwException(DefaultDescription description) {
        throw new IllegalArgumentException(description.toString());
    }
}
