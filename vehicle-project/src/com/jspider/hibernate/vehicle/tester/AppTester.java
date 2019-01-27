package com.jspider.hibernate.vehicle.tester;

import java.util.List;

import com.jspider.hibernate.vehicle.dao.VehicleDAO;
import com.jspider.hibernate.vehicle.dto.VehicleDTO;

public class AppTester
{
	public static void main(String[] args) 
	{
		//SAVE
		/*VehicleDTO dto=new VehicleDTO();
		
		dto.setVehicleId(3);
		dto.setVehicleName("pulser");
		dto.setMileage(60.05);
		dto.setTopSpeed(220);
		dto.setPrice(600000);
		
		VehicleDAO dao=new VehicleDAO();
		dao.saveVehicle(dto);*/
		
		//UPDATE_PRICE_BY_MILEAGE
		/*
		VehicleDTO dto= new VehicleDTO();
		VehicleDAO dao=new VehicleDAO();
		int noOfRecordsUpdated=dao.updatePriceByNameAndMileage("pulser", 60.05, 65000);
		System.out.println("Number of Records "+ noOfRecordsUpdated);
		*/
	
		/*ERROR
		VehicleDAO dao=new VehicleDAO();
		String vehicleName= dao.getVehicleNameByMileageGreaterThan(21);
			System.out.println("Vehicle Name"+vehicleName);
		*/
		
		
		//Vehicle_Name_Mileage_Greater_Than
		/*
		VehicleDTO dto= new VehicleDTO();
		VehicleDAO dao=new VehicleDAO();
		List<VehicleDTO>vehicleName=dao.getVehicleNameByMileageGreaterThan(21);
		System.out.println("VEHICLE NAME WHOSE MILEAGE>20 "+vehicleName);
		*/
		
	
		/*GET_VEHICLE_BY_TOPSPEED
	 	VehicleDTO dto= new VehicleDTO();
		VehicleDAO dao=new VehicleDAO();
		String Name=dao.getVehicleByTopSpeed(120);
		System.out.println("Vehicle_Name:- "+Name);
	 	
	 */
		
		
		//Update_TopSpeed_By_VehicleName
		/*
		VehicleDTO dto= new VehicleDTO();
		VehicleDAO dao=new VehicleDAO();
		int noOfRecordsUpdated=dao.UpdateTopSpeedByVehicleName( 80,"Maruti-car");
		System.out.println("Number of records updated :--"+noOfRecordsUpdated);*/
	
	//GET_MIN_MILEAGE
	/*
	VehicleDTO dto= new VehicleDTO();
	VehicleDAO dao=new VehicleDAO();
	List<VehicleDTO>mileage=dao.getMinMileage();
	System.out.println("Min Mileage is:-- "+ mileage);*/

		
		
	//GET_MAX_TOPSPEED
/*	VehicleDTO dto= new VehicleDTO();
	VehicleDAO dao=new VehicleDAO();
	List<VehicleDTO>topSpeed=dao.getMaxTopSpeed();
	System.out.println("Max TOPSPEED is:-- "+ topSpeed);*/
		
		
		
	//GET_VEHICLE_COUNT
	/*		VehicleDTO dto= new VehicleDTO();
	VehicleDAO dao=new VehicleDAO();
	List<VehicleDTO>topSpeed=dao.getVehicleCount();		System.out.println("Total Number Of Vehicle :-- "+ topSpeed);*/
	
		
		
		VehicleDTO dto= new VehicleDTO();
		VehicleDAO dao=new VehicleDAO();
		int noOfRecordsDeleted=dao.deleteVehicleByName("cycle");
		System.out.println("No of Records Deleted-- "+ noOfRecordsDeleted  );
}
}