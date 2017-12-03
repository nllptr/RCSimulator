package simonwessel;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import simonwessel.MonsterTruck.Heading;

public class TestMonsterTruckMovement {

	MonsterTruck car;

	@Before
	public void setUp() throws Exception {
		car = new MonsterTruck(new Room(3, 3), 1, 1, Heading.NORTH);
	}

	@After
	public void tearDown() throws Exception {
		car = null;
	}

	@Test
	public void testForward() {
		try {
			car.forward();
			assertEquals(1, car.getX());
			assertEquals(2, car.getY());
			assertEquals(Heading.NORTH, car.getHeading());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testBackward() {
		try {
			car.backward();
			assertEquals(1, car.getX());
			assertEquals(0, car.getY());
			assertEquals(Heading.NORTH, car.getHeading());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testLeft() {
		car.left();
		assertEquals(1, car.getX());
		assertEquals(1, car.getY());
		assertEquals(Heading.WEST, car.getHeading());
		car.left();
		car.left();
		car.left();
		assertEquals(Heading.NORTH, car.getHeading());
	}

	@Test
	public void testRight() {
		car.right();
		assertEquals(1, car.getX());
		assertEquals(1, car.getY());
		assertEquals(Heading.EAST, car.getHeading());
		car.right();
		car.right();
		car.right();
		assertEquals(Heading.NORTH, car.getHeading());
	}

	public void testPlaceCarOutsideRoom() {
		try {
			car = new MonsterTruck(new Room(5, 5), 5, 3, Heading.WEST);
			fail("Exception was not thrown.");
		} catch (Exception e) {
			// Just pass. Nothing to see here.
		}
	}
}
