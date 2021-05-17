package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import connection.ConnectionFactory;
import model.AnuncioModel;

public class AnuncioDao {

		AnuncioDao anuncio = new AnuncioDao();
		
		/** 
		 * Criação da conexão com o banco de dados
		 * @author Mateus Haverroth
		 */
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		
		/** 
		 * Método para Inserção de anuncio
		 * @author Mateus Haverroth
		 */
		public void create(AnuncioModel anuncio) {
			/*
			 *  Realizando o insert de anuncio no banco de dados
			 * @author 
			 */
			try {
				statement = connection.prepareStatement("INSERT INTO anuncios(nome_anuncio, cliente, data_inicio, data_fim, valor_dia) VALUES(?, ?, ?, ?, ?)");
				statement.setString(1, anuncio.getNomeDoAnuncio());
				statement.setString(2, anuncio.getCliente());
				statement.setString(3, anuncio.getDataInicio());
				statement.setString(4, anuncio.getDataTermino());
				statement.setDouble(5, anuncio.getInvestimento());
				
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Erro ao cadastrar!"+ ex);
			}finally {
				ConnectionFactory.closeConnection(connection, statement);
			}
				}
		
		/**  
		 * Método para atualizar um anuncio
		 * @author Mateus Haverroth
		 */
		public void update(AnuncioModel anuncio) {
			
			try {
				statement = connection.prepareStatement("UPDATE anuncios SET nome_anuncio = ?, cliente = ?, data_inicio = ?, data_fim = ?, valor_dia = ? WHERE id = ?");
				statement.setString(1, anuncio.getNomeDoAnuncio());
				statement.setString(2, anuncio.getCliente());
				statement.setString(3, anuncio.getDataInicio());
				statement.setString(4, anuncio.getDataTermino());
				statement.setDouble(5, anuncio.getInvestimento());
				statement.setInt(6, anuncio.getId());
				
				statement.executeUpdate();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Erro ao atualizar!"+ ex);
			}finally {
				ConnectionFactory.closeConnection(connection, statement);
			}
		
		}				
				
		
		/** 
		 *  Método para listar anuncios
		 * @author Mateus Haverroth
		 */
		public List<AnuncioModel>  read() {
			List<AnuncioModel> anuncios = new ArrayList<>();
			
			try {
				statement = connection.prepareStatement("SELECT * FROM anuncios");
				result = statement.executeQuery();
				
				while (result.next()) {
					AnuncioModel anuncio = new AnuncioModel();
					
					anuncio.setId(result.getInt("id"));
					anuncio.setNomeDoAnuncio(result.getString("nome_anuncio"));
					anuncio.setCliente(result.getString("cliente"));
					anuncio.setDataInicio(result.getString("data_inicio"));
					anuncio.setDataTermino(result.getString("data_fim"));
					anuncio.setInvestimento(result.getDouble("valor_dia"));
					anuncios.add(anuncio);	
				}
				
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Erro ao listar pessoas!"+ ex);
			}finally {
				ConnectionFactory.closeConnection(connection, statement, result);
			}
			
			return anuncios;
		}
		
		/**  
		 * Método para listar anuncios pelo cliente
		 * @author Mateus Haverroth
		 */
			public List<AnuncioModel>  readFromCliente(AnuncioModel cliente) {
			List<AnuncioModel> anuncios = new ArrayList<>();
			
			try {
				
				statement = connection.prepareStatement("SELECT * FROM anuncios WHERE cliente LIKE ?");
				statement.setString(1, "%"+cliente.getCliente()+"%");
				result = statement.executeQuery();
				
				while (result.next()) {
					AnuncioModel anuncio = new AnuncioModel();
					
					anuncio.setId(result.getInt("id"));
					anuncio.setNomeDoAnuncio(result.getString("nome_anuncio"));
					anuncio.setCliente(result.getString("cliente"));
					anuncio.setDataInicio(result.getString("data_inicio"));
					anuncio.setDataTermino(result.getString("data_fim"));
					anuncio.setInvestimento(result.getDouble("valor_dia"));
					anuncios.add(anuncio);	
				}
				
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Erro ao listar pessoas!"+ ex);
			}finally {
				ConnectionFactory.closeConnection(connection, statement, result);
			}
			
			return anuncios;
		}
			
			/**  
			 * Método para listar anuncios pela data de inicio
			 * @author Mateus Haverroth
			 */
			public List<AnuncioModel>  readFromdata(AnuncioModel DataInicio) {
			List<AnuncioModel> anuncios = new ArrayList<>();
			
			try {
				
				statement = connection.prepareStatement("SELECT * FROM anuncios WHERE data_inicio LIKE ?");
				statement.setString(1, "%"+DataInicio.getCliente()+"%");
				result = statement.executeQuery();
				
				while (result.next()) {
					AnuncioModel anuncio = new AnuncioModel();
					
					anuncio.setId(result.getInt("id"));
					anuncio.setNomeDoAnuncio(result.getString("nome_anuncio"));
					anuncio.setCliente(result.getString("cliente"));
					anuncio.setDataInicio(result.getString("data_inicio"));
					anuncio.setDataTermino(result.getString("data_fim"));
					anuncio.setInvestimento(result.getDouble("valor_dia"));
					anuncios.add(anuncio);	
				}
				
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Erro ao listar pessoas!"+ ex);
			}finally {
				ConnectionFactory.closeConnection(connection, statement, result);
			}
			
			return anuncios;
		}
		
	}


