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
package com.graphhopper.util.shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Peter Karich
 */
public class GHPointTest {
    @Test
    public void testIsValid() {
        GHPoint instance = new GHPoint();
        assertFalse(instance.isValid());
        instance.lat = 1;
        assertFalse(instance.isValid());
        instance.lon = 1;
        assertTrue(instance.isValid());
    }

    // Test if the function fromString return the correct GHPoint object
    @Test
    public void testFromString(){
        // Arrange
        String string = "12.34,34.98";
        // Act
        GHPoint point = GHPoint.fromString(string);
        // Assert
        assertEquals(12.34, point.getLat());
        assertEquals(34.98, point.getLon());
    }

    // Test if the function fromStringLonLat return the correct GHPoint object
    @Test
    public void testFromStringLonLat(){
        // Arrange
        String string = "12.34, 34.98";
        // Act
        GHPoint point = GHPoint.fromStringLonLat(string);
        // Assert
        assertEquals(12.34, point.getLon());
        assertEquals(34.98, point.getLat());
    }

    // Test if the function fromString throws the right exception when calling it
    // with a wrong string (only 1 number), it should throw IllegalArgumentException
    @Test
    public void testIllegalFromString(){
        // Arrange
        String string = "12.34";
        String expectedMessage = "Cannot parse point '12.34'";
        // Act and Assert
        Exception exception = assertThrows(IllegalArgumentException.class, ()->{
            GHPoint.fromString(string);
        });
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    // Test if the function fromString throws the right exception when calling it
    // with a wrong string, (non-number string), it should throw IllegalArgumentException
    @Test
    public void testNumberExceptionFromString(){
        // Arrange
        String string = "test, wrong";
        String expectedMessage = "Cannot parse point 'test, wrong'";
        // Act and Assert
        Exception exception = assertThrows(IllegalArgumentException.class, ()->{
            GHPoint.fromString(string);
        });
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }
    //Test if the function testfromJson is able to extract the correct indexes in order to return a new GHPoint object with the first two
    //indexes of a doubles array
    @Test
    public void testfromJson(){
        // Arrange
        double[] xy = {2.4, 3.1, 4.8, 8.3, 5.3};
        GHPoint expected = new GHPoint(3.1, 2.4);
        // Act
        GHPoint point = GHPoint.fromJson(xy);
        // Assert
        assertEquals(expected, point);
    }
}
