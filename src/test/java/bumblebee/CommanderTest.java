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

import org.hamcrest.BaseMatcher;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.argThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CommanderTest {

    private Commander commander;

    @Before
    public void setUp() throws Exception {
        commander = new Commander();
    }

    @Test
    public void testAssertion_notReal() throws Exception {
        Threat threat = mock(Threat.class);
        when(threat.isReal()).thenReturn(false);

        commander.from(threat);

        verify(threat, never()).describe(any(Description.class));
        verify(threat, never()).throwException(any(Description.class));
    }

    @Test
    public void testAssertion_isReal() throws Exception {
        Threat threat = mock(Threat.class);
        when(threat.isReal()).thenReturn(true);

        InOrder inOrder = inOrder(threat);

        final Description[] descriptionArr = new Description[1];

        BaseMatcher<Description> descriptionMatcher = new BaseMatcher<Description>() {

            public boolean matches(Object o) {
                descriptionArr[0] = (Description) o;
                return true;
            }

            public void describeTo(org.hamcrest.Description description) {
            }
        };

        doThrow(new RuntimeException("You have crossed the border.")).when(threat)
                .throwException(argThat(descriptionMatcher));

        try {
            commander.from(threat);
            fail("Must raise " + RuntimeException.class.getName());
        } catch (RuntimeException ex) {
            // normal flow
        }

        final Description description = descriptionArr[0];
        inOrder.verify(threat).isReal();
        inOrder.verify(threat).describe(description);
        inOrder.verify(threat).throwException(description);
    }

    public void testFrom_ReturningObject() throws Exception {
        Threat threat = mock(Threat.class);
        assertThat(commander.from(threat), sameInstance(commander));
    }


}
