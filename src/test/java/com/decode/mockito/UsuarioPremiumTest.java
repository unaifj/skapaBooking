package com.decode.mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
 
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


 

 
@RunWith(MockitoJUnitRunner.class)
public class UsuarioPremiumTest {
     
    IUsuarioTest usuarioPremiumTest;
     
    @Mock
    IAlmacen usuarioPremiumAlmacen;

 
    @Before
    public void setUp() {
    	usuarioPremiumTest = new UsuarioPremium(usuarioPremiumAlmacen);
    }
 
    @After
    public void tearDown() {
    	usuarioPremiumAlmacen = null;
        usuarioPremiumTest = null;       
    }
 
    @Test
    public void testObtenerUsuario() throws NotEnoughException {
         
        when(usuarioPremiumAlmacen.getPortion(Portion.MEDIUM)).thenReturn(true);
         
        assertTrue(usuarioPremiumTest.makeUsuarioPremium(Portion.MEDIUM));
    }
     
    @Test
    public void testNotEnoughException() throws NotEnoughException {
         
        when(usuarioPremiumAlmacen.getPortion(Portion.SMALL)).thenReturn(false);

        assertFalse(usuarioPremiumTest.makeUsuarioPremium(Portion.SMALL));
         
    }
 
}
