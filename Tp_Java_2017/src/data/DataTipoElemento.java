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
			rs = stmt.executeQuery("Select *  from tipo_elemento  inner join elemento  on tipo_elemento.id_el=elemento.id_el ");
			if (rs!= null ){
				while(rs.next()){
					TipoElemento te = new TipoElemento();
					te.setElemento(new Elemento());
					te.setId_TE(rs.getInt("id_te"));
					te.getElemento().setId_El(rs.getInt("id_el"));
					te.getElemento().setNombre_El(rs.getString("nombre_el"));
					te.setNombre_TE(rs.getString("nombre_te"));
				    te.setCant_reserva_max(rs.getInt("cant_reserva_max"));
				    te.setTiempo_limite(rs.getInt("tiempo_limite"));
				    te.setDias_anticipacion(rs.getInt("dias_anticipacion"));	
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
	 public TipoElemento getByNombre(TipoElemento te) throws Exception{
		 	TipoElemento tel = null;
	    	PreparedStatement stmt= null;
	    	ResultSet rs=null;
	    	try {
	    		 stmt= FactoryConexion.getInstancia().getConn().prepareStatement( "select te.id_el,el.nombre_el,te.tiempo_limite,te.dias_anticipacion from tipo_elemento te inner join elemento el on el.id_el=te.id_el where te.nombre_te");
	    		stmt.setString(2, te.getNombre_TE());
	    		 rs=stmt.executeQuery();
	    		 if(rs!=null && rs.next()){
	    			 tel=new TipoElemento();
	    			 tel.setElemento(new Elemento());
	    			 tel.setId_TE(rs.getInt("id_te"));
	    			 tel.getElemento().setId_El(rs.getInt("id_el"));
	    			 tel.getElemento().setNombre_El(rs.getString("nombre_el"));
	    			 tel.setNombre_TE(rs.getString("nombre_te"));
	    			 tel.setTiempo_limite(rs.getInt("tiempo_limite"));
	    			 tel.setDias_anticipacion(rs.getInt("dias_anticipacion"));

	    		 }
	    		 
	    	} catch (Exception ex ){
	    		throw ex;
	    	} finally {
	    		try{
	    			if(rs!=null)rs.close();
	    			if (stmt!=null)stmt.close();
	    			FactoryConexion.getInstancia().releaseConn();
	    		}catch (SQLException ex ){
	    			throw ex;
	    		}
	    	} return te;
	 }
	 public void add (TipoElemento tipoel ) throws Exception{
	    	PreparedStatement stmt=null;
	    	ResultSet keyResultSet=null;
	    	try{ stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert into tipo_elemento(id_el,nombre_te,tiempo_limite,dias_anticipacion) " +
					 "values (?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
	    		  stmt.setInt (1,tipoel.getElemento().getId_El());
	    		  stmt.setString(2,tipoel.getNombre_TE());
	    		 // stmt.setInt(3,tipoel.getCant_reserva_max());
	    		  stmt.setInt(3,tipoel.getTiempo_limite());
	    		  stmt.setInt(4,tipoel.getDias_anticipacion());
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
						"SELECT id_te,id_el,nombre_te,tiempo_limite,dias_anticipacion" +
						"FROM  tipo_elemento  inner join elemento  on tipo_elemento.id_el=elemento.id_el where nombre_te=?");		
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
						"UPDATE tipo_elemento SET id_el=?,nombre_te=?,tiempo_limite=?,dias_anticipacion=? WHERE id_te=?");		
				stmt.setInt(1,tipoel.getElemento().getId_El());
				stmt.setString(2,tipoel.getNombre_TE());
				stmt.setInt(3,tipoel.getCant_reserva_max());
				stmt.setInt(4,tipoel.getTiempo_limite());
				stmt.setInt(5,tipoel.getDias_anticipacion());	
				stmt.setInt(6,tipoel.getId_TE());
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