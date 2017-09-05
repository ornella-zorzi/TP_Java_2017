package data;
import entity.*;
import util.ApplicationException;
import java.sql.*;
import java.util.ArrayList;

public class DataElemento {
     public ArrayList<Elemento> getAll() throws ApplicationException{
		
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Elemento> elem= new ArrayList<Elemento>();
		try{
			stmt = FactoryConexion.getInstancia()
					.getConn().createStatement();
			rs = stmt.executeQuery("select * from elemento");
			if(rs!=null){
				while(rs.next()){
					Elemento el =new Elemento();
					el.setId_El(rs.getInt("id_el"));
					el.setNombre_El(rs.getString("nombre_el"));
					elem.add(el);
				}
			}
		} catch (Exception e){
			//throw e;
		}
		
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return elem;
	}
}
