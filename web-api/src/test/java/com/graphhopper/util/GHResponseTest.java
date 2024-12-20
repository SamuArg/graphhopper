/*
 *  Licensed to GraphHopper GmbH under one or more contributor
 *  license agreements. See the NOTICE file distributed with this work for
 *  additional information regarding copyright ownership.
 *
 *  GraphHopper GmbH licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except in
 *  compliance with the License. You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.graphhopper.util;

import com.graphhopper.GHResponse;
import com.graphhopper.ResponsePath;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GHResponseTest {
    @Test
    public void testToString() {
        assertEquals("no paths", new GHResponse().toString());
    }

    @Test
    public void testHasNoErrorIfEmpty() {
        assertFalse(new GHResponse().hasErrors());
        GHResponse rsp = new GHResponse();
        rsp.add(new ResponsePath());
        assertFalse(rsp.hasErrors());
    }
    //Test for the function addDebugInfo making sure that you can not add a null string to the attribute debugInfo
    @Test
    public void testAddDebugInfo(){
        // Arrange
        GHResponse instance = new GHResponse();
        String expectedMessage = "Debug information has to be none null";
        // Act and Assert
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            instance.addDebugInfo(null);
        });
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }
}
