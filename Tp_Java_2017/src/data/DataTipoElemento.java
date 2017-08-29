package data;
import entity.*;
import util.ApplicationException;

import java.sql.*;
import java.util.ArrayList;

public class DataTipoElemento {
	public ArrayList<TipoElemento> getAll() throws ApplicationException{
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<TipoElemento> tipoel = new ArrayList<TipoElemento>();
		try{ 
			stmt = FactoryConexion.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("Select  *  from tipo_elemento  inner join elemento  on tipo_elemento.id_el=elemento.id_el ");
			if (rs!= null ){
				while(rs.next()){
					TipoElemento te = new TipoElemento();
					te.setElemento(new Elemento());
					te.setId_TE(rs.getInt("id_te"));
					te.setNombre_TE(rs.getString("nombre_el"));
				    te.setCant_reserva_max(rs.getInt("cant_reserva_max"));
				    te.setTiempo_limite(rs.getInt("tiempo_limite"));
				    te.setDias_anticipacion(rs.getInt("dias_anticipacion"));
					te.getElemento().setId_El(rs.getInt("id_el"));
					te.getElemento().setNombre_El(rs.getString("nombre_el"));
					tipoel.add(te);
						
				}
			}
			
		} catch (SQLException e ){
			//throw e;
		} catch (ApplicationException ade){
			throw ade;
		} try {
			if(rs!=null) rs.close();
			if (stmt!=null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e){
				e.printStackTrace();
			}
			return tipoel;
		
	} 
	 public void add (TipoElemento tipoel ) throws Exception{
	    	PreparedStatement stmt=null;
	    	ResultSet keyResultSet=null;
	    	try{ stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert into tipo_elemento(nombre_te,cant_reserva_max,tiempo_limite,dias_anticipacion,id_el) " +
					 "values (?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
	    		  stmt.setString (1,tipoel.getNombre_TE());
	    		  stmt.setInt(2,tipoel.getCant_reserva_max());
	    		  stmt.setInt(3,tipoel.getTiempo_limite());
	    		  stmt.setInt(4,tipoel.getDias_anticipacion());
	    		  stmt.setInt(8,tipoel.getElemento().getId_El());
	    		  stmt.executeUpdate();
	    		  keyResultSet=stmt.getGeneratedKeys();
	    		  if (keyResultSet!=null && keyResultSet.next()){
	    			  tipoel.setId_TE(keyResultSet.getInt(1));
	    		  }
	    		
	    	} catch (SQLException | ApplicationException e){
	    		throw e;
	    	}try { 
	    			if (keyResultSet!=null)keyResultSet.close();
	    			if (stmt!=null)stmt.close();
	    			FactoryConexion.getInstancia().releaseConn();
	    	} catch (SQLException e ){
	    		e.printStackTrace();
	    	}
	    } 
	 
	 public ResultSet getResultSet() throws ApplicationException{	
			PreparedStatement stmt = null;
			ResultSet rs = null;
			try
			{
				stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
						"SELECT id_te,nombre_te,cant_reserva_max,tiempo_limite,dias_anticipacion,id_el " +
						"FROM from tipo_elemento  inner join elemento  on tipo_elemento.id_el=elemento.id_el ");			
				rs = stmt.executeQuery();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ApplicationException e) {
				throw e;
			}
			return rs;
			
		}
	 public void update(TipoElemento tipoel){
			ResultSet rs=null;
			PreparedStatement stmt=null;	
			try {
				stmt= FactoryConexion.getInstancia().getConn().prepareStatement(
						"UPDATE tipo_elemento SET id_te,nombre_te=?,cant_reserva_max=?,tiempo_limite=?,dias_anticipacion=?,id_el=?"+
						" WHERE id_te=?");	
			
				stmt.setInt(1,tipoel.getId_TE());
				stmt.setString(2,tipoel.getNombre_TE());
				stmt.setInt(3,tipoel.getCant_reserva_max());
				stmt.setInt(4,tipoel.getTiempo_limite());
				stmt.setInt(5,tipoel.getDias_anticipacion());	
				stmt.execute();
			} catch (SQLException e) {			
				e.printStackTrace();
			} catch (ApplicationException e) {			
				e.printStackTrace();
			}
			
		} 
	 public void delete(TipoElemento tipoel){
			PreparedStatement stmt=null;		
			try {
				stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
						"delete from tipo_elemento where id_te=?");
				stmt.setInt(1,tipoel.getId_TE());
				stmt.execute();
			} catch (SQLException e) {			
				e.printStackTrace();
			} catch (ApplicationException e) {			
				e.printStackTrace();
			} 	
}
}