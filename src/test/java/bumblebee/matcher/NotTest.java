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

import bumblebee.Matcher;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NotTest {

    private Matcher<Object> matcher;
    private Object item;

    @Before
    public void setUp() throws Exception {
        matcher = mock(Matcher.class);
        item = new Object();
    }

    @Test
    public void testMatches_True() throws Exception {
        Object obj = new Object();
        when(matcher.matches(obj)).thenReturn(true);

        assertThat(new Not<Object>(matcher).matches(obj), equalTo(false));
    }

    @Test
    public void testMatches_False() throws Exception {
        when(matcher.matches(item)).thenReturn(false);

        assertThat(new Not<Object>(matcher).matches(item), equalTo(true));
    }
}
