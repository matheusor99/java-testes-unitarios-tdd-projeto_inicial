package br.com.alura.tdd.service;


import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

class BonusServiceTest {

    @Test
    public void bonusDeveriaSerZeroParaFuncionarioComSalarioMuiotoAlto() {
        BonusService service = new BonusService();

        assertThrows(IllegalArgumentException.class,
                () -> service.calcularBonus((new Funcionario("Matheus", LocalDate.now(), new BigDecimal("25000")))));
    }

    @Test
    public void bonusDeveriaSer10PorCentoDoSalario() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus((new Funcionario("Matheus", LocalDate.now(), new BigDecimal("2500"))));

        assertEquals(new BigDecimal("250.0"), bonus);
    }

    @Test
    public void bonusDeveriaSer10PorCentoParaSalarioDeExatamenteDezMil() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus((new Funcionario("Matheus", LocalDate.now(), new BigDecimal("10000"))));

        assertEquals(new BigDecimal("1000.0"), bonus);
    }
}