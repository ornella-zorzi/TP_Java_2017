package data;
import entity.*;
import util.ApplicationException;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.security.KeyStore.ProtectionParameter;

public class DataPersona {
	public ArrayList<Persona> getAll() throws Exception{
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Persona> pers = new ArrayList<Persona>();
		try{ 
			stmt = FactoryConexion.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("Select* from persona p inner join cateoria c on p.id_cat=c.id_cat ");
			if (rs!= null ){
				while(rs.next()){
					Persona p = new Persona();
					p.setCategoria(new Categoria());
					p.setId(rs.getInt("id"));
					p.setNombre(rs.getString("nombre"));
					p.setApellido(rs.getString("apellido"));
					p.setDni(rs.getNString("dni"));
					p.setEmail(rs.getString("email"));
					p.setUsuario(rs.getString("usuario"));
					p.setContraseña(rs.getString("contraseña"));
					p.setHabilitado(rs.getBoolean("habilitado"));
					p.getCategoria().setId_cat(rs.getInt("id_cat"));
					p.getCategoria().setNombre_cat(rs.getString("nombre_cat"));
					pers.add(p);
						
				}
			}
			
		} catch (SQLException e ){
			throw e;
		} catch (ApplicationException ade){
			throw ade;
		} try {
			if(rs!=null) rs.close();
			if (stmt!=null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e){
				e.printStackTrace();
			}
			return pers;
		
	} 

    public Persona getByDni(Persona per) throws Exception{
    	Persona p = null ;
    	PreparedStatement stmt= null;
    	ResultSet rs=null;
    	try {
    		 stmt= FactoryConexion.getInstancia().getConn().prepareStatement( "select p.id_per, nombre, apellido, email, usuario, contraseña, habilitado, id_cat, nombre_cat"
    		 		+ "from persona p inner join categoria c on p.id_cat=c.id_cat where dni=? ");
    		 stmt.setString(1, per.getDni());
    		 rs=stmt.executeQuery();
    		 if(rs!=null && rs.next()){
    			 p=new Persona();
    			 p.setCategoria(new Categoria());
    			 p.setId(rs.getInt("id_per"));
					p.setNombre(rs.getString("nombre"));
					p.setApellido(rs.getString("apellido"));
					p.setDni(rs.getNString("dni"));
					p.setEmail(rs.getString("email"));
					p.setUsuario(rs.getString("usuario"));
					p.setContraseña(rs.getString("contraseña"));
					p.setHabilitado(rs.getBoolean("habilitado"));
					p.getCategoria().setId_cat(rs.getInt("id_cat"));
					p.getCategoria().setNombre_cat(rs.getString("nombre_cat"));
    		 }
    		 
    	} catch (Exception e ){
    		throw e;
    	} finally {
    		try{
    			if(rs!=null)rs.close();
    			if (stmt!=null)stmt.close();
    			FactoryConexion.getInstancia().releaseConn();
    		}catch (SQLException e ){
    			throw e;
    		}
    	} return p;
    	
    }
    
    public void add (Persona p ) throws Exception{
    	PreparedStatement stmt=null;
    	ResultSet keyResultSet=null;
    	try{ stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
				"insert into persona(dni, nombre, apellido, email, usuario, contraseña,  habilitado, id_cat) values (?,?,?,?,?,?,?,?)",
				PreparedStatement.RETURN_GENERATED_KEYS);
    		  stmt.setString(1,p.getDni());
    		  stmt.setString(2,p.getNombre());
    		  stmt.setString(3,p.getApellido());
    		  stmt.setString(4,p.getEmail());
    		  stmt.setString(5,p.getUsuario());
    		  stmt.setString(6,p.getContraseña());
    		  stmt.setBoolean(7,p.isHabilitado());
    		  stmt.setInt(8,p.getCategoria().getId_cat());
    		  stmt.executeUpdate();
    		  keyResultSet=stmt.getGeneratedKeys();
    		  if (keyResultSet!=null && keyResultSet.next()){
    			  p.setId(keyResultSet.getInt(1));
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

}


