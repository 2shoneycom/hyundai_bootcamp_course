package model;

import java.util.Vector;

public interface IClientDAO {
	public Vector<ClientDTO> getAllClient() throws Exception;
	public boolean insert(ClientDTO dto) throws Exception;
	public boolean update(ClientDTO dto) throws Exception;
	public boolean delete(ClientDTO dto) throws Exception;
	public boolean login(ClientDTO dto) throws Exception;
}
