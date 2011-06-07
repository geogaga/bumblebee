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
 * Provides basic methods for convenient defensive programming operations.
 */
public final class Bumblebee {

    private static final Bumblebee BUMBLEBEE = new Bumblebee();
    private static final Commander COMMANDER = new Commander();

    private Bumblebee() {
    }

    public static Bumblebee defend() {
        return BUMBLEBEE;
    }

    public Commander from(Threat threat) {
        return COMMANDER.from(threat);
    }

}
