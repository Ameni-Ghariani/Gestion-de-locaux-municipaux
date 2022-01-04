package TestJunit2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.gestion_locaux.metier.Reservation;

class Testjunit {

	@Test
	void test() {
		assertEquals(800, Reservation.CalculePrixLocation(400, "soirée"));

	}

}
