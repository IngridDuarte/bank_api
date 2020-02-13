package com.dbtest.apibancaria;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ContaCorrenteTeste {

    @Mock
    private ContaCorrenteRepositorio repositorio;

    @InjectMocks
    private ContaCorrenteServico contaCorrenteServico;

    @Rule
    private ContaCorrente contaCorrenteEsperada;

    @Before
    public  void setup(){
        contaCorrenteEsperada = new ContaCorrente(Long.valueOf(1), Long.valueOf(0));
    }

    @Test
    public void deveRetornarOkSeAdicionarContaCorrenteValida(){
        when(repositorio.save(contaCorrenteEsperada)).thenReturn(contaCorrenteEsperada);

        ContaCorrente contaCorrente = contaCorrenteServico.save(contaCorrenteEsperada);

        Assert.assertEquals(contaCorrenteEsperada.getNumero, contaCorrente.getNumero);

        Mockito.verify(repositorio, Mockito.times(1)).save(contaCorrenteEsperada);
    }
}