package com.example.fapic.myapplication.controleur;

import com.example.fapic.myapplication.modele.Profil;

/**
 * Created by fapic on 07/12/2017.
 */

public final class Controle {

    //Déclaration des variables
    private static Controle instance=null;
    private static Profil profil;

    //Contrôleurs
    private Controle(){
        super();
    }

    //Méthodes

    /**
     * Création du profil
     * @param poids
     * @param taille en cm
     * @param age
     * @param sexe 1 pour homme, 0 pour femme
     */
    public void creerProfil(Integer poids, Integer taille, Integer age, Integer sexe){
        profil = new Profil(age, poids, taille, sexe);
    }

    /**
     * Récupération de l'img dans profil
     * @return
     */
    public float getImg(){
        return profil.getImg();
    }

    /**
     * Récupération du message dans profil
     * @return
     */
    public String getMessage(){
        return profil.getMessage();
    }

    /**
     * Création ou récupération d'une instance du controleur
     * @return
     */
    public final static Controle getInstance(){
        if(Controle.instance==null) {
            Controle.instance = new Controle();
        }
        return Controle.instance;
    }
}
