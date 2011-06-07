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

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class IsNullTest {

    private IsNull<Object> isNull;

    @Before
    public void setUp() throws Exception {
        isNull = new IsNull<Object>();
    }

    @Test
    public void testMatches_Null() throws Exception {
        Object item = null;
        assertThat(isNull.matches(item), equalTo(true));
    }

    @Test
    public void testMatches_NotNull() throws Exception {
        Object item = new Object();
        assertThat(isNull.matches(item), equalTo(false));
    }

}
