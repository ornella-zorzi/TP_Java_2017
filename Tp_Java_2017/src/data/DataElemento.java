package data;
import entity.*;
import util.ApplicationException;

import java.sql.*;
import java.util.ArrayList;


public class DataElemento {
	
	public ArrayList<Elemento> getAll() throws ApplicationException{
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Elemento> elems = new ArrayList<Elemento>();
		try{ 
			stmt = FactoryConexion.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("Select  *  from elemento");
			if (rs!= null ){
				while(rs.next()){
					Elemento el = new Elemento();
					el.setId_El(rs.getInt("id_el"));
					el.setNombre_El(rs.getString("nombre_el"));
					elems.add(el);
						
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
			return elems;
		
	} 

    public Elemento getByNombre(Elemento el) throws Exception{
    	Elemento e = null ;
    	PreparedStatement stmt= null;
    	ResultSet rs=null;
    	try {
    		 stmt= FactoryConexion.getInstancia().getConn().prepareStatement( "select e.id_el, e.nombre_el from elemento e where e.nombre_el=? ");
    		 stmt.setString(1, el.getNombre_El());
    		 rs=stmt.executeQuery();
    		 if(rs!=null && rs.next()){
    			 e=new Elemento();
    			 e.setId_El(rs.getInt("id_el"));
					e.setNombre_El(rs.getString("nombre_el"));
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
    	} return e;
    	
    }
    
    public void add (Elemento el ) throws Exception{
    	PreparedStatement stmt=null;
    	ResultSet keyResultSet=null;
    	try{ stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
				"insert into elemento(nombre_el) " +
				 "values (?)",PreparedStatement.RETURN_GENERATED_KEYS);
    		  stmt.setString(1,el.getNombre_El());
    		  stmt.executeUpdate();
    		  keyResultSet=stmt.getGeneratedKeys();
    		  if (keyResultSet!=null && keyResultSet.next()){
    			  el.setId_El(keyResultSet.getInt(1));
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
					"SELECT id_el, nombre_el FROM elemento where nombre_el=?");			
			rs = stmt.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ApplicationException e) {
			throw e;
		}

		return rs;
		
	}



public void update(Elemento el){
	ResultSet rs=null;
	PreparedStatement stmt=null;	
	try {
		stmt= FactoryConexion.getInstancia().getConn().prepareStatement(
				"UPDATE Elemento SET nombre_el=? WHERE id_el=?");	
		
		  stmt.setString(1,el.getNombre_El());
		  stmt.setInt(2, el.getId_El());
		  
		  stmt.execute();
		
	} catch (SQLException e) {			
		e.printStackTrace();
	} catch (ApplicationException e) {			
		e.printStackTrace();
	}

}

public void delete(Elemento el){
	PreparedStatement stmt=null;		
	try {
		stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
				"delete from elemento where id_el=?");
		stmt.setInt(1,el.getId_El());
		stmt.execute();
	} catch (SQLException e) {			
		e.printStackTrace();
	} catch (ApplicationException e) {			
		e.printStackTrace();
	} 
	
}
}
