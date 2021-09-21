package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ReajusteServiceTest {

    ReajusteService service;
    Funcionario funcionario;

    @BeforeEach
    public void inicializar() {
        this.service = new ReajusteService();
        this.funcionario = new Funcionario("Matheus", LocalDate.now(), new BigDecimal("1000"));
    }

//    @AfterEach
//    public void finalizar() {
//        System.out.println("esse metodo sera executado ao final de cada metodo graças a anotação acima");
//    }

//    @AfterAll
//    public static void antesDeTodos() {
//        System.out.println("esse metodo sera executado 1 unica vez porem antes de todos os testes serem executados graças a anotação acima");
//    }
//
//    @BeforeAll
//    public static void depoisDetodos() {
//        System.out.println("esse metodo sera executado 1 unica vez porem depóis de todos os testes serem executados graças a anotação acima");
//    }

    @Test
    public void reajusteDeveriaSerTresPorCentoQuandoDesempenhoForADesejar() {
        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerQuinzePorCentoQuandoDesempenhoForBom() {
        service.concederReajuste(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerVintePorCentoQuandoDesempenhoForOtimo() {
        service.concederReajuste(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.0"), funcionario.getSalario());
    }
}