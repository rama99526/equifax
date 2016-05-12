package dbunit;

import java.io.File;
import java.nio.charset.Charset;
import java.sql.ResultSet;
import java.sql.Statement;

import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.mssql.InsertIdentityOperation;
import org.h2.tools.RunScript;
import org.springframework.stereotype.Component;

/**
 * Created by rkancharla on 4/26/2016.
 */
@Component
public class Database {

	private static final String JDBC_DRIVER = org.h2.Driver.class.getName();
	private static final String JDBC_URL = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
	private static final String USER = "sa";
	private static final String PASSWORD = "";

	private static IDatabaseTester databaseTester;

	static {
		try {
			RunScript.execute(JDBC_URL, USER, PASSWORD,
					new File("src/main/resources/database/Vehicle_database.sql").getAbsolutePath(),
					Charset.defaultCharset(), true);
			new Database().importGlobalDataSet();;;
		} catch (Exception ex) {
           System.out.println("Error while creating data base");
		}
	}

	public IDatabaseTester getDatabaseTester() {
		return databaseTester;
	}

	private void importGlobalDataSet() throws Exception {
		final String partnerInfoDataSetFile = "vehicle_data.xml";		
		loadDataSetFromFile(partnerInfoDataSetFile);
		

	}

	public void loadDataSetFromFile(String fileName) throws Exception {
		IDataSet dataSet = readDataSet(fileName);
		cleanlyInsert(dataSet);
	}

	private IDataSet readDataSet(String fileName) throws Exception {
		return new FlatXmlDataSetBuilder().build(new File("src/main/resources/data/" + fileName));
	}

	private void cleanlyInsert(IDataSet dataSet) throws Exception {
		if (databaseTester == null) {
			databaseTester = new JdbcDatabaseTester(JDBC_DRIVER, JDBC_URL, USER, PASSWORD);
		}
		databaseTester.getConnection().getConfig().setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY,
				new org.dbunit.ext.h2.H2DataTypeFactory());
		databaseTester.setSetUpOperation(InsertIdentityOperation.CLEAN_INSERT);
		databaseTester.setDataSet(dataSet);
		databaseTester.onSetup();
	}

	public static void main(String args[]) throws Exception {
		
		//ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		if (databaseTester == null) {
			databaseTester = new JdbcDatabaseTester(JDBC_DRIVER, JDBC_URL, USER, PASSWORD);
		}
		final IDatabaseConnection connection = databaseTester.getConnection();
		final Statement statement = connection.getConnection().createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM VEHICLE");
		while(resultSet.next()){
			System.out.println("V_ID"+ resultSet.getString("V_ID"));
		}
		System.out.println("Query executed");

		
	}

}
