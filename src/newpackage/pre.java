package newpackage;

 

import java.io.File;
import java.io.IOException;

public class pre {

    public static String fs=System.getProperty("file.separator");
    public static String hd=System.getProperty("user.home");

    public static String dbfolder="dbtest";

    public static String dbname="test.db";

    public static String dbfullpath=hd + fs + dbfolder + fs + dbname;

	public static void main(String[] args) {

		File path = new File(hd + fs + dbfolder);

		if (!path.exists()) {
                    path.mkdir();
                    }
        try{
		File dbfile = new File(dbfullpath);
 		if (dbfile.createNewFile()){
                    //String sql = null;
                    //sql = "CREATE TABLE IF NOT EXISTS list (hostname STRING PRIMARY KEY, ip STRING, uid STRING, pass STRING, description STRING, app STRING, tsocks STRING)";
                    //selectdb.write(sql);                                
                    }
	}catch (IOException e) {
	}
        }        
}