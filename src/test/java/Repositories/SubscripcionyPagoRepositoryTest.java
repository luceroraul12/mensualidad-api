package Repositories;

import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class SubscripcionyPagoRepositoryTest {

    @Autowired
    SubscripcionRepository subscripcionRepository;

    @Autowired
    PagoRepository pagoRepository;

    @BeforeAll
    static void beforeAll() {

    }
}