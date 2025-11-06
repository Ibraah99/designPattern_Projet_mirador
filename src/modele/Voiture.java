package modele;

public class Voiture {
	
	  protected int Make_ID;
	  protected String Make_Name;
	  protected int Model_ID;
	  protected String Model_Name;
	  protected int VehicleTypeId;
	  protected String VehicleTypeName;
	  
	  
	  
	  
	  public Voiture() {
		super();
	}
	  public Voiture( String make_Name, String model_Name) {
			
			
			Make_Name = make_Name;
			
			Model_Name = model_Name;
		
		}
	  public Voiture(int make_ID, String make_Name, int model_ID, String model_Name, int vehicleTypeId,
			String vehicleTypeName) {
		
		Make_ID = make_ID;
		Make_Name = make_Name;
		Model_ID = model_ID;
		Model_Name = model_Name;
		VehicleTypeId = vehicleTypeId;
		VehicleTypeName = vehicleTypeName;
	}
	  public int getMake_ID() {
		  return Make_ID;
	  }
	  public void setMake_ID(int make_ID) {
		  Make_ID = make_ID;
	  }
	  public String getMake_Name() {
		  return Make_Name;
	  }
	  public void setMake_Name(String make_Name) {
		  Make_Name = make_Name;
	  }
	  public int getModel_ID() {
		  return Model_ID;
	  }
	  public void setModel_ID(int model_ID) {
		  Model_ID = model_ID;
	  }
	  public String getModel_Name() {
		  return Model_Name;
	  }
	  public void setModel_Name(String model_Name) {
		  Model_Name = model_Name;
	  }
	  public int getVehicleTypeId() {
		  return VehicleTypeId;
	  }
	  public void setVehicleTypeId(int vehicleTypeId) {
		  VehicleTypeId = vehicleTypeId;
	  }
	  public String getVehicleTypeName() {
		  return VehicleTypeName;
	  }
	  public void setVehicleTypeName(String vehicleTypeName) {
		  VehicleTypeName = vehicleTypeName;
	  }

      
}
