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

import org.junit.Test;

import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class BumblebeeTest {

    @Test
    public void testDefend() throws Exception {
        assertThat(Bumblebee.defend(), sameInstance(Bumblebee.defend()));
    }

    @Test
    public void testFrom() throws Exception {
        Bumblebee defend = Bumblebee.defend();
        assertThat(defend.from(mock(Threat.class)), sameInstance(defend.from(mock(Threat.class))));
    }
}
