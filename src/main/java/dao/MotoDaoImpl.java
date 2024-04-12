package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import metier.entities.Moto; // Importer la classe Moto au lieu de Produit
import util.JPAutil;

public class MotoDaoImpl implements IMotoDao { // Changer le nom de la classe

    private EntityManager entityManager = JPAutil.getEntityManager("TP5_JEE_moto");

    @Override
    public Moto save(Moto moto) {
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(moto);
            transaction.commit();
            return moto;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return null; // Gérer l'erreur de manière appropriée dans votre application
        }
    }


    @Override
    public List<Moto> motosParMC(String mc) { // Changer le nom de la méthode et le type de retour
        List<Moto> motos = entityManager.createQuery("select m from Moto m where m.nomMoto like :mc") // Adapter la requête JPQL
            .setParameter("mc", "%" + mc + "%")
            .getResultList();
        return motos;
    }

    @Override
    public Moto getMoto(Long id) { // Changer le nom de la méthode et le type de retour
        return entityManager.find(Moto.class, id);
    }

    @Override
    public Moto updateMoto(Moto m) { // Changer le nom de la méthode et le type de retour
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.merge(m);
        tx.commit();
        return m;
    }

    @Override
    public void deleteMoto(Long id) { // Changer le nom de la méthode
        Moto moto = entityManager.find(Moto.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(moto);
        entityManager.getTransaction().commit();
    }
}
