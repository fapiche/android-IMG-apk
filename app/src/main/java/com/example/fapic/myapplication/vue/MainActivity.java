package com.example.fapic.myapplication.vue;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fapic.myapplication.R;
import com.example.fapic.myapplication.controleur.Controle;

import static android.graphics.Color.GREEN;

public class MainActivity extends AppCompatActivity {

    //Déclaration des variables
    private EditText txtPoids;
    private EditText txtTaille;
    private EditText txtAge;
    private RadioButton rdHomme;
    private TextView lblIMG;
    private ImageView imgSmiley;
    private Controle controle;

    //Méthodes

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    /**
     * Initialisation des composants graphiques
     */
    private void init(){
        txtPoids = (EditText)findViewById(R.id.txtPoids) ;
        txtTaille = (EditText)findViewById(R.id.txtTaille);
        txtAge = (EditText)findViewById(R.id.txtAge);
        rdHomme = (RadioButton)findViewById(R.id.rdHomme);
        lblIMG = (TextView)findViewById(R.id.lblIMG);
        imgSmiley = (ImageView)findViewById(R.id.imgSmiley);
        //Création d'une instance du contrôleur
        controle = Controle.getInstance();

        ecouteCalcul();
    }

    /**
     * On gère les evênements liés au bouton calculer
     */
    private void ecouteCalcul(){
        ((Button) findViewById(R.id.btnCalc)).setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                // TEST du bon fonctionnement du bouton : Toast.makeText(MainActivity.this, "test", Toast.LENGTH_SHORT).show();

                //On récupère les informations saisies par l'utilisateur si elles sont correctes
                Integer poids = 0;
                Integer taille = 0;
                Integer age = 0;
                Integer sexe = 0;
                String erreur = "Veuillez renseigner les champs suivants : ";
                try{
                    poids = Integer.parseInt(txtPoids.getText().toString());
                    taille = Integer.parseInt(txtTaille.getText().toString());
                    age = Integer.parseInt(txtAge.getText().toString());
                }catch (Exception e){
                    e.getMessage();
                }
                if(rdHomme.isChecked()){
                    sexe = 1;
                }
                //On vérifie que tous les champs ont bien été renseignés
                if(poids == 0 || taille == 0 || age == 0) {
                    if (poids == 0) {
                        erreur = erreur + "poids ";
                    }
                    if (taille == 0) {
                        erreur = erreur + "taille ";
                    }
                    if (age == 0) {
                        erreur = erreur + "age";
                    }
                    Toast.makeText(MainActivity.this, erreur, Toast.LENGTH_SHORT).show();
                }else{
                    afficheResult(poids,taille,age,sexe);
                }
            }
        });
    }

    /**
     * Affichage du resultat de l'IMG et de l'image
     * @param poids
     * @param taille
     * @param age
     * @param sexe
     */
    private void afficheResult(Integer poids, Integer taille, Integer age, Integer sexe){
        controle.creerProfil(poids,taille,age,sexe);
        float img = controle.getImg();
        String message = controle.getMessage();
        //Test pour savoir quelle image afficher à l'utilisateur
        if(message.equals("Trop élevé")){
            imgSmiley.setImageResource(R.drawable.graisse);
            lblIMG.setTextColor(Color.RED);
            lblIMG.setText(String.format("%.01f", img)+", IMG trop élevé !");
        }else if(message.equals("Parfait")){
            imgSmiley.setImageResource(R.drawable.normal);
            lblIMG.setTextColor(GREEN);
            lblIMG.setText(String.format("%.01f", img)+", IMG normal !");
        }else{
            imgSmiley.setImageResource(R.drawable.maigre);
            lblIMG.setTextColor(Color.RED);
            lblIMG.setText(String.format("%.01f", img)+", IMG trop faible !");
        }
    }

    //Getters & Setters

    public EditText getTxtTaille() {
        return txtTaille;
    }

    public EditText getTxtPoids() {
        return txtPoids;
    }

    public EditText getTxtAge() {
        return txtAge;
    }

    public RadioButton getRdHomme() {
        return rdHomme;
    }

    public TextView getLblIMG() {
        return lblIMG;
    }

    public ImageView getImgSmiley() {
        return imgSmiley;
    }

    public void setLblIMG(TextView lblIMG) {
        this.lblIMG = lblIMG;
    }

    public void setImgSmiley(ImageView imgSmiley) {
        this.imgSmiley = imgSmiley;
    }
}
