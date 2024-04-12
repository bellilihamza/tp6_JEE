package dao;

import java.util.List;
import metier.entities.Moto;

public interface IMotoDao {
    public Moto save(Moto moto);
    public List<Moto> motosParMC(String mc);
    public Moto getMoto(Long id);
    public Moto updateMoto(Moto moto);
    public void deleteMoto(Long id);
}
