package dao;

import java.util.List;
import metier.entities.Moto;

public class TestDao {
    public static void main(String[] args) {
        MotoDaoImpl motoDao = new MotoDaoImpl();

        // Test de sauvegarde d'une moto
        Moto moto1 = new Moto("Yamaha R1", 15000);
        Moto savedMoto = motoDao.save(moto1);
        System.out.println("Moto sauvegardée : " + savedMoto);

        // Test de récupération de moto par ID
        Moto retrievedMoto = motoDao.getMoto(savedMoto.getIdMoto());
        System.out.println("Moto récupérée par ID : " + retrievedMoto);

        // Test de mise à jour de la moto
        retrievedMoto.setPrix(16000);
        Moto updatedMoto = motoDao.updateMoto(retrievedMoto);
        System.out.println("Moto mise à jour : " + updatedMoto);

        // Test de suppression de moto
        long motoIdToDelete = updatedMoto.getIdMoto();
        motoDao.deleteMoto(motoIdToDelete);
        System.out.println("Moto supprimée avec l'ID : " + motoIdToDelete);

        // Test de recherche de motos par mot-clé
        List<Moto> motos = motoDao.motosParMC("Yamaha");
        System.out.println("Motos trouvées avec le mot-clé 'Yamaha': ");
        for (Moto moto : motos) {
            System.out.println(moto);
        }
    }
}
