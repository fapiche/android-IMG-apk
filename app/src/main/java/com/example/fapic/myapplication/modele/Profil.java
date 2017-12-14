package com.example.fapic.myapplication.modele;

/**
 * Created by fapic on 30/11/2017.
 */

public class Profil {

    //Déclaration des variables
    private Integer age, poid, taille,sexe;
    private float img;
    private String message;
    private static Integer minFemme=10;
    private static Integer maxFemme=30;
    private static Integer minHomme=10;
    private static Integer maxHomme=25;

    //Constructeurs
    public Profil(Integer age,Integer poid, Integer taille, Integer sexe){
        this.age=age;
        this.poid=poid;
        this.taille=taille;
        this.sexe=sexe;
        calculIMG();
        resultIMG();
    }

    //Méthodes

    /**
     * Formule du calcul de l'IMG
     */
    private void calculIMG(){
        float tailleM = (float)taille;
        tailleM=(tailleM/100);
        img=(float)(1.2f * poid / (tailleM * tailleM) + (0.23f * age) - (10.83f * sexe) - 5.4f);
    }

    /**
     * Calcul de l'IMG
     */
    private void resultIMG(){
        if(img<10)
            message="Trop faible";
        else if(img>10 && img<30 && sexe==0)
            message="Parfait";
        else if (img>10 && img<25 && sexe==1)
            message="Parfait";
        else
            message="Trop élevé";
    }

    //Getters & setters


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getPoid() {
        return poid;
    }

    public void setPoid(Integer poid) {
        this.poid = poid;
    }

    public Integer getTaille() {
        return taille;
    }

    public void setTaille(Integer taille) {
        this.taille = taille;
    }

    public Integer getSexe() {
        return sexe;
    }

    public void setSexe(Integer sexe) {
        this.sexe = sexe;
    }

    public float getImg() {
        return img;
    }

    public void setImg(float img) {
        this.img = img;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
