package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    void verify_is_occupied_false_on_room_create() {
        //arranging
        Room room1 = new Room( 2, 124);

        //acting
        boolean result = room1.isOccupied();

        //assert
        assertFalse(result);
    }

    @Test
    void verify_check_in_makes_occupied_and_dirty() {
        //arrange
        Room room1 = new Room(3, 124);

        //act
        room1.checkIn();
        boolean occupiedResult = room1.isOccupied();
        boolean dirtyResult = room1.isDirty();

        //assert
        assertTrue(occupiedResult);
        assertTrue(dirtyResult);
    }
}