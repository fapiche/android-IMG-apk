package com.example.fapic.myapplication.modele;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by fapic on 30/11/2017.
 */
public class ProfilTest {
    @Test
    public void getImg() throws Exception {
        assertEquals(img,profil.getImg(),(float)0.1);
    }

    @Test
    public void getMessage() throws Exception {
        assertEquals(message,profil.getMessage());
    }
    private Profil profil=new Profil(35,67,165,0);
    private float img=(float)32.2;
    private String message="Trop èlevé";

}