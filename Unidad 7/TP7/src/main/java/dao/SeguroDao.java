package dao;

import java.util.List;

import entidad.Seguro;

public interface SeguroDao {
	public int obtenerProximoIdSimulado();
	public boolean insert(Seguro seguro);
	public List<Seguro> readAll();
}
