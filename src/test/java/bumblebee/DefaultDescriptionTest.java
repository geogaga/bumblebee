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

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class DefaultDescriptionTest {

    private DefaultDescription description;

    @Before
    public void setUp() throws Exception {
        description = new DefaultDescription();
    }

    @Test
    public void testAppendText_Empty() throws Exception {
        assertThat(description.toString(), equalTo(""));
    }

    @Test
    public void testAppendText_Single() throws Exception {
        description.appendText("Big");
        assertThat(description.toString(), equalTo("Big"));
    }

    @Test
    public void testAppendText_Sequence() throws Exception {
        description.appendText("Big").appendText("Brown Fox");
        assertThat(description.toString(), equalTo("Big Brown Fox"));
    }

}
