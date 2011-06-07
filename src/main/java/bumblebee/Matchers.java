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

import bumblebee.matcher.IsNull;
import bumblebee.matcher.Not;

public final class Matchers {

    public static final IsNull IS_NULL = new IsNull();

    private Matchers() {
    }

    @SuppressWarnings("unchecked")
    public static <T> IsNull<T> isNull() {
        return IS_NULL;
    }

    @SuppressWarnings("unchecked")
    public static <T> Not<T> not(Matcher<T> m) {
        return new Not(m);
    }

}
